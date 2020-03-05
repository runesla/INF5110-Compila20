package syntaxtree;

public class Type extends Node {

	private String name;

	// Needed empty constructor in order to call RefType
	public Type() {

	}

	public Type(String name) {
		this.name = name;
	}

}
