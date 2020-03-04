package syntaxtree;

public class RefVarExpr extends UnaryExpr {
	
	private VarExpr e;

	public RefVarExpr(VarExpr e) {
		this.e = e;
	}

}
