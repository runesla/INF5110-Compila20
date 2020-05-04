package syntaxtree;

import static syntaxtree.StringUtil.*;

public class Type extends Node {

	private TypeName typeName;
	private String name;

	// Need empty constructor in order to call RefType
	public Type() { }

	public Type(String name) {
		this.name = name;
	}

	public Type(TypeName typeName) {	//type_name
		this.typeName = typeName;
	}

	public String getTypeNameValue() {
		if(typeName != null) {
			return typeName.getTypeNameValue();
		}

		return name;
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
