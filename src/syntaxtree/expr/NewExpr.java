package syntaxtree.expr;

import bytecode.CodeProcedure;
import bytecode.instructions.NEW;
import common.SymbolTable;
import common.error.CodeGenException;
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
			throw new SemanticException("Invalid type '" + this.dataType.getName().getNameValue() +
					"' for 'new' expression, cannot be primitive or string type");
		}
	}

	@Override
	public DataType getDataType() {
		return this.dataType;
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		proc.addInstruction(new NEW(proc.structNumber(dataType.getName().getNameValue())));
	}
}
