package syntaxtree;

public class ParamDecl extends Decl {

	private Type type;

	public ParamDecl(String name, Type type) {
		super(name);
		this.type = type;
	}
	
	@Override
	public String printAst(int level) {
		String print = "(PARAM_DECL " + this.getName() + ":" + this.type.toString() + ")";
		return print;
	}
}
