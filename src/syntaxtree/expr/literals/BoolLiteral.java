package syntaxtree.expr.literals;

import syntaxtree.expr.LiteralExpr;

public class BoolLiteral extends LiteralExpr {

	private final Boolean literal;

	public BoolLiteral(Boolean literal) {
		this.literal = literal;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(BOOL_LITERAL ");
		builder.append(this.literal.toString());
		builder.append(")");
	
		return builder.toString();
	}

	@Override
	public String getDataType() {
		return "bool";
	}
}
