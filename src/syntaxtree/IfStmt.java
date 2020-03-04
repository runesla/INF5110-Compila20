package syntaxtree;

public class IfStmt extends Stmt {
	
	private Expr e;
	private List<Stmt> stmt1;
	private List<Stmt> stmt2;

	// No ELSE-part constructor
	public IfStmt(Expr e, List<Stmt> stmt1) {
		this.e = e;
		this.stmt1 = stmt1;
	}

	// ELSE-part constructor
	public IfStmt(Expr e, List<Stmt> stmt1, List<Stmt> stmt2) {
		this.e = e;
		this.stmt1 = stmt1;
		this.stmt2 = stmt2;
	}
}
