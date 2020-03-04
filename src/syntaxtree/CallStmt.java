package syntaxtree;

public class CallStmt extends Stmt {

	private String name;
	private Expr e;

	public CallStmt(String name, Expr e) {
		super(name);
		this.e = e;
	}
}
