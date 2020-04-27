package compiler;

import java.io.*;
import syntaxtree.*;
import parser.*;
import bytecode.*;

public class Compiler {

	private String inFilename = null;
	private String outFilename = null;
    private String binFilename = null;
    public String syntaxError;
    public String error;
	
	public Compiler(String inFilename, String outFilename, String binFilename){
		this.inFilename = inFilename;
		this.outFilename = outFilename;
		this.binFilename = binFilename;
	}

	public int compile() throws Exception {
		InputStream inputStream = null;
		inputStream = new FileInputStream(this.inFilename);
		Lexer lexer = new Lexer(inputStream);
		parser parser = new parser(lexer);
		Program program;

		// Run lexer and parser
		try {
			program = (Program)parser.parse().value;
			//writeAST(program);
		} catch(Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
        // Check semantics
		if(program.typeCheck()){
            writeAST(program);
            generateCode(program);
            return 0;
        } else if (false){ 		// If SYNTAX ERROR (Should not get that for the tests):
            return 1;
        } else { 				// If SEMANTIC ERROR (Should get that for the test with "_fail" in the name):
            return 2;
        }
	}
	
	private void generateCode(Program program) throws Exception {
        CodeFile codeFile = new CodeFile();
        program.generateCode(codeFile);
        byte[] bytecode = codeFile.getBytecode();
        DataOutputStream stream = new DataOutputStream(new FileOutputStream (this.binFilename));
        stream.write(bytecode);
        stream.close();
    }
	
	public void writeAST(Program program) {
		try {
			BufferedWriter buf = new BufferedWriter(new FileWriter(this.outFilename));
        	buf.write(program.printAst(0));
            buf.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Compiler compiler = new Compiler(args[0], args[1], args[2]);
		try {
			compiler.compile();
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
