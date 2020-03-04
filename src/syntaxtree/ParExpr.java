package syntaxtree;

public class ParExpr extends UnaryExpr {

	private VarExpr e;

	public ParExpr(VarExpr e) {
		this.e = e;
	}
}
