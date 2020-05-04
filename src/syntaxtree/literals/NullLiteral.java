package syntaxtree;

public class NullLiteral extends LiteralExpr {

	public NullLiteral() { }

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(NULL_LITERAL)");
		return builder.toString();
	}

	@Override
	public String getType() {
		return "null";
	}
}
