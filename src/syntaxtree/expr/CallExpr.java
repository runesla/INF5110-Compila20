package syntaxtree.expr;

import syntaxtree.stmt.CallStmt;
import static syntaxtree.StringUtil.*;

public class CallExpr extends Expr {
	
	private final CallStmt callStmt;

	public CallExpr(CallStmt callStmt) {
		this.callStmt = callStmt;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(CALL_EXPR ");
		builder.append("\n" + repeat("\t", level + 1) + callStmt.printAst(level + 1));
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public String getType() {
		return callStmt.getType();
	}
}
