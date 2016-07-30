/* Lynne Wallace 0829961 */

// COMN coursework
// Basic receiver

import java.io.*;
import java.net.*;

public class Receiver1 {
	
	// arguments - port, filename
	public static void main(String[] args) throws Exception {
		
		// Check for correct number of args
		if (args.length != 2) {
			System.out.println("Program takes 2 arguments - port, filename");
			System.exit(1);
		}
		
		// File to write data to
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[1]));

		// Network components
		DatagramSocket socket = new DatagramSocket(Integer.valueOf(args[0]));
		byte[] data = new byte[1024];
		DatagramPacket packet;
		
		// Tracking EOF
		boolean eof = false;
		
		// While packets are still coming
		while(!eof) {
			
			// Receive packet
			packet = new DatagramPacket(data, data.length);
			socket.receive(packet);
			
			// Retrieve the data
			data = packet.getData();

			// Write to file
			outputStream.write(data, 3, packet.getLength()-3);
			
			// Check if end
			eof = isEof(data);
		}
		
		// Clean up
		outputStream.close();
		socket.close();
		System.out.println("Finished");
	}

	public static boolean isEof(byte[] data) {
		int eof = data[2] & 0x000000FF;

		if(eof == 1) {
			return true;
		}
		return false;
	}
}