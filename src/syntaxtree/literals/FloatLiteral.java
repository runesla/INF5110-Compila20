package syntaxtree;

public class FloatLiteral extends LiteralExpr {

	private Float literal;

	public FloatLiteral(Float literal) {
		this.literal = literal;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(FLOAT_LITERAL ");
		builder.append(this.literal.toString());
		builder.append(")");
		return builder.toString();
	}

	@Override
	public String getType() {
		return "float";
	}
}
