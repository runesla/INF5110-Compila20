package syntaxtree.expr;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;
import java.util.Arrays;

import static common.utils.StringUtil.*;
import static syntaxtree.types.operators.RelOpr.*;

public class RelOpExpr extends Expr {

	private final Expr e1;
	private final String operator;
	private final Expr e2;

	public RelOpExpr(Expr e1, String operator, Expr e2) {
		this.e1 = e1;
		this.operator = operator;
		this.e2 = e2;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(REL_OPR_EX ");
		builder.append("\n" + repeat("\t", level + 1) + e1.printAst(level + 1));
		builder.append("\n" + repeat("\t", level + 1) + operator);
		builder.append("\n" + repeat("\t", level + 1) + e2.printAst(level + 1));
		
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		e1.typeCheck(symbolTable);
		e2.typeCheck(symbolTable);

		if(e1.getDataType().getType() != Type.INT || e1.getDataType().getType() != Type.FLOAT
				|| e2.getDataType().getType() != Type.INT || e2.getDataType().getType() != Type.FLOAT) {
			throw new SemanticException("Invalid type in relational expression");
		}
		if(!Arrays.asList(EQ.get(), GT.get(), LT.get(), LTEQUAL.get(), GTEQUAL.get(), NEQUAL.get()).contains(this.operator)) {
			throw new SemanticException("Invalid operator in relational expression");
		}


	}

	@Override
	public DataType getDataType() {
		return new DataType(Type.BOOL);
	}
}
