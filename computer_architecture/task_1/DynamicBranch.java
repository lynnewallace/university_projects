// s0829961 Lynne Wallace
// Complete dynamic branch predictor
// Inputs - trace file, branch predictor table size
// Outputs - technique, misprediction rate

import java.io.*;
import java.util.LinkedHashMap;

public class DynamicBranch {

	public static void main(String[] args) throws Exception {
		
		// Check for correct number of args
		if (args.length != 2) {
			System.out.println("Program takes 2 arguments - filename, number of entries");
			System.exit(1);
		}
		
		// Set up file to read
		FileInputStream inputStream = new FileInputStream(args[0]);
		BufferedReader trace = new BufferedReader(new InputStreamReader(new DataInputStream(inputStream)));
		
		// Get entries
		int entries = Integer.valueOf(args[1]);
		
		// Prediction branches
		predict(trace, entries);
	}
 
	public static void predict(BufferedReader file, int entries) throws IOException {
		LinkedHashMap<Integer, Integer> table = new LinkedHashMap<Integer, Integer>();
		
		// File variables
		String fullLine;
		String location;
		int taken;
		
		// Predictor variables
		int address;
		int predictor;
		int predictTaken;
		
		// Misprediction variables
		int correct = 0;
		int total = 0;	

		// While still branch instructions
		while ((fullLine = file.readLine()) != null)   {
			
			// Get instruction data
			location = fullLine.substring(2, fullLine.length() - 2);
			taken = Integer.parseInt(fullLine.substring(fullLine.length() - 1, fullLine.length()));

			// Convert location for branch predictor table
			address = Integer.valueOf(location, 16) % entries;	
						
			// Is address in table
			if (!table.containsKey(address)) {
				
				// Add to table
				table.put(address, 0);
				predictor = 0;
				
			// Get value
			} else {
				predictor = table.get(address);
			}
			
			// Is predictor taken or not taken
			if(predictor > 1) {
				predictTaken = 1;
			} else {
				predictTaken = 0;
			}
			
			// Correct prediction
			if (predictTaken == taken) {
				correct++;
			}
			total++;
			
			// Update predictor
			// Go forward a prediction
			if((predictTaken == taken && predictTaken == 1) || (predictTaken != taken && predictTaken == 0)) {
				switch(predictor) {
				case 0:
					predictor = 1;
					break;
				case 1:
					predictor = 2;
					break;
				case 2:
					predictor = 3;
					break;
				case 3:
					break;
				}
			// Go back a prediction
			} else {
				switch(predictor) {
				case 0:
					break;
				case 1:
					predictor = 0;
					break;
				case 2:
					predictor = 1;
					break;
				case 3:
					predictor = 2;
					break;
				}
			}
			
			// Update table
			table.put(address, predictor);
		}
		
		// Calculate and print misprediction
		float misprediction = (float) ((total-correct)*100.0/total*1.0);

		System.out.printf("\nPredictor: dynamic\n"); 
		System.out.printf("Misprediction rate: %.4f\n", misprediction);
	}
}