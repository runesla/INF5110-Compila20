package syntaxtree;

public class VarDecl extends Decl {
	
	private Type type;
	private Expr expr;

	public VarDecl(String name, Type type) {
		super(name);
		this.type = type;
	}

	public VarDecl(String name, Expr expr) {
		super(name);
		this.expr = expr;
	}

	public VarDecl(String name, Type type, Expr expr) {
		super(name);
		this.type = type;
		this.expr = expr;
	}

	@Override
	public String printAst(int level) {
		return "(VAR_DECL " + this.type.printAst(level + 1) + " (NAME " + this.getName() + "))";
	}
}
