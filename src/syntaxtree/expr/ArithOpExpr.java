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
import static syntaxtree.types.operators.ArithOpr.*;

public class ArithOpExpr extends Expr {

	private final Expr leftExor;
	private final String operator;
	private final Expr rightExpr;

	public ArithOpExpr(Expr leftExor, String operator, Expr rightExpr) {
		this.leftExor = leftExor;
		this.operator = operator;
		this.rightExpr = rightExpr;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(ARITH_OP_EXPR ");
		builder.append("\n" + repeat("\t", level + 1) + leftExor.printAst(level));
		builder.append("\n" + repeat("\t", level + 1) + operator);
		builder.append("\n" + repeat("\t", level + 1) + rightExpr.printAst(level));
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		leftExor.typeCheck(symbolTable);
		rightExpr.typeCheck(symbolTable);

		// Check types of left- and right-hand side operands
		if(!(leftExor.getDataType().getType() == Type.INT || leftExor.getDataType().getType() == Type.FLOAT)
				|| !(rightExpr.getDataType().getType() == Type.INT || rightExpr.getDataType().getType() == Type.FLOAT)) {
			throw new SemanticException("Invalid type in arithmetic expression");
		}

		// Check operator validity
		if(!Arrays.asList(ADDOP.get(), SUBOP.get(), MULOP.get(), DIVOP.get(), EXP.get()).contains(this.operator)) {
			throw new SemanticException("Invalid operator in arithmetic expression");
		}
	}

	@Override
	public DataType getDataType() throws SemanticException {
		if(leftExor.getDataType().getType() == Type.FLOAT || rightExpr.getDataType().getType() == Type.FLOAT) {
			return new DataType(Type.FLOAT);
		}
		return new DataType(Type.INT);
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		this.leftExor.generateCode(proc);
		this.rightExpr.generateCode(proc);
		proc.addInstruction(BytecodeTypes.getArithmeticOperator(this.operator));
	}
}
