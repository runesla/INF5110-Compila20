package syntaxtree.literals;

import syntaxtree.expr.LiteralExpr;

public class IntLiteral extends LiteralExpr {

	private final Integer literal;

	public IntLiteral(Integer literal) {
		this.literal = literal;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(INT_LITERAL ");
		builder.append(this.literal.toString());
		builder.append(")");
		return builder.toString();
	}

	@Override
	public String getType() {
		return "int";
	}
}
