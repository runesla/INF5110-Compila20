package syntaxtree;

public class BoolLiteral extends LiteralExpr {

	private Boolean literal;

	public BoolLiteral(Boolean literal) {
		this.literal = literal;
	}

	@Override
	public String printAst(int level) {
		return "(BOOL_LITERAL " + this.literal.toString() + ")";
	}
}
