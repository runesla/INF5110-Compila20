package syntaxtree.decl;

import error.SyntaxException;
import syntaxtree.Type;
import java.util.HashMap;
import static syntaxtree.StringUtil.*;

public class ParamFieldDecl extends Decl {

	private final Type type;

	public ParamFieldDecl(String name, Type type) {
		super(name);
		this.type = type;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n" + repeat("\t", level + 1) + this.type.printAst(level + 1));
		builder.append(":");
		builder.append(" (NAME ");
		builder.append(this.getName());
		builder.append(")");
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public String getType() {
		return this.type.getTypeNameValue();
	}

	@Override
	public void fieldTypeCheck(HashMap<String, String> types, HashMap<String, ProcDecl> procs) throws SyntaxException {

	}
}