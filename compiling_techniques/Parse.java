/*
 * s0829961
 * Compiling Techniques
 * Program takes in a Small-C file
 * Converts to an immediate representation
 * Checks code semantics 
 * Outputs a JVM bytecode file 
 *
 */

import java.io.IOException;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Parse {
	
	public static void main(String[] args) throws Exception {

		// Outputs error message and exits if input gives the wrong number of arguments
		if (args.length != 2){
			System.out.println("Program takes 2 arguments: Small-C file to convert and the JVM bytecode filename\n");
			System.exit(1);
		}
		
		// Creates immediate representation
		CommonTree tree = parseFile(args[0]);
		
		// Analyzes IR for mistakes and creates symbol tables
		SemanticAnalysis.checkTree(tree);
		
		// Generates bytecode file using the symbol tables
		CodeGenerator.createBytecode(args[1]);
		
		System.out.printf("Success: output is in %s.class\n", args[1]);
	}
	
	// Parses Small-C file into IR
	private static CommonTree parseFile(String inputFile) throws RecognitionException {
		CharStream inputStream = null;

		// Outputs error message and exits if inputFile does not correspond to a file
		try {
			inputStream = new ANTLRFileStream(inputFile);
		} catch (IOException e) {
			System.out.println("Argument 1 does not correspond to a Small-C file\n");
			System.exit(1);
		}

		// Sets up the parser
		smallcLexer lexer = new smallcLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		smallcParser parser = new smallcParser(tokens);

		// Runs parser and returns the abstract syntax tree if no errors are found
		smallcParser.program_return parserReturn = parser.program();
		
		int errorNumber = parser.getNumberOfSyntaxErrors();
		if (errorNumber != 0) {
			System.out.printf("There are %d syntax errors\n", errorNumber);
			System.exit(1);
		}

		CommonTree tree = (CommonTree)parserReturn.getTree(); 
		return tree;
	}
}