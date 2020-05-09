package syntaxtree.stmt;

import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.expr.Expr;
import syntaxtree.types.DataType;

import java.util.List;
import static common.utils.StringUtil.*;

public class WhileStmt extends Stmt {
	
	private final Expr expr;
	private List<Stmt> statements;

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

		for(Stmt stmt: statements) {
			stmt.generateCode(proc);
		}
	}
}
