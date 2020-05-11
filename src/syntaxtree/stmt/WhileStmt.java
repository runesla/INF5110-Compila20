package syntaxtree.stmt;

import bytecode.CodeProcedure;
import bytecode.instructions.JMP;
import bytecode.instructions.JMPFALSE;
import bytecode.instructions.JMPTRUE;
import bytecode.instructions.NOP;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.expr.Expr;
import java.util.List;
import static common.utils.StringUtil.*;

public class WhileStmt extends Stmt {
	
	private final Expr expr;
	private final List<Stmt> statements;

	public WhileStmt(Expr expr, List<Stmt> statements) {
		this.expr = expr;
		this.statements = statements;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(WHILE_STMT ");
		builder.append(this.expr.printAst(level));
		for(Stmt s: statements) {
			builder.append("\n" + repeat("\t", level + 1) + s.printAst(level + 1));
		}
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {
		this.expr.typeCheck(symbolTable);

		for(Stmt stmt: statements) {
			stmt.typeCheck(symbolTable);
		}
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		this.expr.generateCode(proc);

		int labelTopLoop = proc.addInstruction(new NOP());

		for(Stmt stmt: statements) {
			stmt.generateCode(proc);
		}

		int labelSkipLoop = proc.addInstruction(new NOP());

		proc.addInstruction(new JMPTRUE(labelTopLoop));			// TODO: how?
		proc.addInstruction(new JMPFALSE(labelSkipLoop));
	}
}
