package syntaxtree;

import java.util.*;

public class ProcDecl extends Decl {

	private Type returnType;
	List<ParamFieldDecl> params;
	List<Decl> declarations;
	List<Stmt> statements;
	
	// No return type, "default" constructor
	public ProcDecl(String name) {
		super(name);
		this.params = new ArrayList<ParamFieldDecl>();
		this.declarations = new ArrayList<Decl>();
		this.statements = new ArrayList<Stmt>();
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
			Type returnType, 
			List<ParamFieldDecl> params, 
			List<Decl> declarations, 
			List<Stmt> statements) {
		super(name);
		this.returnType = returnType;
		this.params = params;
		this.declarations = declarations;
		this.statements = statements;
	}
	
}
