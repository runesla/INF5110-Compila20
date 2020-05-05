package syntaxtree.decl;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.DataType;
import syntaxtree.Name;

public class ParamDecl extends Decl {

	private final DataType dataType;

	public ParamDecl(String name, DataType dataType) {
		super(new Name(name));
		this.dataType = dataType;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(PARAM_DECL ");
		builder.append(this.getName());
		builder.append(this.dataType.printAst(level));
		builder.append(")");
		return builder.toString();
	}

	@Override
	public DataType getDataType() {
		return this.dataType;
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

	}
}