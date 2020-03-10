package syntaxtree;

import static syntaxtree.StringUtil.*;

public class AssignStmt extends Stmt {
	
	private Expr expr;
	private VarExpr varExpr;
	private DerefVarExpr derefExpr;

	public AssignStmt(VarExpr varExpr, Expr expr) {
		this.varExpr = varExpr;
		this.expr = expr;
	}
	
	public AssignStmt(DerefVarExpr deref_e, Expr e) {
		this.derefExpr = derefExpr;
		this.expr = expr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(ASSIGN_STMT ");
		builder.append("\n" + repeat("\t", level + 1));
		builder.append(expr.printAst(level + 1));
		
		if(this.varExpr != null)
			builder.append(this.varExpr.printAst(level + 1));
		else
			builder.append(this.derefExpr.printAst(level + 1));
		
		builder.append("\n" + repeat("\t", level) + ")");
		
		return builder.toString();
	}
}
