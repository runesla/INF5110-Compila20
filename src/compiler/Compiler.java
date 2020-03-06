package compiler;

import java.io.*;
import syntaxtree.*;
import parser.*;

public class Compiler {

	private String inFilename = null;
	private String outFilename = null;

	public Compiler(String inFilename, String outFilename){
		this.inFilename = inFilename;
		this.outFilename = outFilename;
	}

	public void compile() throws Exception {
		InputStream inputStream = null;
		inputStream = new FileInputStream(this.inFilename);
		Lexer lexer = new Lexer(inputStream);
		parser parser = new parser(lexer);
		
		try {
			Program program = (Program)parser.parse().value;
			createAST(program);
			System.out.println("Program compiled");
		} catch(Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void createAST(Program program) {
		try {
			BufferedWriter buf = new BufferedWriter(new FileWriter(this.outFilename));
        		buf.write(program.printAst());
            		buf.close();
			System.out.println("AST created");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Compiler compiler = new Compiler(args[0], args[1]);
		try {
			compiler.compile();
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
