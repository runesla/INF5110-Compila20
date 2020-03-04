package syntaxtree;

public class ParExpr extends UnaryExpr {

	private Expr e;

	public ParExpr(Expr e) {
		this.e = e;
	}
}
