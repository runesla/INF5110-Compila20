package syntaxtree.decl;

import bytecode.CodeFile;
import common.error.CodeGenException;
import syntaxtree.Name;
import syntaxtree.types.DataType;

public class ParamDecl extends VarDecl {

	public ParamDecl(Name name, DataType dataType) {
		super(name, dataType);
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(PARAM_DECL ");
		builder.append(this.getName().getNameValue());
		builder.append(this.getDataType().printAst(level));
		builder.append(")");
		return builder.toString();
	}

	@Override
	public void generateCode(CodeFile codeFile) throws CodeGenException {
		// TODO: probably not needed

	}
}