package syntaxtree.expr;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;
import java.util.Arrays;
import static common.utils.StringUtil.*;
import static syntaxtree.types.operators.LogOpr.*;

public class LogOpExpr extends Expr {

	private final Expr e1;
	private final String operator;
	private final Expr e2;

	public LogOpExpr(Expr e1, String operator, Expr e2) {
		this.e1 = e1;
		this.operator = operator;
		this.e2 = e2;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(LOG_OP_EXPR ");
		builder.append("\n" + repeat("\t", level + 1) + e1.printAst(level + 1));
		builder.append("\n" + repeat("\t", level + 1) + operator);
		builder.append("\n" + repeat("\t", level + 1) + e2.printAst(level + 1));

		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		e1.typeCheck(symbolTable);
		e2.typeCheck(symbolTable);

		// Check left- and right-hand side operands
		if(e1.getDataType().getType() != Type.BOOL || e2.getDataType().getType() != Type.BOOL) {
			throw new SemanticException("Invalid type in logical expression");
		}

		// Check operator validity
		if(!Arrays.asList(LOG_OR.get(), LOG_AND.get()).contains(this.operator)) {
			throw new SemanticException("Invalid operator in logical expression");
		}
	}

	@Override
	public DataType getDataType() {
		return new DataType(Type.BOOL);
	}
}
