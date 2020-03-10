package syntaxtree;

import static syntaxtree.StringUtil.*;

public class ParamFieldDecl extends Decl {

	private Type type;

	public ParamFieldDecl(String name, Type type) {
		super(name);
		this.type = type;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(PARAMFIELD_DECL");
		builder.append("\n" + repeat("\t", level + 1) + "(NAME ");
		builder.append(this.getName());
		builder.append(" : ");
		builder.append(this.type.printAst(level + 1);
		builder.append(")");
		builder.append("\n" + repeat("\t", level) + ")");

		return builder.toString();
	}
}
