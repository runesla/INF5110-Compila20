package syntaxtree.expr;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;

public class NewExpr extends Expr {

	private final DataType dataType;
	
	public NewExpr(DataType dataType) {
		this.dataType = dataType;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(NEW ");
		builder.append(this.dataType.printAst(level));
		builder.append(")");

		return builder.toString();
	}


	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {
		if(this.dataType.getType() != Type.UDT) {
			throw new SemanticException("Invalid type for 'new' expression, cannot be primitive or string type");
		}
	}

	@Override
	public DataType getDataType() {
		return this.dataType;
	}
}
