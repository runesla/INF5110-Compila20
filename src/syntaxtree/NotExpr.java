package syntaxtree;

public class NotExpr extends Expr {

	private Expr e;

	public NotExpr(Expr e) {
		this.e = e;
	}
}
