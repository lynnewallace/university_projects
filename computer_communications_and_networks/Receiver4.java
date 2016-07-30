/* Lynne Wallace 0829961 */

// COMN coursework
// Selective repeat receiver

import java.io.*;
import java.net.*;
import java.util.LinkedHashMap;

// Everything is good except buffer stores the same packet multiple times under different sequence numbers
public class Receiver4 {
	
	public static BufferedOutputStream outputStream;
	public static LinkedHashMap<String, DatagramPacket> packetList = new LinkedHashMap<String, DatagramPacket>();

	// arguments - port, filename and window size
	public static void main(String[] args) throws Exception {
		
		// Check for correct number of arguments
		if (args.length != 3) {
			System.out.println("Program takes 3 arguments - port, filename and window size");
			System.exit(1);
		}

		// File to write data to
		outputStream = new BufferedOutputStream(new FileOutputStream(args[1]));

		// Network components
		DatagramSocket socket = new DatagramSocket(Integer.valueOf(args[0]));
		InetAddress address;
		DatagramPacket ackPacket;
		DatagramPacket receivePacket;

		int windowSize = Integer.valueOf(args[2]);

		byte[] receiveData = new byte[1024];
		byte[] ackData = new byte[2];

		// Tracking sequence number, expected number and EOF
		int baseNumber = 1;
		int sequenceNumber;
		boolean eof = false;

		// While packets are still to come
		while(!eof) {

			// Receive packet
			receivePacket = new DatagramPacket(receiveData, receiveData.length);
			socket.receive(receivePacket);

			// Retrieve the data
			receiveData = receivePacket.getData();
			address = receivePacket.getAddress();

			// If packet sequence number is the expected number
			sequenceNumber = getSequenceNumber(receiveData);
			if(baseNumber == sequenceNumber) {
				baseNumber++;
				
				// Write data to file
				writePacketData(receivePacket);

				// Check to see if buffered packets are now the expected number
				if(packetList.size() > 0) {
					
					while(true) {
						if (packetList.size() > 0 && checkPacketBuffer(baseNumber)) {
							baseNumber++;
						} else {
							break;
						}
					}
				}
				

			// If a different packet
			} else if (sequenceNumber > baseNumber && sequenceNumber < baseNumber + windowSize) {

				// Add packet to buffer
				packetList.put(String.valueOf(sequenceNumber), receivePacket);
			}
			
			// Send back ACK if in correct range
			if (sequenceNumber >= baseNumber - windowSize && sequenceNumber < baseNumber + windowSize) {

				// Put data in packet - return sequence number
				createACK(ackData, sequenceNumber);

				// Check if end
				eof = isEof(receiveData);

				// Send packet
				ackPacket = new DatagramPacket(ackData, ackData.length, address, Integer.valueOf(args[0]) + 1);
				socket.send(ackPacket);

				// If its the last packet send 20 extra times for safety
				if(eof) {
					for(int i = 0; i<20; i++) {
						socket.send(ackPacket);
					}
				}
			}
		}
		
		// Clean up
		outputStream.close();
		socket.close();
		System.out.println("Finished");
	}	
	
	public static int getSequenceNumber(byte[] data) {
		return ((data[0] << 8) & 0x0000FF00)|(data[1] & 0x000000FF);
	}
	
	// Writes data to file
	public static void writePacketData(DatagramPacket packet) throws IOException{
		byte[] data = packet.getData(); 
		outputStream.write(data, 3, packet.getLength()-3);
	}
	
	// Checks and writes now in sequence packets
	public static boolean checkPacketBuffer(int expectedNumber) throws IOException {
		
		if(packetList.containsKey(String.valueOf(expectedNumber))) {

			// Get data
			DatagramPacket packet = packetList.get(String.valueOf(expectedNumber));
			
			writePacketData(packet);
			packetList.remove(String.valueOf(expectedNumber));
			
			return true;	
		}
		return false;
	}

	// Create ACK with sequence number
	public static byte[] createACK(byte[] packet, int sequenceNumber) {
		packet[0] = (byte) (sequenceNumber >>> 8);
		packet[1] = (byte) sequenceNumber;
		return packet;
	}
	
	public static boolean isEof(byte[] data) {
		int eof = data[2] & 0x000000FF;
		
		if(eof == 1) {
			return true;
		}
		return false;
	}
}