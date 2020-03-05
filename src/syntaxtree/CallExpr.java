package syntaxtree;

public class CallExpr extends Expr {
	
	private CallStmt callStatement;

	public CallExpr(CallStmt callStatement) {
		this.callStatement = callStatement;
	}
}
