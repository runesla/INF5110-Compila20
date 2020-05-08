package syntaxtree.decl;

import common.SymbolTable;
import common.error.SemanticException;
import common.error.SyntaxException;
import syntaxtree.stmt.ReturnStmt;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.stmt.Stmt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static common.utils.StringUtil.*;

public class ProcDecl extends Decl {

	private DataType returnDataType;
	private final List<ParamDecl> params;
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
				Name name,
				List<ParamDecl> params) {
		super(name);
		this.params = params;
		this.declarations = new ArrayList<>();
		this.statements = new ArrayList<>();
	}

	// No return type, given params and statements
	public ProcDecl(
			Name name,
				List<ParamDecl> params,
				List<Stmt> statements) {
		super(name);
		this.params = params;
		this.statements = statements;
		this.declarations = new ArrayList<>();
	}

	// Given return type
	public ProcDecl(
			Name name,
				DataType returnDataType) {
		super(name);
		this.returnDataType = returnDataType;
		this.params = new ArrayList<>();
		this.statements = new ArrayList<>();
		this.declarations = new ArrayList<>();
	}

	// Given return type, given params and statements
	public ProcDecl(
				Name name,
				DataType returnDataType,
       			List<ParamDecl> params,
       			List<Stmt> statements) {
		super(name);
		this.returnDataType = returnDataType;
		this.params = params;
       	this.statements = statements;
       	this.declarations = new ArrayList<>();
	}

	// No return type, given params, decl and stmts
	public ProcDecl(
				Name name,
				List<ParamDecl> params,
				List<Decl> declarations,
				List<Stmt> statements) {
		super(name);
		this.params = params;
		this.declarations = declarations;
		this.statements = statements;
	}

	// Given return type, params, decl and stmts
	public ProcDecl(
				Name name,
				DataType returnDataType,
				List<ParamDecl> params,
				List<Decl> declarations,
				List<Stmt> statements) {
		super(name);
		this.returnDataType = returnDataType;
		this.params = params;
		this.declarations = declarations;
		this.statements = statements;
	}

	public void addParameter(ParamDecl param) throws SyntaxException {
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
		builder.append(this.getName().getNameValue());
		builder.append(")");
		if(returnDataType != null) {
			builder.append(" : " + this.returnDataType.printAst(level));
		}
		if(params != null) {
			for(ParamDecl p: params) {
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

		// Create symbol table for this block
		SymbolTable procSymbolTable = symbolTable.createChildTable();

		// Check actual params
		for(ParamDecl paramDecl: params) {
			procSymbolTable.insertVariable(paramDecl);
			paramDecl.typeCheck(procSymbolTable);
		}

		// Check formal params
		for(Decl decl: declarations) {
			procSymbolTable.insertVariable((VarDecl) decl);
			decl.typeCheck(procSymbolTable);
		}

		boolean returnStmtPresent = false;

		// Check statements
		for(Stmt stmt: statements) {
			stmt.typeCheck(procSymbolTable);

			if(stmt instanceof ReturnStmt) {

				returnStmtPresent = true;

				if(symbolTable.retrieveType(this.returnDataType.getName()) == null) {
					throw new SemanticException("Invalid return type");
				}

				if (stmt.getDataType() != this.returnDataType) {
					throw new SemanticException("Type mismatch between procedure and return statement");
				}
			}
		}

		// Check return statement
		if(!returnStmtPresent && returnDataType != null) {
			throw new SemanticException("Missing return statement");
		}
	}
}
