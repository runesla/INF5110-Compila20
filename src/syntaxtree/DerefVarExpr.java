package syntaxtree;

public class DerefVarExpr extends Expr {

	private VarExpr expr;

	public DerefVarExpr(VarExpr expr) {
		this.expr = expr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(DEREF_VAR ");
		builder.append(this.expr.printAst(level));
		builder.append(")");
		return builder.toString();
	}
}
