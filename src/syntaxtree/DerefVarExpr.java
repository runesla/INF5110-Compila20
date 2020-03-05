package syntaxtree;

public class DerefVarExpr extends Expr {

	private VarExpr e;

	public DerefVarExpr(VarExpr e) {
		this.e = e;
	}

}
