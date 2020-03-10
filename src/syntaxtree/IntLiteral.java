package syntaxtree;

public class IntLiteral extends LiteralExpr {

	private Integer literal;

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
}
