package syntaxtree;

public class Name extends Node {

	private final String nameValue;

	public Name(String nameValue) {
		this.nameValue = nameValue;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(NAME ");
		builder.append(this.nameValue);
		builder.append(")");
		return builder.toString();
	}

	public String getNameValue() {
		return this.nameValue;
	}
}
