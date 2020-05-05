package syntaxtree.decl;

import common.SymbolTable;
import common.error.SemanticException;
import common.error.SyntaxException;
import syntaxtree.DataType;
import syntaxtree.Name;
import syntaxtree.stmt.Stmt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static common.StringUtil.*;

public class ProcDecl extends Decl {

	private DataType returnDataType;
	private final List<ParamFieldDecl> params;
	private final List<Decl> declarations;
	private final List<Stmt> statements;
	
	// No return type, "default" constructor
	public ProcDecl(String name) {
		super(new Name(name));
		this.params = new ArrayList<>();
		this.declarations = new ArrayList<>();
		this.statements = new ArrayList<>();
	}

	// No return type, given params
	public ProcDecl(
				String name,
				List<ParamFieldDecl> params) {
		super(new Name(name));
		this.params = params;
		this.declarations = new ArrayList<>();
		this.statements = new ArrayList<>();
	}

	// No return type, given params and statements
	public ProcDecl(
				String name,
				List<ParamFieldDecl> params,
				List<Stmt> statements) {
		super(new Name(name));
		this.params = params;
		this.statements = statements;
		this.declarations = new ArrayList<>();
	}

	// Given return type
	public ProcDecl(
				String name,
				DataType returnDataType) {
		super(new Name(name));
		this.returnDataType = returnDataType;
		this.params = new ArrayList<>();
		this.statements = new ArrayList<>();
		this.declarations = new ArrayList<>();
	}

	// Given return type, given params and statements
	public ProcDecl(
				String name,
				DataType returnDataType,
       			List<ParamFieldDecl> params,
       			List<Stmt> statements) {
		super(new Name(name));
		this.returnDataType = returnDataType;
		this.params = params;
       	this.statements = statements;
       	this.declarations = new ArrayList<>();
	}

	// No return type, given params, decl and stmts
	public ProcDecl(
				String name,
				List<ParamFieldDecl> params,
				List<Decl> declarations,
				List<Stmt> statements) {
		super(new Name(name));
		this.params = params;
		this.declarations = declarations;
		this.statements = statements;
	}

	// Given return type, params, decl and stmts
	public ProcDecl(
				String name,
				DataType returnDataType,
				List<ParamFieldDecl> params,
				List<Decl> declarations,
				List<Stmt> statements) {
		super(new Name(name));
		this.returnDataType = returnDataType;
		this.params = params;
		this.declarations = declarations;
		this.statements = statements;
	}

	public void addParameter(ParamFieldDecl param) throws SyntaxException {
		if(params == null) {
			throw new SyntaxException("Procedure has no parameters");
		}
		this.params.add(param);
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(PROCEDURE ");
		builder.append("(NAME ");
		builder.append(this.getName());
		builder.append(")");

		if(returnDataType != null)
			builder.append(" : " + this.returnDataType.printAst(level));
		
		if(params != null) {
			for(ParamFieldDecl p: params) {
				builder.append("\n" + repeat("\t", level + 1) + "(PARAM_DECL " + p.printAst(level + 1));
			}
		}
		
		if(declarations != null) {
			for(Decl d: declarations) {
				builder.append("\n" + repeat("\t", level + 1) + d.printAst(level + 1));
			}
		}
		
		if(statements != null) {
			for(Stmt s: statements) {
				builder.append("\n" + repeat("\t", level + 1) + s.printAst(level + 1));
			}
		}

		builder.append("\n" + repeat("\t", level) + ")");
		
		return builder.toString();
	}

	@Override
	public DataType getDataType() {
		return this.returnDataType;
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		// Check if exists
		if(symbolTable.retrieveProcedure(this.getName()) != null) {
			throw new SemanticException("Duplicate procedure declaration found: " + this.getName().toString());
		}

		// Check formal params
		for(Decl decl: declarations) {
			if(Collections.frequency(declarations, decl) > 1) {
				throw new SemanticException("Duplicate formal parameter found: " + decl.getName() + " in procedure " + this.getName());
			}
		}

		// Check return type
		if(symbolTable.retrieveType(this.getName()) != null) {
			throw new SemanticException("Undefined type in procedure " + this.getName());
		}

		symbolTable.insertProcedure(this);
	}
}
