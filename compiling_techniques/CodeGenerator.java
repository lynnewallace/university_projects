/*
 * s0829961
 * Compiling Techniques
 * Takes symbol tables and creates corresponding java bytecode 
 *
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.antlr.runtime.tree.Tree;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class CodeGenerator implements Opcodes {
	
	public static ClassWriter cw;
	public static MethodVisitor mv;
	public static String className;
	
	public static HashMap<String, String> globalStorage;
	public static HashMap<String, FunctionStorage> functionStorage;
	private static HashMap<String, Integer> conditionTable = new HashMap<String, Integer>();
	private static HashMap<String, Integer> mathTable = new HashMap<String, Integer>();
		
	public static void createBytecode(String outputFileName) throws IOException {
		
		// Set up 
		className = outputFileName;
		Tools.populateConditionTable(conditionTable);
		Tools.populateMathTable(mathTable);
		cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		
		// Write class line
		cw.visit(V1_5, ACC_PUBLIC + ACC_SUPER, outputFileName, null, "java/lang/Object", null);

		// Write global variables
		writeGlobalVariables();
		
		// Write instance initialization method
		initMethod();
		
		// Write each method
		String[] functions = new String[functionStorage.size()];
		functionStorage.keySet().toArray(functions);
		
		for (int i = 0; i<functionStorage.size(); i++) {
			writeMethod(functions[i], functionStorage.get(functions[i]));
		}	
		
		// Get bytecode
		cw.visitEnd();
		byte[] bytecode = cw.toByteArray();
		
		// Output to file
		FileOutputStream outputStream = new FileOutputStream(outputFileName +".class");
		outputStream.write(bytecode);
		outputStream.close();
	}
	
	public static void writeGlobalVariables() {
		
		// Access each global variables
		String[] globals = new String[globalStorage.size()];
		globalStorage.keySet().toArray(globals);

		for (int i = 0; i<globalStorage.size(); i++) {
			// Write details for bytecode
			cw.visitField(ACC_PUBLIC + ACC_STATIC, globals[i], getTypeDescriptor(globalStorage.get(globals[i])), null, null).visitEnd();
		}
		
		// Initialize all global variables to 0 or '\000'
		initializeGlobals(globals);
	}
	
	public static void initializeGlobals(String[] globals) {
		
		// Write static start
		mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
		
		// Initialize each global variables to either 0 or '\000'
		for (int i = 0; i<globalStorage.size(); i++) {
			mv.visitInsn(ICONST_0);
			mv.visitFieldInsn(PUTSTATIC, className, globals[i], getTypeDescriptor(globalStorage.get(globals[i])));
		}
		
		// End static
		mv.visitInsn(RETURN);
		mv.visitMaxs(1, 1);
	}
	
	public static void initMethod() {
		
		// Write init start
		mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);

		// Special init code
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		
		// End init
		mv.visitInsn(RETURN);
		mv.visitMaxs(1, 1);
	}
	
	public static void writeMethod(String functionName, FunctionStorage function) {
		
		// Get descriptors
		String typeArgs = getTypeArgsDescription(function);
		String returnType = getTypeDescriptor(function.getReturnType());
		
		// Write method start
		if (functionName.contains("main")) {
			mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		} else {
			mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, functionName, "(" + typeArgs + ")" + returnType, null, null);
		}
		mv.visitCode();
		
		// Populate and initialize local variables
		populateLocalVars(function);
		
		// Write statements
		writeStatements(function, function.getStatements());
		
		// Write return method if needed
		if (function.getReturnType().contentEquals("void")) {
			mv.visitInsn(RETURN);
		}
		
		// End of method
		mv.visitMaxs(1, 1);
		mv.visitEnd();
	} 

	public static String getTypeArgsDescription(FunctionStorage function) {
		String typeArgs = "";

		// Concat first letter of each argument
		if (function.getArgs() != null) {
			String[] args = new String[function.getArgs().size()];
			function.getArgs().keySet().toArray(args);
			for (String arg : args) {
				typeArgs += getTypeDescriptor(function.getArgs().get(arg));
			}
		}
		return typeArgs;
	}
	
	public static void populateLocalVars(FunctionStorage function) {
		HashMap<String, Integer> registerStorage = new HashMap<String, Integer>();
		LinkedHashMap<String, String> localVarStorage = function.getLocalVarStorage();

		// Function args first
		if (function.getArgs() != null) {
			String[] args = new String[function.getArgs().size()];
			function.getArgs().keySet().toArray(args);

			// Put in registerStorage, remove from localVarStorage
			int i = 0;
			for (String arg : args) {
				registerStorage.put(arg, i);
				localVarStorage.remove(arg);
				i++;
			}
		}

		// Remaining local variables
		String[] localVars = new String[localVarStorage.size()];
		localVarStorage.keySet().toArray(localVars);
		
		// Add the rest to the localVarStorage
		int i = 0;
		if (function.getArgs() != null) {
			i = function.getArgsSize();
		}
		for (String localVar : localVars) {
			registerStorage.put(localVar, i);
			i++;
		}	
		
		// Set the function's version of the registerStorage
		function.setRegisterStorage(registerStorage);

		// Initialize the non arg local variables
		initializeLocalVars(localVars, registerStorage);
	}

	public static void initializeLocalVars(String[] localVars, HashMap<String,Integer> registerStore) {

		// Initialize each local variables to either 0 or '\000'
		for (String localVar : localVars) {
			mv.visitInsn(ICONST_0);
			mv.visitVarInsn(ISTORE, registerStore.get(localVar));
		}
	}
	
	public static void writeStatements(FunctionStorage function, Tree statements) {
		
		// Traverse through the statements
		for (int i=0; i<statements.getChildCount(); i++) {
			String stmtname = statements.getChild(i).getChild(0).toString();
			Tools.StatementNames currentFunction = Tools.StatementNames.valueOf(stmtname.toUpperCase());

			// For loading and storing purposes
			int register;
			String varName;
			
			// To declutter
			Tree condition;
			Tree recurseStatements;
			
			switch (currentFunction) {
				case WHILE:
					condition = statements.getChild(i).getChild(1);
					recurseStatements = statements.getChild(i).getChild(2).getChild(0);
					whileStatement(condition, function, recurseStatements);
					break;
				case IF:
					// Else
					condition = statements.getChild(i).getChild(1);
					recurseStatements = statements.getChild(i).getChild(2).getChild(0);
					if (statements.getChild(i).getChildCount() >= 5) {
						ifStatement(condition, function, recurseStatements, statements.getChild(i).getChild(4).getChild(0));
					// Just if
					} else {
						ifStatement(condition, function, recurseStatements, null);
					}
					break;
				case READ:
					varName = statements.getChild(i).getChild(1).getChild(0).toString();
					register = getRegister(function.getRegisterStorage(), varName);
					inFunction(register, varName, "int");
					break;
				case OUTPUT:
					varName = statements.getChild(i).getChild(1).getChild(0).toString();
					register = getRegister(function.getRegisterStorage(), varName);
					outFunction(register, varName, "int");
					break;
				case PRINT:
					String stringValue = statements.getChild(i).getChild(1).getChild(0).toString();
					printFunction(stripQuotes(stringValue));
					break;
				case RETURN:
					writeExpression(statements.getChild(i).getChild(1), function);
					mv.visitInsn(IRETURN);
					break;
				case READC:
					varName = statements.getChild(i).getChild(1).getChild(0).toString();
					register = getRegister(function.getRegisterStorage(), varName);				
					inFunction(register, varName, "char");
					break;
				case OUTPUTC:
					varName = statements.getChild(i).getChild(1).getChild(0).toString();
					register = getRegister(function.getRegisterStorage(), varName);		
					outFunction(register, varName, "char");
					break;
				case ASSIGN:			
					// Write right hand side 
					writeExpression(statements.getChild(i).getChild(2), function);
					
					varName = statements.getChild(i).getChild(1).getChild(0).toString();
					register = getRegister(function.getRegisterStorage(), varName);	

					// Store for left hand side
					storeValue(register, varName, globalStorage.get(varName));
					break;
				case FUNCNAME:
					funcCallStatement(statements.getChild(i), function);
					break;
			}
		}
	}
	
	public static void writeExpression(Tree expression, FunctionStorage function) {
		// Math
		if (expression.getText().matches("[*%/+-]")) {
			// Write left hand side
			writeExpression(expression.getChild(0), function);
			// Write right hand side
			writeExpression(expression.getChild(1), function);
			// Write math symbol
			mv.visitInsn(mathTable.get(expression.getText()));
		
		// Variables
		} else if (expression.getText().contains("VAR")) {
			// Load number
			if (expression.getChild(0).toString().matches("\\d+")) {
				mv.visitIntInsn(SIPUSH, Integer.valueOf(expression.getChild(0).toString()));
			// Load variable
			} else if (expression.getChild(0).toString().matches("[a-zA-Z_]\\w*")) {
				int register = getRegister(function.getRegisterStorage(), expression.getChild(0).toString());
				loadValue(register, expression.getChild(0).toString(), globalStorage.get(expression.getChild(0).toString()));
			}
		
		// Func call
		} else if (expression.getText().contains("STMT")) {
			funcCallStatement(expression, function);
		
		// Char
		} else if (expression.getText().contains("CHR")) {
			int charVar = (int)expression.getChild(0).getText().charAt(1);
			mv.visitIntInsn(SIPUSH, charVar);
		
		// NEGATE
		} else if (expression.getText().contains("NEGATE")) {
			// Load number
			if (expression.getChild(0).getChild(0).toString().matches("\\d+")) {
				mv.visitIntInsn(SIPUSH, Integer.valueOf(expression.getChild(0).getChild(0).toString()));
			// Load variable
			} else if (expression.getChild(0).getChild(0).toString().matches("[a-zA-Z_]\\w*")) {
				int register = getRegister(function.getRegisterStorage(), expression.getChild(0).getChild(0).toString());
				loadValue(register, expression.getChild(0).toString(), globalStorage.get(expression.getChild(0).getChild(0).toString()));
			}
			// Multiply by -1
			mv.visitIntInsn(SIPUSH, -1);
			mv.visitInsn(IMUL);
		}
	}
		
	public static void funcCallStatement(Tree funcCallCode, FunctionStorage function) {
		FunctionStorage storage = functionStorage.get(funcCallCode.getChild(0).getChild(0).toString());
		String typeargs = getTypeArgsDescription(storage);
		String type = getTypeDescriptor(storage.getReturnType());
		
		// Load all argument variables
		for (int i=0; i<funcCallCode.getChild(1).getChildCount(); i++) {
			String varName = funcCallCode.getChild(1).getChild(i).getChild(0).toString();
			int register = getRegister(function.getRegisterStorage(), varName);	
			loadValue(register, varName, String.valueOf(typeargs.charAt(i)));
		}
			
		// Write function caller
		mv.visitMethodInsn(INVOKESTATIC, className, funcCallCode.getChild(0).getChild(0).toString(), "(" + typeargs + ")" + type);
	}
	
	public static void ifStatement(Tree ifCondition, FunctionStorage function, Tree ifCode, Tree elseCode) {
		
		// Check for else code
		boolean hasElse = true;
		if (elseCode == null) {
			hasElse = false;
		}
		
		Label trueCode = new Label();
		Label falseCode = new Label();
		
		// Write left hand size
		writeExpression(ifCondition.getChild(0), function);
		// Write right hand size
		writeExpression(ifCondition.getChild(1), function);
		// Write if condition
		mv.visitJumpInsn(conditionTable.get(ifCondition.toString()), falseCode);
			
		// Write if code
		writeStatements(function, ifCode);
		
		// Goto end
		if (hasElse) {
			mv.visitJumpInsn(GOTO, trueCode);
		}
		
		// Write false code
		mv.visitLabel(falseCode);
		
		if (hasElse) {
			writeStatements(function, elseCode);
		
			// Finish if
			mv.visitLabel(trueCode);
		}
	}
	
	public static void whileStatement(Tree whilecondition, FunctionStorage function, Tree code) {
		Label whileCode = new Label();
		Label condition = new Label();
		
		// Goto condtion
		mv.visitJumpInsn(GOTO, condition);

		// Write while code
		mv.visitLabel(whileCode);
		writeStatements(function, code);
		
		// Condition
		mv.visitLabel(condition);
		// Write left hand side
		writeExpression(whilecondition.getChild(0), function);
		//Write right hand side
		writeExpression(whilecondition.getChild(1), function);
		// Write while condition
		mv.visitJumpInsn(conditionTable.get(whilecondition.toString()), whileCode);
	}
	
	public static void printFunction(String printValue) {
		// Println printValue
		mv.visitFieldInsn(GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn(printValue);
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");		
	}
	
	public static void outFunction(int register, String varName, String type) {
		// Println value
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		
		// Load value
		loadValue(register, varName, type);
		
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(" + getTypeDescriptor(type) + ")V");
	}
	
	public static void inFunction(int register, String varName, String type) {
		// System.in
		Label start = new Label();
		Label end = new Label();
		Label handler = new Label();
		Label works = new Label();
		
		mv.visitTryCatchBlock(start, end, handler, "java/io/IOException");
		
		// Try System.in
		mv.visitLabel(start);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/InputStream", "read", "()I");
		
		// Convert to char if a char
		if (type.contains("char")) {
			mv.visitInsn(I2C);
		}
		
		// Store value
		storeValue(register, varName, type);
		
		// Skip exception
		mv.visitLabel(end);
		mv.visitJumpInsn(GOTO, works);
		
		// Catch io exception
		mv.visitLabel(handler);
		mv.visitVarInsn(ASTORE, 1);
		mv.visitVarInsn(ALOAD, 1);
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/IOException", "printStackTrace", "()V");
		
		// No catch
		mv.visitLabel(works);
	}
	
	// Get upper case initial letter
	public static String getTypeDescriptor(String type) {
		return type.toUpperCase().substring(0, 1);
	}
	
	public static int getRegister(HashMap<String,Integer> registers, String varName) {
		// Get local register or indicate global variable
		if (registers.containsKey(varName)) {
			return registers.get(varName);
		} else {
			return -1;
		}	
	}
	
	public static void storeValue(int register, String varName, String type) {
		// Store correctly
		if (register == -1) {
			mv.visitFieldInsn(PUTSTATIC, className, varName, getTypeDescriptor(type));
		} else {
			mv.visitVarInsn(ISTORE, register);
		}
	}
	
	public static void loadValue(int register, String varName, String type) {
		// Load correctly
		if (register == -1) {
			mv.visitFieldInsn(GETSTATIC, className, varName, getTypeDescriptor(type));
		} else {
			mv.visitVarInsn(ILOAD, register);
		}
	}
	
	// Take away beginning and end 's
	public static String stripQuotes(String stringValue) {
		return stringValue.substring(1, stringValue.length()-1);
	}
}