package syntaxtree;

public class RefType extends Type {

	private Type type;

	public RefType(Type type) {
		this.type = type;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(REF_TYPE ");
		builder.append(this.type.printAst(level));
		builder.append(")");
		return builder.toString();
	}
}
