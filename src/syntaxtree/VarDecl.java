package syntaxtree;

public class VarDecl extends Decl {
	
	private Type type;

	public VarDecl(String name, Type type) {
		this.name = name;
		this.type = type;
	}
}
