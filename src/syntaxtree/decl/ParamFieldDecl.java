package syntaxtree.decl;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import static common.utils.StringUtil.*;

public class ParamFieldDecl extends Decl {

	private final DataType dataType;

	public ParamFieldDecl(String name, DataType dataType) {
		super(new Name(name));
		this.dataType = dataType;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n" + repeat("\t", level + 1) + this.dataType.printAst(level + 1));
		builder.append(":");
		builder.append(" (NAME ");
		builder.append(this.getName());
		builder.append(")");
		builder.append("\n" + repeat("\t", level) + ")");
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