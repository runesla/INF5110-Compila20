package syntaxtree.decl;

import static syntaxtree.StringUtil.*;

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

	public Type getType() {
		return type;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(VAR_DECL ");
		builder.append("\n" + repeat("\t", level + 1) + this.type.printAst(level));
		builder.append(" : ");
		builder.append(" (NAME ");
		builder.append(this.getName());
		builder.append(")");
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}
}
