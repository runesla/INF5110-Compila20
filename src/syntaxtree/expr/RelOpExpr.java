package syntaxtree.expr;

import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import common.utils.BytecodeTypes;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;
import java.util.Arrays;
import static common.utils.StringUtil.*;
import static syntaxtree.types.operators.RelOpr.*;

public class RelOpExpr extends Expr {

	private final Expr leftExpr;
	private final String operator;
	private final Expr rightExpr;

	public RelOpExpr(Expr leftExpr, String operator, Expr rightExpr) {
		this.leftExpr = leftExpr;
		this.operator = operator;
		this.rightExpr = rightExpr;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(REL_OPR_EX ");
		builder.append("\n" + repeat("\t", level + 1) + leftExpr.printAst(level + 1));
		builder.append("\n" + repeat("\t", level + 1) + operator);
		builder.append("\n" + repeat("\t", level + 1) + rightExpr.printAst(level + 1));
		
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		leftExpr.typeCheck(symbolTable);
		rightExpr.typeCheck(symbolTable);

		// Check left- and right-hand side operands
		if(!(leftExpr.getDataType().getType() == Type.INT || leftExpr.getDataType().getType() == Type.FLOAT)
				|| !(rightExpr.getDataType().getType() == Type.INT || rightExpr.getDataType().getType() == Type.FLOAT)) {
			throw new SemanticException("Invalid type in relational expression");
		}

		// Check operator validity
		if(!Arrays.asList(EQ.get(), GT.get(), LT.get(), LTEQUAL.get(), GTEQUAL.get(), NEQUAL.get()).contains(this.operator)) {
			throw new SemanticException("Invalid operator in relational expression");
		}
	}

	@Override
	public DataType getDataType() {
		return new DataType(Type.BOOL);
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		this.leftExpr.generateCode(proc);
		this.rightExpr.generateCode(proc);
		proc.addInstruction(BytecodeTypes.getRelationalOperator(this.operator));
	}
}
