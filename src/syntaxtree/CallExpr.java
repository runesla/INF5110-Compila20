package syntaxtree;

public class CallExpr extends UnaryExpr {
	
	private CallStmt callStatement;

	public CallExpr(CallStmt callStatement) {
		this.callStatement = callStatement;
	}
}
