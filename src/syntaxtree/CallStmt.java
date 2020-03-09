package syntaxtree;

import java.util.*;

public class CallStmt extends Stmt {

	private String name;
	private List<Expr> e;

	public CallStmt(String name, List<Expr> e) {
		this.name = name;
		this.e = e;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(CALL_STMT " + this.name + "\n";
		
		for(Expr exp: e) {
			print += "\t" + exp.printAst(level + 1) + "\n";
		}
		
		return print;
	}
}
