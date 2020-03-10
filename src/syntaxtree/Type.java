package syntaxtree;

import static syntaxtree.StringUtil.*;

public class Type extends Node {

	private String name;
	private TypeName typeName;

	// Needed empty constructor in order to call RefType
	public Type() { }

	public Type(String name) {
		this.name = name;
	}

	public Type(TypeName type_name) {
		this.typeName = typeName;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(TYPE ");

		if(this.name == null)
			builder.append(this.typeName.toString());
		else
			builder.append(this.name);

		builder.append(")");
	
		return builder.toString();
	}
}
