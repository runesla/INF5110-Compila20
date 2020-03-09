package syntaxtree;

public class StringLiteral extends LiteralExpr {

	private String literal;

	public StringLiteral(String litereal) {
		this.literal = literal;
	}
	
	@Override
	public String printAst(int level) {
		return "(STRING_LITERAL " + this.literal + ")";
	}
}
