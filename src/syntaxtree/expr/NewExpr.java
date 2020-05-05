package syntaxtree.expr;

import syntaxtree.Type;

public class NewExpr extends Expr {

	private final Type type;
	
	public NewExpr(Type type) {
		this.type = type;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(NEW ");
		builder.append(this.type.printAst(level));
		builder.append(")");

		return builder.toString();
	}

	@Override
	public String getType() {
		return this.type.getTypeNameValue();
	}
}
