package syntaxtree;

import static syntaxtree.StringUtil.*;
import typesystem.TypeCheck;

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

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();

		if(this.expr != null) {
			builder.append(this.expr.printAst(level + 1));
			builder.append(" . ");
		}

		builder.append("(NAME ");
		builder.append(this.name);
		builder.append(")");

		return builder.toString();
	}

	@Override
	public String getType() {
		if(type != null) {
			return type.getTypeNameValue();
		}

		return this.name;
	}
}
