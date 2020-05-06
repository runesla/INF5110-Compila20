package syntaxtree.expr;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;

import static common.utils.StringUtil.*;

public class ArithOpExpr extends Expr {

	private final Expr e1;
	private final String operator;
	private final Expr e2;

	public ArithOpExpr(Expr e1, String operator, Expr e2) {
		this.e1 = e1;
		this.operator = operator;
		this.e2 = e2;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(ARITH_OP_EXPR ");
		builder.append("\n" + repeat("\t", level + 1) + e1.printAst(level));
		builder.append("\n" + repeat("\t", level + 1) + operator);
		builder.append("\n" + repeat("\t", level + 1) + e2.printAst(level));
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		e1.typeCheck(symbolTable);
		e2.typeCheck(symbolTable);

		if(e1.getDataType().getType() != Type.INT || e1.getDataType().getType() != Type.FLOAT
				|| e2.getDataType().getType() != Type.INT || e2.getDataType().getType() != Type.FLOAT) {
			throw new SemanticException("Invalid type in arithmetic expression");
		}
	}

	@Override
	public DataType getDataType() {
		if(e1.getDataType().getType() == Type.FLOAT || e2.getDataType().getType() == Type.FLOAT) {
			return new DataType(Type.FLOAT);
		}
		return new DataType(Type.INT);
	}
}
