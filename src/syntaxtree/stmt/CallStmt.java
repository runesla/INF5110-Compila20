package syntaxtree.stmt;

import syntaxtree.expr.Expr;
import java.util.LinkedList;
import java.util.List;
import static common.utils.StringUtil.*;

public class CallStmt extends Stmt {

	private final String name;
	private List<Expr> expr;

	public CallStmt(String name, List<Expr> expr) {
		this.name = name;
		this.expr = expr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(CALL_STMT ");
		builder.append(this.name);
		
		for(Expr e: expr) {
			builder.append("\n" + repeat("\t", level + 1) + e.printAst(level + 1));
		}
		
		builder.append("\n" + repeat("\t", level) + ")");		
		
		return builder.toString();
	}
}
