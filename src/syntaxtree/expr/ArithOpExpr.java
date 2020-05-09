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

		// Check types of left- and right-hand side operands
		if(e1.getDataType().getType() != Type.INT || e1.getDataType().getType() != Type.FLOAT
				|| e2.getDataType().getType() != Type.INT || e2.getDataType().getType() != Type.FLOAT) {
			throw new SemanticException("Invalid type in arithmetic expression");
		}

		// Check operator validity
		if(!Arrays.asList(ADDOP.get(), SUBOP.get(), MULOP.get(), DIVOP.get(), EXP.get()).contains(this.operator)) {
			throw new SemanticException("Invalid operator in arithmetic expression");
		}
	}

	@Override
	public DataType getDataType() throws SemanticException {
		if(e1.getDataType().getType() == Type.FLOAT || e2.getDataType().getType() == Type.FLOAT) {
			return new DataType(Type.FLOAT);
		}
		return new DataType(Type.INT);
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		this.e1.generateCode(proc);
		this.e2.generateCode(proc);
		proc.addInstruction(BytecodeTypes.getArithmeticOperator(this.operator));
	}
}
