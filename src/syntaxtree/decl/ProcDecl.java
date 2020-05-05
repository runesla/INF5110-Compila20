package syntaxtree.decl;

import error.SyntaxException;
import syntaxtree.Type;
import syntaxtree.stmt.Stmt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import static syntaxtree.StringUtil.*;

public class ProcDecl extends Decl {

	private Type returnType;
	private final List<ParamFieldDecl> params;
	private final List<Decl> declarations;
	private final List<Stmt> statements;
	
	// No return type, "default" constructor
	public ProcDecl(String name) {
		super(name);
		this.params = new ArrayList<>();
		this.declarations = new ArrayList<>();
		this.statements = new ArrayList<>();
	}

	// No return type, given params
	public ProcDecl(String name, List<ParamFieldDecl> params) {
		super(name);
		this.params = params;
		this.declarations = new ArrayList<>();
		this.statements = new ArrayList<>();
	}

	// No return type, given params and statements
	public ProcDecl(
				String name,
				List<ParamFieldDecl> params,
				List<Stmt> statements) {
		super(name);
		this.params = params;
		this.statements = statements;
		this.declarations = new ArrayList<>();
	}

	// Given return type
	public ProcDecl(String name, Type returnType) {
		super(name);
		this.returnType = returnType;
		this.params = new ArrayList<>();
		this.statements = new ArrayList<>();
		this.declarations = new ArrayList<>();
	}

	// Given return type, given params and statements
	public ProcDecl(
				String name,
				Type returnType,
       			List<ParamFieldDecl> params,
       			List<Stmt> statements) {
       	super(name);
		this.returnType = returnType;
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
		super(name);
		this.params = params;
		this.declarations = declarations;
		this.statements = statements;
	}

	// Given return type, params, decl and stmts
	public ProcDecl(
				String name,
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

	@Override
	public String getType() {
		return this.returnType.getTypeNameValue();
	}

	@Override
	public void fieldTypeCheck(HashMap<String, String> types, HashMap<String, ProcDecl> procs) throws SyntaxException {

		procs.put(this.getName(), this);

		// Check for duplicate parameters
		for (ParamFieldDecl param: params) {
			if(types.containsKey(param.getName())) {
				throw new SyntaxException("Duplicate declaration found: " + param.getName() + " in procedure " + this.getName());
			}
			types.put(param.getName(), param.getType());
		}

		// Check all formal parameters being distinct
		for (Decl decl: declarations) {
			if(Collections.frequency(declarations, decl) > 1) {
				throw new SyntaxException("Duplicate formal parameter found: " + decl.getName() + " in procedure " + this.getName());
			}
		}

		// Check return type
		if(!types.containsKey(this.returnType.getTypeNameValue())) {
			throw new SyntaxException("Invalid return type: " + this.returnType.getName() + " in procedure " + this.getName());
		}
	}
}
