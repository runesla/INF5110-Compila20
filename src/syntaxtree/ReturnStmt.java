package syntaxtree;

public class ReturnStmt extends Stmt {
	
	private Expr e;

	// Empty constructor for empty return types
	public ReturnStmt() {
		
	}
	
	public ReturnStmt(Expr e) {
		this.e = e;
	}
}
