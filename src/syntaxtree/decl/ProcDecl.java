package syntaxtree;

import java.util.*;
import static syntaxtree.StringUtil.*;

public class ProcDecl extends Decl {

	private Type returnType;
	private List<ParamFieldDecl> params;
	private List<Decl> declarations;
	private List<Stmt> statements;
	
	// No return type, "default" constructor
	public ProcDecl(String name) {
		super(name);
		this.params = new ArrayList<ParamFieldDecl>();
		this.declarations = new ArrayList<Decl>();
		this.statements = new ArrayList<Stmt>();
	}

	// No return type, given params
	public ProcDecl(String name, List<ParamFieldDecl> params) {
		super(name);
		this.params = params;
	}

	// No return type, given params and statements
	public ProcDecl(String name,
			List<ParamFieldDecl> params,
			List<Stmt> statements) {
		super(name);
		this.params = params;
		this.declarations = declarations;
		this.statements = statements;
	}

	// Given return type
	public ProcDecl(String name, Type returnType) {
		super(name);
		this.returnType = returnType;
	}

	// Given return type, given params and statements
	public ProcDecl(String name,
       			List<ParamFieldDecl> params,
				Type returnType,
       			List<Stmt> statements) {
       	super(name);
		this.returnType = returnType;
		this.params = params;
       	this.declarations = declarations;
       	this.statements = statements;
	}

	// No return type, given params, decl and stmts
	public ProcDecl(String name, 
			List<ParamFieldDecl> params, 
			List<Decl> declarations, 
			List<Stmt> statements) {
		super(name);
		this.params = params;
		this.declarations = declarations;
		this.statements = statements;
	}

	// Given return type, params, decl and stmts
	public ProcDecl(String name, 
			List<ParamFieldDecl> params, 
			Type returnType, 
			List<Decl> declarations, 
			List<Stmt> statements) {
		super(name);
		this.returnType = returnType;
		this.params = params;
		this.declarations = declarations;
		this.statements = statements;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(PROCEDURE ");
		builder.append("(NAME ");
		builder.append(this.getName());
		builder.append(")");

		if(returnType != null)
			builder.append(" : " + this.returnType.printAst(level));
		
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
}
