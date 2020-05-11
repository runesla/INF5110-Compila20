package syntaxtree.stmt;

import java.util.*;
import bytecode.CodeProcedure;
import bytecode.instructions.*;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import common.utils.BytecodeTypes;
import syntaxtree.expr.Expr;
import syntaxtree.expr.VarExpr;

import static common.utils.StringUtil.*;

public class IfStmt extends Stmt {
	
	private final Expr expr;
	private final List<Stmt> ifThenStmt;
	private List<Stmt> elseStmt;

	// No ELSE-part constructor
	public IfStmt(Expr expr, List<Stmt> ifThenStmt) {
		this.expr = expr;
		this.ifThenStmt = ifThenStmt;
	}

	// ELSE-part constructor
	public IfStmt(Expr expr, 
			List<Stmt> ifThenStmt,
			List<Stmt> elseStmt) {
		this.expr = expr;
		this.ifThenStmt = ifThenStmt;
		this.elseStmt = elseStmt;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(IF_STMT ");
		builder.append(expr.printAst(level));
		for(Stmt s : ifThenStmt) {
			builder.append("\n" + repeat("\t", level + 1) + s.printAst(level + 1));
		}
		if(elseStmt != null) {
			for(Stmt s: elseStmt) {
				builder.append("\n" + repeat("\t", level + 1) + s.printAst(level + 1));
			}
		}
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		this.expr.typeCheck(symbolTable);

		for(Stmt stmt: ifThenStmt) {
			stmt.typeCheck(symbolTable);
		}

		if(elseStmt != null) {
			for (Stmt stmt: elseStmt) {
				stmt.typeCheck(symbolTable);
			}
		}
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {

		this.expr.generateCode(proc);

		//int labelIfThenStmt = proc.addInstruction(new NOP());
		//int labelIfThenStmt = proc.addInstruction(new JMPFALSE(0));

		for(Stmt stmt: ifThenStmt) {
			stmt.generateCode(proc);
		}

		//int labelIfThenStmtExecuted = proc.addInstruction(new NOP());
		int labelIfThenStmtExecuted = -1;

		if(elseStmt != null) {

			labelIfThenStmtExecuted = proc.addInstruction(new JMP(0));

			for (Stmt stmt : elseStmt) {
				stmt.generateCode(proc);
			}

			//int labelElseStmtExecuted = proc.addInstruction(new NOP());
			//proc.replaceInstruction(labelIfThenStmtExecuted, new JMP(labelElseStmtExecuted));
		}

		//int labelIfStmtCompleted = proc.addInstruction(new NOP());
		//proc.replaceInstruction(labelIfThenStmt, new JMPFALSE(labelIfStmtCompleted));

		//proc.replaceInstruction(labelIfThenStmt, new JMPTRUE(labelIfThenStmt));
		//proc.replaceInstruction(labelIfThenStmt, new JMPFALSE(labelIfThenStmtExecuted));
	}
}
