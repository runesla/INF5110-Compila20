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

	@Override
	public String printAst(int level) {
		String print = "(TYPE " + ((this.name == null) ? this.t_name.toString() : this.name.toString()) + ")";
		return print;
	}
}
