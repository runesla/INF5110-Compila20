package syntaxtree.expr.literals;

import syntaxtree.expr.LiteralExpr;

public class StringLiteral extends LiteralExpr {

	private final String literal;

	public StringLiteral(String literal) {
		this.literal = literal;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(STRING_LITERAL ");
		builder.append(this.literal);
		builder.append(")");
		return builder.toString();
	}
}
