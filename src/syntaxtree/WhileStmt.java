package syntaxtree;

import java.util.*;

public class WhileStmt extends Stmt {
	
	private Expr e;
	private List<Stmt> statements;

	public WhileStmt(Expr e, List<Stmt> statements) {
		this.e = e;
		this.statements = statements;
	}
}
