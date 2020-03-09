package syntaxtree;

import java.util.*;

public class CallStmt extends Stmt {

	private String name;
	private List<Expr> e;

	public CallStmt(String name, List<Expr> e) {
		this.name = name;
		this.e = e;
	}
}
