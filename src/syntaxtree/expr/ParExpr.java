package syntaxtree;

public class ParExpr extends Expr {

	private Expr expr;

	public ParExpr(Expr expr) {
		this.expr = expr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(PAR_EXPR ");
		builder.append(expr.printAst(level));
		builder.append(")");
		return builder.toString();
	}
}
