package syntaxtree.expr;

import static syntaxtree.StringUtil.*;

public class LogOpExpr extends Expr {

	private final String operator;
	private final Expr e1;
	private final Expr e2;

	public LogOpExpr(Expr e1, String operator, Expr e2) {
		this.e1 = e1;
		this.operator = operator;
		this.e2 = e2;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(LOG_OP_EXPR ");
		builder.append("\n" + repeat("\t", level + 1) + e1.printAst(level + 1));
		builder.append("\n" + repeat("\t", level + 1) + operator);
		builder.append("\n" + repeat("\t", level + 1) + e2.printAst(level + 1));

		return builder.toString();
	}

	@Override
	public String getType() {
		return "bool";
	}
}