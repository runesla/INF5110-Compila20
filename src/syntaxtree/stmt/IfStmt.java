package syntaxtree.stmt;

import java.util.*;
import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.expr.Expr;
import syntaxtree.types.DataType;
import static common.utils.StringUtil.*;

public class IfStmt extends Stmt {
	
	private final Expr expr;
	private final List<Stmt> stmt1;
	private List<Stmt> stmt2;

	// No ELSE-part constructor
	public IfStmt(Expr expr, List<Stmt> stmt1) {
		this.expr = expr;
		this.stmt1 = stmt1;
	}

	// ELSE-part constructor
	public IfStmt(Expr expr, 
			List<Stmt> stmt1, 
			List<Stmt> stmt2) {
		this.expr = expr;
		this.stmt1 = stmt1;
		this.stmt2 = stmt2;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(IF_STMT ");
		builder.append(expr.printAst(level));
		for(Stmt s : stmt1) {
			builder.append("\n" + repeat("\t", level + 1) + s.printAst(level + 1));
		}
		if(stmt2 != null) {
			for(Stmt s: stmt2) {
				builder.append("\n" + repeat("\t", level + 1) + s.printAst(level + 1));
			}
		}
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		this.expr.generateCode(proc);

		for(Stmt stmt: stmt1) {
			stmt.generateCode(proc);
		}

		for(Stmt stmt: stmt2) {
			stmt.generateCode(proc);
		}
	}
}
