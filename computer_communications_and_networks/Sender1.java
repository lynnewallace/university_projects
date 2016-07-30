/* Lynne Wallace 0829961 */

// COMN coursework
// Basic sender

import java.io.*;
import java.net.*;

public class Sender1 {
	
	// arguments - host, receiver port, file
	public static void main(String[] args) throws Exception {
		
		// Check for correct number of args
		if (args.length != 3) {
			System.out.println("Program takes 3 arguments - hostname, port, file");
			System.exit(1);
		}
		
		// File to read data from
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[2]));
		
		// Network components
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName(args[0]);
		byte[] data;
		
		// Tracking sequence number and EOF
		int sequenceNumber = 1;
		int eof = 0;
		
		// While data is still left
		int numberLeft = inputStream.available();
		while (numberLeft > 0) {
			
			// If last packet
			if (numberLeft <= 1021) {
				eof = 1;
			}
			
			// If full packet
			if (numberLeft >= 1021) {
				data = new byte[1024];
				inputStream.read(data, 3, 1021);
			
			//If non full packet
			} else {
				data = new byte[numberLeft + 3];
				inputStream.read(data, 3, numberLeft);
			}
			
			// Put headers in packet
			data = addHeader(data, sequenceNumber, eof);
						
			//Send packet
			DatagramPacket packet = new DatagramPacket(data, data.length, address, Integer.valueOf(args[1])); 
			socket.send(packet);
			
			// Update data
			sequenceNumber++;
			numberLeft = inputStream.available();
		}
		
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
}