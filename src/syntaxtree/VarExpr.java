package syntaxtree;

public class VarExpr extends UnaryExpr {

	private String name;
	private Expr e;

	public VarExpr(String name, Expr e) {
		this.name = name;
		this.e = e;
	}

}
