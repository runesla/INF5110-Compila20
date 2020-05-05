package syntaxtree.stmt;

import syntaxtree.expr.Expr;
import java.util.List;
import static common.StringUtil.*;

public class WhileStmt extends Stmt {
	
	private Expr expr;
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
}
