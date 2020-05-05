package syntaxtree.decl;

import error.SyntaxException;
import error.TypeException;
import syntaxtree.Type;
import java.util.HashMap;

public class ParamDecl extends Decl {

	private Type type;

	public ParamDecl(String name, Type type) {
		super(name);
		this.type = type;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(PARAM_DECL ");
		builder.append(this.getName());
		builder.append(this.type.printAst(level));
		builder.append(")");
		return builder.toString();
	}

	@Override
	public void fieldTypeCheck(HashMap<String, String> types, HashMap<String, ProcDecl> procs) throws TypeException {

	}

	@Override
	public String getType() {
		return this.type.getTypeNameValue();
	}
}