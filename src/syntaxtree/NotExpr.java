package syntaxtree;

public class NotExpr extends UnaryExpr {

	private Expr e;

	public NotExpr(Expr e) {
		this.e = e;
	}
}
