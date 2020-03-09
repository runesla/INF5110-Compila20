package syntaxtree;

public class NullLiteral extends LiteralExpr {

	public NullLiteral() { }

	@Override
	public String printAst(int level) {
		return "(NULL_LITERAL)";
	}
}
