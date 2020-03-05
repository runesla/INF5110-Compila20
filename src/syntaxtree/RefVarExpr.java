package syntaxtree;

public class RefVarExpr extends Expr {
	
	private VarExpr e;

	public RefVarExpr(VarExpr e) {
		this.e = e;
	}

}
