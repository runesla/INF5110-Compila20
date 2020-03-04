package syntaxtree;

public class AssignStmt extends Stmt {
	
	private VarExpr var_e;
	private Expr e;

	public AssignStmt(VarExpr var_e, Expr e) {
		this.var_e = var_e;
		this.e = e;
	}
}
