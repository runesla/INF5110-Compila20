package syntaxtree;

public class RefType extends Type {

	private Type type;

	public RefType(Type type) {
		this.type = type;
	}

	@Override
	public String printAst(int level) {
		return "(REF_TYPE " + type.printAst(level) + ")";
	}
}
