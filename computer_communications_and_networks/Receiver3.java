/* Lynne Wallace 0829961 */

// COMN coursework
// Go back n receiver

import java.io.*;
import java.net.*;

public class Receiver3 {

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
		int expectedNumber = 1;
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

			// If packet sequence number is the expected number
			sequenceNumber = getSequenceNumber(receiveData);

			if(expectedNumber == sequenceNumber) {
				expectedNumber++;
				
				// Write out data to file
				outputStream.write(receiveData, 3, receivePacket.getLength()-3);
			}
			
			// Put last in sequence number into ACK
			createACK(ackData, expectedNumber-1); 

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

		// Clean up
		outputStream.close();
		socket.close();
		System.out.println("Finished");
	}

	public static int getSequenceNumber(byte[] data) {
		return ((data[0] << 8) & 0x0000FF00)|(data[1] & 0x000000FF);
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