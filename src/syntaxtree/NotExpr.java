package syntaxtree;

public class NotExpr extends Expr {

	private Expr e;

	public NotExpr(Expr e) {
		this.e = e;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(NOT_EXPR " + e.printAst(level) + ")";
		return print;
	}
}
