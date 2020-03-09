package syntaxtree;

public class LogOpExpr extends Expr {

	private String operator;
	private Expr e1;
	private Expr e2;

	public LogOpExpr(Expr e1, String operator, Expr e2) {
		this.e1 = e1;
		this.operator = operator;
		this.e2 = e2;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(LOG_OP_EXPR " + e1.printAst(level) + operator + e2.printAst(level) + ")";
		return print;
	}
}
