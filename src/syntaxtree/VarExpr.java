package syntaxtree;

import static syntaxtree.StringUtil.*;

public class VarExpr extends Expr {

	private String name;
	private Expr expr;
	private Type type;

	public VarExpr(String name) {
		this.name = name;
	}

	public VarExpr(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	public VarExpr(String name, Expr expr) {
		this.name = name;
		this.expr = expr;
	}

	public VarExpr(String name, Type type, Expr expr) {
		this.name = name;
		this.type = type;
		this.expr = expr;
	}

	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(VAR ");
		builder.append(this.name);
				
		if(this.expr != null)
			builder.append("\n" + repeat("\t", level + 1) + this.expr.printAst(level + 1));

		if(this.type != null)
			builder.append("\n" + repeat("\t", level + 1) + " : " + this.type.printAst(level + 1));
		
		builder.append("\n" + repeat("\t", level) + ")");

		return builder.toString();
	}
}
