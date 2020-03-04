package syntaxtree;

public class NewExpr extends UnaryExpr {

	private Type type;
	
	public NewExpr(Type type) {
		this.type = type;
	}

}
