package syntaxtree;

public class ParamDecl extends Decl {

	private Type type;

	public ParamDecl(String name, Type type) {
		super(name);
		this.type = type;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(PARAM_DECL ");
		builder.append(this.getName());
		builder.append(this.type.printAst(level));
		builder.append(")");

		return builder.toString();
	}
}
