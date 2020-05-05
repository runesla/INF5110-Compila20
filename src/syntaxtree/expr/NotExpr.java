package syntaxtree.expr;

public class NotExpr extends Expr {

	private final Expr expr;

	public NotExpr(Expr expr) {
		this.expr = expr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(NOT_EXPR ");
		builder.append(expr.printAst(level + 1));
		builder.append(")");

		return builder.toString();
	}

	@Override
	public String getType() {
		return expr.getType();
	}
}
