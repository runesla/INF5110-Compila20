package syntaxtree;

import java.util.*;

public class ProcDecl extends Decl {

	List<ParamFieldDecl> params;
	private Type returnType;
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
		String print = "(PROCEDURE " + this.getName();
		
		if(params != null) {
			for(ParamFieldDecl p: params) {
				print += "\t" + p.printAst(level + 1) + "\n";
			}
		}
		
		if(returnType != null)
			print += this.returnType.toString();
		
		if(declarations != null) {
			for(Decl d: declarations) {
				print += "\t" + d.printAst(level + 1) + "\n";
			}
		}
		
		if(statements != null) {
			for(Stmt s: statements) {
				print += "\t" + s.printAst(level + 1) + "\n";
			}
		}
		
		print += ")";
		
		return print;
	}
}
