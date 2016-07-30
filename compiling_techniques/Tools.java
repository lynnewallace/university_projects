/*
 * s0829961
 * Compiling Techniques
 * Helper functions
 *
 */

import java.util.HashMap;

import org.objectweb.asm.Opcodes;

public class Tools implements Opcodes{
	
	public static void setGlobalTable(HashMap<String, String> globalStorage) {
		CodeGenerator.globalStorage = globalStorage;
	}
	
	public static void setFunctionTable(HashMap<String, FunctionStorage> functionStorage) {
		CodeGenerator.functionStorage = functionStorage;
	}
	
	// Put all conditions available in hashmap with string literal to get correct one
	public static void populateConditionTable(HashMap<String,Integer> conditionTable) {
		conditionTable.put("<", IF_ICMPLT);
		conditionTable.put(">", IF_ICMPGT);
		conditionTable.put("<=", IF_ICMPLE);
		conditionTable.put(">=", IF_ICMPGE);
		conditionTable.put("!=", IF_ACMPNE);
		conditionTable.put("==", IF_ICMPNE);
	}
	
	// Put all math symbols in hashmap with string literal to get correct one
	public static void populateMathTable(HashMap<String,Integer> mathTable) {
		mathTable.put("+", IADD);
		mathTable.put("-", ISUB);
		mathTable.put("/", IDIV);
		mathTable.put("*", IMUL);
		mathTable.put("%", IREM);	
	}
	
	// Enum for switch statements
	public enum StatementNames {
		WHILE,
		IF,
		READ, 
		OUTPUT,
		PRINT,
		RETURN,
		READC,
		OUTPUTC,
		ASSIGN,
		FUNCNAME
	}
}