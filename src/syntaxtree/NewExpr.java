package syntaxtree;

public class NewExpr extends Expr {

	private Type type;
	
	public NewExpr(Type type) {
		this.type = type;
	}

	@Override
	public String printAst(int level) {
		String print = "(NEW_EXPR " + this.type.toString() + ")";
		return print;
	}
}
