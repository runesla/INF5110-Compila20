package syntaxtree;

import java.util.*;
import static syntaxtree.StringUtil.*;

public class IfStmt extends Stmt {
	
	private Expr expr;
	private List<Stmt> stmt1;
	private List<Stmt> stmt2;

	// No ELSE-part constructor
	public IfStmt(Expr expr, 
			List<Stmt> stmt1) {
		this.expr = expr;
		this.stmt1 = stmt1;
	}

	// ELSE-part constructor
	public IfStmt(Expr expr, 
			List<Stmt> stmt1, 
			List<Stmt> stmt2) {
		this.expr = expr;
		this.stmt1 = stmt1;
		this.stmt2 = stmt2;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(IF_STMT ");
		builder.append(expr.printAst(level));	

		for(Stmt s : stmt1) {
			builder.append("\n" + repeat("\t", level + 1) + s.printAst(level + 1));
		}
		
		if(stmt2 != null) {
			for(Stmt s: stmt2) {
				builder.append("\n" + repeat("\t", level + 1) + s.printAst(level + 1));
			}
		}
		
		builder.append("\n" + repeat("\t", level) + ")");
		
		return builder.toString();		

	}

	@Override
	public void typeCheck() {
		String condType = condition.get.Type();
		
		if(condType != "bool") {
			throw new TypeException("condition in an if statement must be of type bool");
		}
	}
}
