package syntaxtree.expr;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;

public class NotExpr extends Expr {

	private final Expr expr;

	public NotExpr(Expr expr) {
		this.expr = expr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(NOT_EXPR ");
		builder.append(expr.printAst(level + 1));
		builder.append(")");

		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {
		this.expr.typeCheck(symbolTable);
	}

	@Override
	public DataType getDataType() throws SemanticException {
		return new DataType(Type.BOOL);
	}
}
