package syntaxtree;

public class VarDecl extends Decl {
	
	private Type type;

	public VarDecl(String name, Type type) {
		super(name);
		this.type = type;
	}
}
