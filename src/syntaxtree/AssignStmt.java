package syntaxtree;

public class AssignStmt extends Stmt {
	
	private Expr e;
	private VarExpr var_e;
	private DerefVarExpr deref_e;

	public AssignStmt(VarExpr var_e, Expr e) {
		this.var_e = var_e;
		this.e = e;
	}
	
	public AssignStmt(DerefVarExpr deref_e, Expr e) {
		this.deref_e = deref_e;
		this.e = e;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(ASSIGN_STMT " + this.e.printAst(level);
		
		if(this.var_e != null)
			print += var_e.printAst(level);
		else
			print += deref_e.printAst(level);
		
		print += ")";
		
		return print;
	}
}
