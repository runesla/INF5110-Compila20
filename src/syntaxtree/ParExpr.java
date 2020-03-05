package syntaxtree;

public class ParExpr extends Expr {

	private Expr e;

	public ParExpr(Expr e) {
		this.e = e;
	}
}
