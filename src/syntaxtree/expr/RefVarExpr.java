package syntaxtree.expr;

public class RefVarExpr extends Expr {
	
	private final VarExpr expr;

	public RefVarExpr(VarExpr expr) {
		this.expr = expr;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(REF_VAR ");
		builder.append(this.expr.printAst(level));
		builder.append(")");
		return builder.toString();
	}

	@Override
	public String getType() {
		return expr.getType();
	}
}
