package syntaxtree;

import typecheck.ITypeCheck;

public class RefType extends Type implements ITypeCheck {

	private Type type;

	public RefType(Type type) {
		this.type = type;
	}
/*
	@Override
	public String get() {
		return "(REF " + this.type.getTypeNameValue() + ")";
	}
*/
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(REF_TYPE ");
		builder.append(this.type.printAst(level));
		builder.append(")");
		return builder.toString();
	}

	@Override
	public String getType() {
		return type.getTypeNameValue();
	}
}
