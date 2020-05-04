package syntaxtree;

import java.util.*;
import static syntaxtree.StringUtil.*;

public class CallStmt extends Stmt {

	private String name;
	private List<Expr> expr;
	private String type;

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

	@Override
	public String getType() {
		return this.type;
	}
}
