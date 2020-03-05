// Inspiration for oblig1, for oblig2 there will be an update

package compiler;

import java.io.*;
import syntaxtree.*;
import cmp20parser.*;

public class Compiler {
	private String inFilename = null;
	private String outFilename = null;
	public Compiler(String inFilename, String outFilename){  // 
		this.inFilename = inFilename;
		this.outFilename = outFilename;
	}
	public void compile() throws Exception {
		InputStream inputStream = null;
		inputStream = new FileInputStream(this.inFilename);
		Lexer lexer = new Lexer(inputStream);
		parser parser = new parser(lexer);
		Program program = (Program)parser.parse().value;
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.outFilename));
		bufferedWriter.write(program.printAst());
		bufferedWriter.close();

		createAST(program);
	}
	public static void main(String[] args) {
		Compiler compiler = new Compiler(args[0], args[1]);
		try {
			compiler.compile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createAST(Program program) {

		try {
			BufferedWriter buf = new BufferedWriter(new FileWriter(this.outFilename));
			buf.write(program.printAst());
			buf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
