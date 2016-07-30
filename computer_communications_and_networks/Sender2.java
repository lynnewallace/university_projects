/* Lynne Wallace 0829961 */

// COMN coursework
// Stop and wait sender

import java.io.*;
import java.net.*;

public class Sender2 {

	// arguments - host, receiver port, file, timeout
	public static void main(String[] args) throws Exception {
		
		// Check for correct number of args
		if (args.length != 4) {
			System.out.println("Program takes 4 arguments - hostname, port, file, timeout");
			System.exit(1);
		}

		// File to read data from
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[2]));

		// Network components
		DatagramSocket socket = new DatagramSocket(Integer.valueOf(args[1])+1);
		socket.setSoTimeout(Integer.valueOf(args[3]));
		InetAddress address = InetAddress.getByName(args[0]);

		byte[] sendData;
		byte[] ackData = new byte[2];
		
		DatagramPacket receivePacket = new DatagramPacket(ackData, ackData.length);

		// Tracking sequence number, timeouts and EOF
		int sequenceNumber = 0;
		int eof = 0;
		int timeouts = 0;
		
		// Track timing and file size
		float fileSize = (float) inputStream.available()/1021;
		final long startTime = System.nanoTime();
		final long endTime;
		
		try {
			
			// While data is still left
			int numberLeft = inputStream.available();
			while(numberLeft > 0) { 
				
				// If last packet
				if(numberLeft <= 1021){
					eof = 1;
				}
				
				// If full packet
				if (numberLeft >= 1021){
					sendData = new byte[1024];
					inputStream.read(sendData, 3, 1021);
					
				//If non full packet
				} else {
					sendData = new byte[numberLeft+3];
					inputStream.read(sendData, 3, numberLeft);
				}
				
				// Put headers in packet
				sendData = addHeader(sendData, sequenceNumber, eof);
				
				// Create packet
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, Integer.valueOf(args[1])); 
				
				// While no correct ACK is received
				boolean ack = false;
				while(!ack){
					
					// Send packet
					socket.send(sendPacket);
					
					// Try receive ACK
					try{
						
						// Receive and get data
						socket.receive(receivePacket);
						ackData = receivePacket.getData();
						
						// Correct ACK?
						ack = getAckStatus(ackData, sequenceNumber);
					} catch (SocketTimeoutException e) {
						timeouts++;
					}
				}

				// Update data
				sequenceNumber = alternateNumber(sequenceNumber);
				numberLeft = inputStream.available();		
			}

		// Get end time
		} finally {
			endTime = System.nanoTime();
		}
		
		// Get duration
		float duration = (float)(endTime - startTime)/(float)1000000000;
		
		// Print out details
		System.out.printf("Average throughput is %.2f KB/s\n",fileSize/duration);
		System.out.printf("Number of timeouts %d\n", timeouts);
		
		// Clean up
		inputStream.close();
		socket.close();
		System.out.println("Finished");	
	}
	
	// Add sequence number and EOF flag to packet
	public static byte[] addHeader(byte[] packet, int sequenceNumber, int eofFlag) {
		packet[0] = (byte) (sequenceNumber >>> 8);
		packet[1] = (byte) sequenceNumber;
		packet[2] = (byte) eofFlag;
		return packet;
	}
	
	// Alternate between 0 and 1
	public static int alternateNumber(int expectedNumber) {
		if (expectedNumber == 0) {
			return 1;
		}
		return 0;
	}
	
	// Check ACK sequence number against expected sequence number
	public static boolean getAckStatus(byte[] packet, int expectedNumber) {
		int ackSequenceNumber = ((packet[0] << 8) & 0x0000FF00)|(packet[1] & 0x000000FF);
		if (ackSequenceNumber == expectedNumber){
			return true;
		} 
		return false;
	}
}