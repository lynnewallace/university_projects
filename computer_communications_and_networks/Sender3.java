/* Lynne Wallace 0829961 */

// COMN coursework
// Go back n sender

import java.io.*;
import java.net.*;
import java.util.LinkedHashMap;

public class Sender3 {
	
	public static LinkedHashMap<String, DatagramPacket> packetList = new LinkedHashMap<String, DatagramPacket>();
	public static int sequenceNumber;
	public static BufferedInputStream inputStream;
	
	public static InetAddress address;
	public static byte[] sendData;
	public static DatagramSocket socket;
	
	// arguments - host, receiver port, file, timeout, window size
	public static void main(String[] args) throws Exception {
		
		// Check for correct number of args
		if (args.length != 5) {
			System.out.println("Program takes 5 arguments - hostname, port, file, timeout and window size");
			System.exit(1);
		}

		// File to read data from
		inputStream = new BufferedInputStream(new FileInputStream(args[2]));

		// Network components
		socket = new DatagramSocket(Integer.valueOf(args[1])+1);
		socket.setSoTimeout(Integer.valueOf(args[3]));
		address = InetAddress.getByName(args[0]);
		int windowSize = Integer.valueOf(args[4]);
		
		byte[] ackData = new byte[2];
		
		DatagramPacket receivePacket = new DatagramPacket(ackData, ackData.length);
		DatagramPacket packet;

		// Keep track of sequence number, base number and if correct ACK
		sequenceNumber = 1;
		int baseNumber = 1;
		boolean correctAck = false;
		
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
				
				// Try receive ACK
				try {
					
					// Receive and get data
					socket.receive(receivePacket);
					ackData = receivePacket.getData();
					
					// Is the ACK for the base packet?
					correctAck = getAckStatus(ackData, baseNumber);
				} catch (SocketTimeoutException e) {
					sendAllPackets();
				}
				
				// If ack is for packet above base number
				if(getSequenceNumber(ackData) > baseNumber) {
					
					// Remove ACKed packets
					for(int i=baseNumber; i<getSequenceNumber(ackData); i++) {
						packetList.remove(String.valueOf(i));
					}
					
					// Update base number
					baseNumber = getSequenceNumber(ackData);
					correctAck = true;
					
					// Add more packets until window is full
					while(packetList.size() < windowSize) {
						
						// If data left
						if(inputStream.available() == 0) {
							break;
						}
						getDataSize();
						packet = addPacket(Integer.valueOf(args[1]));
						socket.send(packet);
					}
				}
				
				// If ACK is for base packet
				if(correctAck) {
					
					// Remove ACKed packet from packet list
					packetList.remove(String.valueOf(baseNumber));
					
					// If nothing remains, finish
					if(packetList.size() == 0 && inputStream.available() == 0) {
						break;
					}
					
					// If data left
					if(inputStream.available() > 0) {
						getDataSize();
						packet = addPacket(Integer.valueOf(args[1]));
					} else {
						
						// Find oldest unACKed packet
						packet = getBasePacket();
					}
					
					socket.send(packet);
					baseNumber = getSequenceNumber(ackData) + 1;
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
        	DatagramPacket sendPacket = (DatagramPacket) packetList.get(keys[i]);
        	socket.send(sendPacket);
        }  
	}
	
	// Check ACK sequence number against base number
	public static boolean getAckStatus(byte[] packet, int expectedNumber) {
		int ackSequenceNumber = getSequenceNumber(packet);
		if (ackSequenceNumber == expectedNumber){
			return true;
		} 
		return false;
	}
	
	public static int getSequenceNumber(byte[] data) {
		return ((data[0] << 8) & 0x0000FF00)|(data[1] & 0x000000FF);
	}
	
	public static DatagramPacket getBasePacket() {
		String[] keys = packetList.keySet().toArray(new String[packetList.size()]);
        
		return packetList.get(keys[0]);
	}
}