package syntaxtree;

public class FloatLiteral extends LiteralExpr {

	private Float literal;

	public FloatLiteral(Float literal) {
		this.literal = literal;
	}

	@Override
	public String printAst(int level) {
		return "(FLOAT_LITERAL " + this.literal.toString() + ")";	
	}
}
