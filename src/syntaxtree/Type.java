package syntaxtree;

public class Type extends Node {

	private String name;
	private TypeName t_name;

	// Needed empty constructor in order to call RefType
	public Type() {

	}

	public Type(String name) {
		this.name = name;
	}

	public Type(TypeName t_name) {
		this.t_name = t_name;
	}
}
