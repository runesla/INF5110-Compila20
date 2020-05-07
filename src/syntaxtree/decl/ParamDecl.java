package syntaxtree.decl;

import syntaxtree.types.DataType;

public class ParamDecl extends VarDecl {

	public ParamDecl(String name, DataType dataType) {
		super(name, dataType);
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(PARAM_DECL ");
		builder.append(this.getName());
		builder.append(this.getDataType().printAst(level));
		builder.append(")");
		return builder.toString();
	}

}