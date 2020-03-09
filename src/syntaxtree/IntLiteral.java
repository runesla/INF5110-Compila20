package syntaxtree;

public class IntLiteral extends LiteralExpr {

	private Integer literal;

	public IntLiteral(Integer literal) {
		this.literal = literal;
	}
	
	@Override
	public String printAst(int level) {
		return "(INT_LITERAL " + this.literal.toString() + ")";
	}
}
