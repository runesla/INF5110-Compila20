package syntaxtree;

public class ParamFieldDecl extends Decl {

	private Type type;

	public ParamFieldDecl(String name, Type type) {
		super(name);
		this.type = type;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(PARAMFIELD_DECL (NAME " + this.getName() + ") : " + this.type.toString() + ")";
		
		return print;
	}
}
