package syntaxtree;

public class RefVarExpr extends Expr {
	
	private VarExpr e;

	public RefVarExpr(VarExpr e) {
		this.e = e;
	}

	@Override
	public String printAst(int level) {
		return "(REF_VAR " + e.printAst(level) + ")";
	}
}
