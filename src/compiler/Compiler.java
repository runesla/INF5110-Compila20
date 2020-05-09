package compiler;

import java.io.*;
import common.Program;
import common.SymbolTable;
import common.error.ParseException;
import common.error.SemanticException;
import common.error.SyntaxException;
import parser.*;
import bytecode.*;
import syntaxtree.decl.ProcDecl;
import syntaxtree.decl.VarDecl;
import syntaxtree.types.DataType;
import static common.utils.ReturnValues.*;

public class Compiler {

	private String inFilename = null;
	private String outFilename = null;
    private String binFilename = null;
    private SymbolTable symbolTable = null;
	public String syntaxError;
    public String error;
	
	public Compiler(String inFilename, String outFilename, String binFilename){
		this.inFilename = inFilename;
		this.outFilename = outFilename;
		this.binFilename = binFilename;
		this.symbolTable = new SymbolTable();
	}

	public int compile() throws Exception {
		InputStream inputStream = null;
		inputStream = new FileInputStream(this.inFilename);
		Lexer lexer = new Lexer(inputStream);
		parser parser = new parser(lexer);			// TODO: getting error "Required type Scanner, Provided Lexer". Wtf!?
		Program program = null;

		// Run lexer and parser
		try {
			program = (Program)parser.parse().value;		// TODO: getting error "cannot resolve 'parse' in 'parser'". Also wtf!?
		} catch(ParseException e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
			return PARSE_ERROR;
		}
		
        // Check semantics
		assert program != null;
		try {
			program.typeCheck(symbolTable);
		} catch (SemanticException e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
			printSymTable();				// TODO: for debugging
			return SEMANTIC_ERROR;
		}

		// Create AST
		try {
			writeAST(program);
		} catch (Exception e) {		// TODO: if output ast file does not exist, it throws a FileNotFoundException
			e.printStackTrace();
			System.err.println("ERROR: " + e.getMessage());
			System.exit(GENERAL_ERROR);
		}

		// Generate code
		try {
			generateCode(program);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR: " + e.getMessage());
			System.exit(CODEGEN_ERROR);
		}
/*
		if(program.checkSemantics(symbolTable)){
            writeAST(program);
            generateCode(program);
            return SUCCESS;
        } else if (false){ 		// If SYNTAX ERROR (Should not get that for the tests):
            //return 1;
			return SYNTAX_ERROR;
        } else { 				// If SEMANTIC ERROR (Should get that for the test with "_fail" in the name):
            //return 2;
			return SEMANTIC_ERROR;
        }
 */
		return SUCCESS;
	}

	public void writeAST(Program program) throws Exception {
		BufferedWriter buf = new BufferedWriter(new FileWriter(this.outFilename));
		buf.write(program.printAst(0));
		buf.close();
	}

	private void generateCode(Program program) throws Exception {
        CodeFile codeFile = new CodeFile();
        program.generateCode(codeFile);
        byte[] bytecode = codeFile.getBytecode();
        DataOutputStream stream = new DataOutputStream(new FileOutputStream (this.binFilename));
        stream.write(bytecode);
        stream.close();
    }

    private void printSymTable() {
		for(ProcDecl procs: symbolTable.getProcs()) {
			System.out.println("PROCEDURE: " + procs.getName().getNameValue());
		}

		for(VarDecl vars: symbolTable.getVars()) {
			System.out.println("VARIABLE: " + vars.getName().getNameValue());
		}

		for(DataType types: symbolTable.getRegisteredTypes()) {
			System.out.println("TYPE: " + types.getName().getNameValue());
		}
	}

	public static void main(String[] args) {
		Compiler compiler = new Compiler(args[0], args[1], args[2]);

		try {
			compiler.compile();
		} catch(SemanticException e) {
			System.err.println("SEMANTIC ERROR: " + e.getMessage());
			e.printStackTrace();
			System.exit(SEMANTIC_ERROR);
		} catch (SyntaxException e) {
			System.err.println("SYNTAX ERROR: " + e.getMessage());
			e.printStackTrace();
			System.exit(SYNTAX_ERROR);
		}
		catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
			System.exit(GENERAL_ERROR);
		}
	}
}
