package syntaxtree;

public class VarExpr extends Expr {

	private String name;
	private Expr e;
	private Type type;

	public VarExpr(String name) {
		this.name = name;
	}

	public VarExpr(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	public VarExpr(String name, Expr e) {
		this.name = name;
		this.e = e;
	}

	public VarExpr(String name, Type type, Expr e) {
		this.name = name;
		this.type = type;
		this.e = e;
	}

}
