package syntaxtree;

public class DerefVarExpr extends UnaryExpr {

	private VarExpr e;

	public DerefVarExpr(VarExpr e) {
		this.e = e;
	}

}
