package syntaxtree.decl;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.LOADLOCAL;
import bytecode.instructions.RETURN;
import bytecode.instructions.STORELOCAL;
import bytecode.type.*;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import common.error.SyntaxException;
import common.utils.BytecodeTypes;
import common.utils.TypeChecker;
import syntaxtree.stmt.ReturnStmt;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.stmt.Stmt;
import syntaxtree.types.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static common.utils.StringUtil.*;

public class ProcDecl extends Decl {

	private final DataType returnDataType;
	private final List<ParamDecl> params;
	private final List<Decl> declarations;
	private final List<Stmt> statements;
	
	// No return type, "default" constructor
	public ProcDecl(Name name) {
		super(name);
		this.returnDataType = new DataType(Type.VOID);
		this.params = new ArrayList<>();
		this.declarations = new ArrayList<>();
		this.statements = new ArrayList<>();
	}

	// No return type, given params
	public ProcDecl(
			Name name,
			List<ParamDecl> params) {
		super(name);
		this.returnDataType = new DataType(Type.VOID);
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
		this.returnDataType = new DataType(Type.VOID);
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
		this.returnDataType = new DataType(Type.VOID);
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

				// Ensure only one presence of return statements
				if(!returnStmtPresent) {
					returnStmtPresent = true;
				} else {
					throw new SemanticException("Multiple return statements in procedure " + this.getName().getNameValue());
				}

				if (!(TypeChecker.isCompatibleType(((ReturnStmt) stmt).getDataType(), this.returnDataType))) {
					throw new SemanticException("Type mismatch between procedure and return statement in procedure " + this.getName().getNameValue());
				}
			}
		}

		// Check return statement
		if(!returnStmtPresent && (returnDataType.getType() != Type.VOID)) {
			throw new SemanticException("Missing return statement");
		}
	}

	@Override
	public void generateCode(CodeFile codeFile) throws CodeGenException {

		String procName = this.getName().getNameValue();
		CodeType returnType = null;

		if(this.returnDataType.getType() == Type.UDT) {
			returnType = new RefType(codeFile.structNumber(this.returnDataType.getName().getNameValue()));
		} else {
			returnType = BytecodeTypes.getCodeType(this.returnDataType);
		}

		codeFile.addProcedure(procName);
		CodeProcedure proc = new CodeProcedure(procName, returnType, codeFile);

		// Generate code for params and add to procedure
		for(ParamDecl paramDecl: params) {
			paramDecl.generateCode(codeFile);
			CodeType paramType = null;

			if(paramDecl.getDataType().getType() == Type.UDT) {
				paramType = new RefType(codeFile.structNumber(paramDecl.getDataType().getName().getNameValue()));
				//proc.addParameter(paramDecl.getName().getNameValue(), new RefType(codeFile.structNumber(paramDecl.getDataType().getName().getNameValue())));
			} else {
				paramType = BytecodeTypes.getCodeType(paramDecl.getDataType());
				//proc.addParameter(paramDecl.getName().getNameValue(), BytecodeTypes.getCodeType(paramDecl.getDataType()));
			}
			proc.addParameter(paramDecl.getName().getNameValue(), paramType);
			//proc.addInstruction(new STORELOCAL(proc.variableNumber(paramDecl.getName().getNameValue())));		// TODO: move to VarExpr?
		}

		// Generate code for declarations and add to procedure
		for(Decl varDecl: declarations) {
			varDecl.generateCode(codeFile);
			CodeType varType = null;

			if(varDecl.getDataType().getType() == Type.UDT) {
				varType = new RefType(codeFile.structNumber(varDecl.getDataType().getName().getNameValue()));
			} else {
				varType = BytecodeTypes.getCodeType(varDecl.getDataType());
			}
			proc.addLocalVariable(varDecl.getName().getNameValue(), varType);
		}

		// Generate code for statements and add instructions to procedure
		for(Stmt stmt: statements) {
			stmt.generateCode(proc);

			if(stmt instanceof ReturnStmt) {
				proc.addInstruction(new RETURN());
			}
		}

		codeFile.updateProcedure(proc);
	}
}
