package syntaxtree.expr.literals;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.expr.LiteralExpr;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;

public class BoolLiteral extends LiteralExpr {

	private final Boolean literal;

	public BoolLiteral(Boolean literal) {
		this.literal = literal;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(BOOL_LITERAL ");
		builder.append(this.literal.toString());
		builder.append(")");
	
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

	}

	@Override
	public DataType getDataType() {
		return new DataType(Type.BOOL);
	}
}
