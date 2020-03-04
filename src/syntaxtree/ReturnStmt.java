package syntaxtree;

public class ReturnStmt extends Stmt {
	
	private Expr e;

	public ReturnStmt(Expr e) {
		this.e = e;
	}
}
