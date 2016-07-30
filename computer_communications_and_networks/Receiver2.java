/* Lynne Wallace 0829961 */

// COMN coursework
// Stop and wait receiver

import java.io.*;
import java.net.*;

public class Receiver2 {
	
	// arguments - port, filename
	public static void main(String[] args) throws Exception {

		// Check for correct number of arguments
		if (args.length != 2) {
			System.out.println("Program takes 2 arguments - port, filename");
			System.exit(1);
		}
		
		// File to write data to
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[1]));

		// Network components
		DatagramSocket socket = new DatagramSocket(Integer.valueOf(args[0]));
		InetAddress address;
		DatagramPacket ackPacket;
		DatagramPacket receivePacket;

		byte[] receiveData = new byte[1024];
		byte[] ackData = new byte[2];

		// Tracking sequence number, expected number and EOF
		int expectedNumber = 0;
		int sequenceNumber;
		boolean eof = false;

		// While packets are still coming
		while(!eof) {

			// Receive packet
			receivePacket = new DatagramPacket(receiveData, receiveData.length);
			socket.receive(receivePacket);

			// Retrieve the data
			receiveData = receivePacket.getData();
			address = receivePacket.getAddress();

			// If sequence number equals expected number
			sequenceNumber = getSequenceNumber(receiveData);
			
			if(expectedNumber == sequenceNumber) {

				// Alternate between 0 and 1
				expectedNumber = alternateNumber(expectedNumber);

				// Write to file
				outputStream.write(receiveData, 3, receivePacket.getLength()-3);
			}

			// Send back ACK 
			if(expectedNumber != sequenceNumber) {
				
				// Put data in packet
				createACK(ackData, sequenceNumber);

				// Check if end
				eof = isEof(receiveData);

				// Send packet
				ackPacket = new DatagramPacket(ackData, ackData.length, address, Integer.valueOf(args[0]) + 1);
				socket.send(ackPacket);
				
				// If last packet send 20 times extra for safety
				if(eof) {
					for(int i = 0; i < 20; i++) {
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

	// Alternate between 0 and 1
	public static int alternateNumber(int expectedNumber) {
		if (expectedNumber == 0) {
			return 1;
		}
		return 0;
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