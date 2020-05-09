package syntaxtree.expr.literals;

import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.expr.LiteralExpr;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;

public class StringLiteral extends LiteralExpr {

	private final String literal;

	public StringLiteral(String literal) {
		this.literal = literal;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(STRING_LITERAL ");
		builder.append(this.literal);
		builder.append(")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

	}

	@Override
	public DataType getDataType() {
		return new DataType(Type.STRING);
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {

	}
}
