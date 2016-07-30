/* Lynne Wallace 0829961 */

// COMN coursework
// Selective repeat sender

import java.io.*;
import java.net.*;
import java.util.LinkedHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Sender4 {
	
	public static LinkedHashMap<String, DatagramPacket> packetList = new LinkedHashMap<String, DatagramPacket>();
	public static LinkedHashMap<String, ScheduledFuture<?>> timeoutList = new LinkedHashMap<String, ScheduledFuture<?>>();
	public static int sequenceNumber;
	public static BufferedInputStream inputStream;
	
	public static InetAddress address;
	public static byte[] sendData;
	public static DatagramSocket socket;
	public static int timeoutLength;
	
	public static ScheduledExecutorService packetSend = Executors.newSingleThreadScheduledExecutor();
	public static ScheduledFuture<?> sender;
	
	// arguments - host, receiver port, file, timeout, window size
	public static void main(String args[]) throws Exception {

		// Check for correct number of args
		if (args.length != 5) {
			System.out.println("Program takes 5 arguments - hostname, port, file, timeout and window size");
			System.exit(1);
		}

		// File to read data from
		inputStream = new BufferedInputStream(new FileInputStream(args[2]));

		// Network components
		socket = new DatagramSocket(Integer.valueOf(args[1])+1);
		timeoutLength = Integer.valueOf(args[3]);    
		address = InetAddress.getByName(args[0]);
		int windowSize = Integer.valueOf(args[4]);

		byte[] ackData = new byte[2];

		DatagramPacket receivePacket = new DatagramPacket(ackData, ackData.length);
		DatagramPacket packet;

		// Keep track of sequence number and base number
		sequenceNumber = 1;
		int ackNumber;
		int baseNumber = 1;
		
		// Create first n packets
		while(packetList.size() < windowSize) {
			getDataSize();
			addPacket(Integer.valueOf(args[1]));
		}

		// Track timing and file size
		float fileSize = (float) inputStream.available()/1021;
		final long startTime = System.nanoTime();
		final long endTime;

		try {

			// Send all packets in window
			sendAllPackets();

			// While data is still left
			while(packetList.size() > 0) {

				// Receive and get data
				socket.receive(receivePacket);
				ackData = receivePacket.getData();			

				ackNumber = getSequenceNumber(ackData);

				// If packet needs to be ACKed
				if(packetList.containsKey(String.valueOf(ackNumber))) {

					// Remove ACKed packet from packet list
					packetList.remove(String.valueOf(ackNumber));
					
					// Cancel packet timer
					sender = timeoutList.get(String.valueOf(ackNumber));
					sender.cancel(true);
					timeoutList.remove(String.valueOf(ackNumber));

					// If nothing remains, finish
					if(packetList.size() == 0 && inputStream.available() == 0) {
						break;
					}
					
					// Check if base packet
					if(ackNumber == baseNumber) {
						
						// Update base to lowest packet sequence number
						if(packetList.size() > 0) {
							baseNumber = getSequenceNumber(getBasePacket().getData());
						} else {

							// Add more packets until window is full
							while(packetList.size() < windowSize) {

								// If data left
								if(inputStream.available() == 0) {
									break;
								}
								getDataSize();
								packet = addPacket(Integer.valueOf(args[1]));

								// Set up retransmission timeout/sender
								sender = packetSend.scheduleAtFixedRate(new PacketSender(packet, socket), 0, timeoutLength, TimeUnit.MILLISECONDS);
								timeoutList.put(String.valueOf(sequenceNumber - 1), sender);
							}
							baseNumber = getSequenceNumber(getBasePacket().getData());
						}
					}

					if(packetList.size() < windowSize) {
						
						// Add new packet if window is not full
						if (sequenceNumber > baseNumber && sequenceNumber < baseNumber + windowSize) {

							// If data left
							if(inputStream.available() > 0) {
								getDataSize();
								packet = addPacket(Integer.valueOf(args[1]));

								// Set up retransmission timeout/sender
								sender = packetSend.scheduleAtFixedRate(new PacketSender(packet, socket), 0, timeoutLength, TimeUnit.MILLISECONDS);
								timeoutList.put(String.valueOf(sequenceNumber - 1), sender);
							}
						}
					}
				}
			}
		} finally {
			endTime = System.nanoTime();
		}

		// Get duration
		float duration = (float)(endTime - startTime)/(float)1000000000;

		// Print out details
		System.out.printf("Average throughput is %.2f KB/s\n",fileSize/duration);

		// Clean up
		inputStream.close();
		socket.close();
		packetSend.shutdown();
		System.out.println("Finished");	
	}

	public static void getDataSize() throws IOException {
		int numberLeft = inputStream.available();
		
		// If full packet
		if (numberLeft >= 1021){
			sendData = new byte[1024];
			
		//If non full packet
		} else {
			sendData = new byte[numberLeft+3];
		}
	}
	
	public static DatagramPacket addPacket(int port) throws IOException {
		
		// Is last packet?
		int eof = isEnd();
		
		// Add data to packet
		addHeader(sendData, sequenceNumber, eof);
		inputStream.read(sendData, 3, sendData.length-3);
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port); 
		
		// Add packet
		packetList.put(String.valueOf(sequenceNumber), sendPacket);
		sequenceNumber++;
		
		return sendPacket;
	}
	
	public static int isEnd() throws IOException {

		// If last packet
		if(inputStream.available() <= 1021){
			return 1;
		}
		return 0;
	}

	// Add sequence number and EOF flag to packet
	public static byte[] addHeader(byte[] packet, int sequenceNumber, int eofFlag) {
		packet[0] = (byte) (sequenceNumber >>> 8);
		packet[1] = (byte) sequenceNumber;
		packet[2] = (byte) eofFlag;
		return packet;
	}

	public static void sendAllPackets() throws IOException {
		String[] keys = packetList.keySet().toArray(new String[packetList.size()]);
        
        for (int i = 0; i<packetList.size(); i++) {
        	
        	// Get packet
        	DatagramPacket sendPacket = (DatagramPacket) packetList.get(keys[i]);
        	
        	// Set up retransmission timeout/sender
        	sender = packetSend.scheduleAtFixedRate(new PacketSender(sendPacket, socket), 0, timeoutLength, TimeUnit.MILLISECONDS);
        	timeoutList.put(String.valueOf(getSequenceNumber(sendPacket.getData())), sender);
        }  
	}
	
	public static int getSequenceNumber(byte[] data) {
		return ((data[0] << 8) & 0x0000FF00)|(data[1] & 0x000000FF);
	}
	
	public static DatagramPacket getBasePacket() {
		String[] keys = packetList.keySet().toArray(new String[packetList.size()]);
        
		return packetList.get(keys[0]);
	}	
}

class PacketSender implements Runnable {
    
	DatagramPacket sendPacket;
	DatagramSocket socket;
	
	public PacketSender(DatagramPacket sendPacket, DatagramSocket socket) {
	    this.sendPacket = sendPacket;
	    this.socket = socket;
	}
	
	@Override
    public void run(){
		
		try {
			socket.send(sendPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
