/*
 * s0829961
 * Compiling Techniques
 * Checks the AST for semantic errors
 * Creates symbol tables with the details
 *
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class SemanticAnalysis {
	
	private static HashMap<String, String> globalStorage = new HashMap<String, String>();
	private static HashMap<String, FunctionStorage> functionStorage = new HashMap<String, FunctionStorage>();

	public static void checkTree(CommonTree tree) throws IOException {
		
		// Outputs error message and exits if there is no tree
		if (tree == null) {
			System.out.println("There is no tree");
			System.exit(1);
		}	
		
		// Loop through tree, check semantics
		// Creates symbol tables
		for (int i=0; i<tree.getChildCount(); i++) {
			Tree currentChild = tree.getChild(i);
			String nodeName = currentChild.toString();
			
			// Global variables
			if (nodeName=="DECLARE") {
				checkGlobalDeclare(currentChild);
				
			// Procedures
			} else if (nodeName=="PROCEDURE") {
				checkProcedure(currentChild);
				
			// Main
			} else if (nodeName=="MAIN") {
				LinkedHashMap<String, String> localStore = new LinkedHashMap<String, String>();
				
				checkBody("main", localStore, currentChild.getChild(0));
				FunctionStorage function = new FunctionStorage("void", null, localStore, currentChild.getChild(0).getChild(1), null);
				
				// Check main doesn't already exist
				if (functionStorage.containsKey("main")) {
					System.out.format("Error: %s has already been declared as a function", "main");
					System.exit(1);
				}
				functionStorage.put("main", function);			
			}
		}
		
		Tools.setGlobalTable(globalStorage);
		Tools.setFunctionTable(functionStorage);
	}
	
	public static void checkGlobalDeclare(Tree children) {
		for (int i = 0; i<children.getChildCount(); i++ ) {
			String type = children.getChild(i).getChild(0).getChild(0).getText();
			String name = children.getChild(i).getChild(1).getChild(0).getText();
			
			// If another global variable is named the same
			if (globalStorage.containsKey(name)) {
				System.out.format("Error: %s has already been declared as a global variable", name);
				System.exit(1);
			}
			globalStorage.put(name, type);
		}
	}
	
	public static void checkProcedure(Tree children) {
		int offset = 0;
		String returnType;
		FunctionStorage function;
		LinkedHashMap<String, String> args = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> localStore = new LinkedHashMap<String, String>();
		
		// Get return type
		if (children.getChild(0).getText() == "TYPE"){
			returnType = children.getChild(0).getChild(0).getText();
			offset = 1;
		} else {
			returnType = "void";
		}
		
		// Get method name
		String methodName = children.getChild(0 + offset).getChild(0).getText();
		
		// Get args
		for (int i = 0; i<children.getChild(1 + offset).getChildCount(); i++) {
			String atype = children.getChild(1 + offset).getChild(i).getChild(0).getChild(0).getText();
			String aname = children.getChild(1 + offset).getChild(i).getChild(1).getChild(0).getText();
			addLocal(localStore, methodName, aname, atype);
			args.put(aname, atype);
		}
				
		function = new FunctionStorage(returnType, args, localStore, children.getChild(2 + offset).getChild(1), null);
		
		if (functionStorage.containsKey(methodName)) {
			System.out.format("Error: %s has already been declared as a function", methodName);
			System.exit(1);
		}
		functionStorage.put(methodName, function);
		
		// Check body
		checkBody(methodName, localStore, children.getChild(2 + offset)); 
	}
	
	public static void addLocal(LinkedHashMap<String, String> localStore, String methodName, String name, String type) {
		if (localStore.containsKey(name)) {
			System.out.format("Error: Local variable '%s' has already been declared in function %s", name, methodName);
			System.exit(1);
		}	
		localStore.put(name, type);
	}
	
	public static void checkBody(String methodName, LinkedHashMap<String, String> localStore, Tree children) {

		// Take declared variables
		if (children.getChild(0).toString() == "DECLARE") {
			for (int i = 0; i<children.getChild(0).getChildCount(); i++ ) {
				String type = children.getChild(0).getChild(i).getChild(0).getChild(0).getText();
				String name = children.getChild(0).getChild(i).getChild(1).getChild(0).getText();
				addLocal(localStore, methodName, name, type);
			}
		}
		
		checkRecursiveBody(methodName, localStore, children.getChild(1));
	}
	
	public static void checkRecursiveBody(String methodName, LinkedHashMap<String, String> localStore, Tree children) {
		for (int i=0; i<children.getChildCount(); i++) {
			String stmtname = children.getChild(i).getChild(0).toString();
			Tools.StatementNames currentFunction = Tools.StatementNames.valueOf(stmtname.toUpperCase());
			switch (currentFunction) {
				case WHILE:
					checkConditionalExpression(methodName, children.getChild(i).getChild(1), localStore);
					checkRecursiveBody(methodName, localStore, children.getChild(i).getChild(2).getChild(0));
					break;
				case IF:
					// If
					checkConditionalExpression(methodName, children.getChild(i).getChild(1), localStore);
					checkRecursiveBody(methodName, localStore, children.getChild(i).getChild(2).getChild(0));
					// Else
					if (children.getChild(i).getChildCount() >= 5) {
						checkRecursiveBody(methodName, localStore, children.getChild(i).getChild(4).getChild(0));
					}
					break;
				case READ:
					isVariableCorrect(methodName, localStore, children.getChild(i).getChild(1).getChild(0).toString(), "int", "read");
					break;
				case OUTPUT:
					isVariableCorrect(methodName, localStore, children.getChild(i).getChild(1).getChild(0).toString(), "int", "output");
					break;
				case PRINT:
					break;
				case RETURN:
					String returnType = functionStorage.get(methodName).getReturnType();
					String type = checkExpression(methodName, children.getChild(i).getChild(1), localStore);
					if (!returnType.contains(type)) {
						System.out.printf("Types don't match for return statement and return type in %s", methodName);
						System.exit(1);
					}
					break;
				case READC:
					isVariableCorrect(methodName, localStore, children.getChild(i).getChild(1).getChild(0).toString(), "char", "readc");
					break;
				case OUTPUTC:
					isVariableCorrect(methodName, localStore, children.getChild(i).getChild(1).getChild(0).toString(), "char", "outputc");
					break;
				case ASSIGN:
					isVariableCorrect(methodName, localStore, children.getChild(i).getChild(1).getChild(0).toString(), "", "");
					// Var
					String varType = checkExpression(methodName, children.getChild(i).getChild(1), localStore);
					// Assignment
					String assignmentType = checkExpression(methodName, children.getChild(i).getChild(2), localStore);
					if (!varType.contains(assignmentType)) {
						System.out.printf("Types don't match for assign statement %s\n", children.getChild(i).toStringTree());
						System.exit(1);
					}
					break;
				case FUNCNAME:
					isFuncCallCorrect(methodName, localStore, children.getChild(i));
					break;
			}
		}
	}
	
	public static void isVariableCorrect(String methodName, LinkedHashMap<String, String> localStore, String variableName, String correctType, String statementType) {

		String type = getType(variableName, localStore);
		// Is undeclared
		if (type.contentEquals("")) {	
			System.out.printf("No variable in %s called %s", methodName, variableName);
			System.exit(1);
		}

		// Is correct type?
		if (!type.contains(correctType)) {
			System.out.printf("Wrong type for %s in %s, should be %s", variableName, statementType, correctType);
			System.exit(1);
		}
	}
	
	public static void isFuncCallCorrect(String methodName, LinkedHashMap<String, String> localStore, Tree children) {
		
		// Does function exist
		String funcName = children.getChild(0).getChild(0).toString();
		
		if (!functionStorage.containsKey(funcName)) {
			System.out.printf("There is no function called %s", funcName);
			System.exit(1);
		}
		
		// Are number of arguments correct		
		FunctionStorage function = functionStorage.get(funcName);
		int realargnum = function.getArgsSize();
		int callargsnum = children.getChild(1).getChildCount();
		
		if (realargnum != callargsnum) {
			System.out.printf("Function call for %s has incorrect number of arguments", funcName);
			System.exit(1);
		}
		
		// Are params correct
		HashMap<String, String> realArgs = function.getArgs();
		String[] a = new String[realargnum];
		realArgs.keySet().toArray(a);
		
		for (int i = 0; i<children.getChild(1).getChildCount(); i++) {
			String aname = children.getChild(1).getChild(i).getChild(0).getText();
			String atype = realArgs.get(a[i]);
			isVariableCorrect(methodName, localStore, aname, atype, children.toStringTree());		
		}	
	}
	
	public static void checkConditionalExpression(String methodName, Tree children, LinkedHashMap<String, String> localStore) {
		if (children.toString().matches("<|>|<=|>=|!=|==")) {
			String leftType = checkExpression(methodName, children.getChild(0), localStore);
			String rightType = checkExpression(methodName, children.getChild(1), localStore);
			
			if (!leftType.contains(rightType)) {
				System.out.printf("Types don't match for condition %s\n", children.toStringTree());
				System.exit(1);
			}
		} else {
			String returnType = checkExpression(methodName, children, localStore);
			if (!returnType.contains("int")) {
				System.out.printf("Conditional expression doesn't work: %s\n", children.toStringTree());
				System.exit(1);
			}
		}
	}
	
	public static String checkExpression(String methodName, Tree children, LinkedHashMap<String, String> localStore) {

		// VARS
		if (children.getText().contains("VAR")) {
			if (children.getChild(0).toString().matches("\\d+")) {
				return "int";
			} else if (children.getChild(0).toString().matches("[a-zA-Z_]\\w*")) {
				isVariableCorrect(methodName, localStore, children.getChild(0).toString(), "", "");
				return getType(children.getChild(0).toString(), localStore);			
			}
			
		// CHARS
		} else if (children.getText().contains("CHR")) {
			return "char";
			
		// STMT
		} else if (children.getText().contains("STMT")) {
			isFuncCallCorrect(children.getChild(0).getChild(0).toString(), localStore, children);
			return functionStorage.get(children.getChild(0).getChild(0).toString()).getReturnType();
			
		// NEGATE
		} else if (children.getText().contains("NEGATE")) {
			if (children.getChild(0).getChild(0).toString().matches("\\d+")) {
				return "int";
			} else if (children.getChild(0).getChild(0).toString().matches("[a-zA-Z]\\w*")) {
				isVariableCorrect(methodName, localStore, children.getChild(0).getChild(0).toString(), "", "");
				String type = getType(children.getChild(0).getChild(0).toString(), localStore);
				if (type.contains("int")) {
					return "int";
				} else {
					System.out.printf("Cannot negate char variable %s\n", children.getChild(0).getChild(0).toString());
					System.exit(1);
				}
			}
		} else if (children.getText().matches("[*%/+-]")) {
			String leftType = checkExpression(methodName, children.getChild(0), localStore);
			String rightType = checkExpression(methodName, children.getChild(1), localStore);
			if (!leftType.contains(rightType)) {
				System.out.printf("Types don't match for calculation %s\n", children.toStringTree());
				System.exit(1);
			} else {
				return "int";
			}
		}			
		return "";
	}
	
	public static String getType(String variableName, LinkedHashMap<String, String> localStore) {
		if (localStore.containsKey(variableName)) {
			return localStore.get(variableName);			
		} else if (globalStorage.containsKey(variableName)) {
			return globalStorage.get(variableName);
		}
		return "";
	}
}