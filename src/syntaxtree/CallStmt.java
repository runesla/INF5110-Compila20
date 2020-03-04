package syntaxtree;

public class CallStmt extends Stmt {

	private String name;
	private Expr e;

	public CallStmt(String name, Expr e) {
		this.name = name;
		this.e = e;
	}
}
