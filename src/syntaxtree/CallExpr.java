package syntaxtree;

public class CallExpr extends Expr {
	
	private CallStmt callStatement;

	public CallExpr(CallStmt callStatement) {
		this.callStatement = callStatement;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(CALL_EXPR " + callStatement.toString() + ")";
		return print;
	}
}
