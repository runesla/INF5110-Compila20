package syntaxtree;

public class ParExpr extends Expr {

	private Expr e;

	public ParExpr(Expr e) {
		this.e = e;
	}
	
	@Override
	public String printAst(int level) {
		return "(PAR_EXPR " + e.printAst(level) + "\n";
	}
}
