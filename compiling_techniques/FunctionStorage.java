/*
 * s0829961
 * Compiling Techniques
 * FunctionStorage allows us to create objects that
 * hold details about functions which we then store in 
 * the main symbol table
 *
 */

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.antlr.runtime.tree.Tree;

public class FunctionStorage {
	
	private String returnType;
	// List of all arguments and their types
	private LinkedHashMap<String, String> args;
	// List of all local variable with type
	private LinkedHashMap<String, String> localVarStorage;
	private Tree statements;
	// List of which register holds which variable
	private HashMap<String, Integer> registerStorage;

	public FunctionStorage(String returnType, LinkedHashMap<String, String> args, LinkedHashMap<String, String> localVarStorage, Tree statements, HashMap<String, Integer> registerStorage) {
		this.returnType = returnType;
		this.args = args;
		this.localVarStorage = localVarStorage;
		this.statements = statements;
		this.registerStorage = registerStorage;
	}
	
	public String getReturnType() {
		return returnType;
	}
	
	public LinkedHashMap<String, String> getArgs() {
		return args;
	}
	
	public int getArgsSize() {
		return args.size();
	}
	
	public LinkedHashMap<String, String> getLocalVarStorage() {
		return localVarStorage;
	}
	
	public Tree getStatements() {
		return statements;
	}
	
	public HashMap<String, Integer> getRegisterStorage() {
		return registerStorage;
	}
	
	public void setRegisterStorage(HashMap<String, Integer> registerStorage) {
		this.registerStorage = registerStorage;
	}
}