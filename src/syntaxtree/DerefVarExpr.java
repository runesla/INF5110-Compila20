package syntaxtree;

public class DerefVarExpr extends Expr {

	private VarExpr e;

	public DerefVarExpr(VarExpr e) {
		this.e = e;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(DEREF_VAR " + e.printAst(level) + ")";
		return print;
	}
}
