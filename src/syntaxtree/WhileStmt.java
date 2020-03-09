package syntaxtree;

import java.util.*;

public class WhileStmt extends Stmt {
	
	private Expr e;
	private List<Stmt> statements;

	public WhileStmt(Expr e, List<Stmt> statements) {
		this.e = e;
		this.statements = statements;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(WHILE_STMT " + e.printAst(level);
		
		for(Stmt s: statements) {
			print += "\t + " + s.printAst(level + 1) + "\n";
		}
		
		return print;
	}
}
