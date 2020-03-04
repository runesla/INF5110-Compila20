package syntaxtree;

public class LogOpExpr extends BinaryExpr {

	private String operator;
	private Expr e1;
	private Expr e2;

	public LogOpExpr(Expr e1, String operator, Expr e2) {
		this.e1 = e1;
		this.operator = operator;
		this.e2 = e2;
	}
}
