package syntaxtree.types;

import syntaxtree.Name;
import syntaxtree.Node;

public class DataType extends Node {

	private Name name;
	private Type type;

	// Need empty constructor in order to call RefType
	public DataType() { }

	public DataType(Name name) {
		this.name = name;
	}

	public DataType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return this.type;
	}

	public Name getName() {
		return this.name;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();

		if(this.name == null) {
			builder.append("(TYPE ");
		}
		else {
			builder.append("(NAME ");
		}

		builder.append(")");
		return builder.toString();
	}

	/*
	@Override
	public String printAst(int level) { // TODO: needs fixing, either Type or Name
		StringBuilder builder = new StringBuilder();
		builder.append("(TYPE ");

		if(this.name == null)
			builder.append(this.name.getNameValue());	//toString()
		else
			builder.append(this.name);

		builder.append(")");
	
		return builder.toString();
	}

	 */
}
