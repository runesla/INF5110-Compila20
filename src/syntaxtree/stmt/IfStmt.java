package syntaxtree.stmt;

import java.util.*;
import bytecode.CodeProcedure;
import bytecode.instructions.*;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.expr.Expr;
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

		// Start - top - of conditional
		int labelConditionalIfStart = proc.addInstruction(new NOP());

		for(Stmt stmt: ifThenStmt) {
			stmt.generateCode(proc);
		}

		// After then-stmt
		int labelConditionalIfComplete = proc.addInstruction(new NOP());

		if(elseStmt != null) {

			// Start - top - of else-stmt
			int labelConditionalElseStart = proc.addInstruction(new NOP());

			for (Stmt stmt : elseStmt) {
				stmt.generateCode(proc);
			}

			// After else-stmt
			int labelConditionalElseComplete = proc.addInstruction(new NOP());

			// If top of stack is false, replace start (top) label with else label
			proc.replaceInstruction(labelConditionalIfStart, new JMPFALSE(labelConditionalElseStart));
			proc.replaceInstruction(labelConditionalIfComplete, new JMP(labelConditionalElseComplete));
		}

		// If top of stack is false, replace start (top) label with if-stmt-complete label
		proc.replaceInstruction(labelConditionalIfStart, new JMPFALSE(labelConditionalIfComplete));
	}
}
