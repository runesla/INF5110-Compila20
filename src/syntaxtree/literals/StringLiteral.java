package syntaxtree;

public class StringLiteral extends LiteralExpr {

	private String literal;

	public StringLiteral(String litereal) {
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

	@Override
	public String getType() {
		return "string";
	}
}
