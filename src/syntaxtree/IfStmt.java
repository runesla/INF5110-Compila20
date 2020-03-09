package syntaxtree;

import java.util.*;

public class IfStmt extends Stmt {
	
	private Expr e;
	private List<Stmt> stmt1;
	private List<Stmt> stmt2;

	// No ELSE-part constructor
	public IfStmt(Expr e, List<Stmt> stmt1) {
		this.e = e;
		this.stmt1 = stmt1;
	}

	// ELSE-part constructor
	public IfStmt(Expr e, List<Stmt> stmt1, List<Stmt> stmt2) {
		this.e = e;
		this.stmt1 = stmt1;
		this.stmt2 = stmt2;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(IF_STMT " + e.printAst(level);
		
		for(Stmt s : stmt1) {
			print += "\t" + s.printAst(level + 1) + "\n";
		}
		
		if(stmt2 != null) {
			for(Stmt s: stmt2) {
				print += "\t" + s.printAst(level + 1) + "\n";
			}
		}
		
		return print;
	}
	
}
