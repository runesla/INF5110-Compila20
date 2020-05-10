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
import static syntaxtree.types.operators.LogOpr.*;

public class LogOpExpr extends Expr {

	private final Expr leftExpr;
	private final String operator;
	private final Expr rightExpr;

	public LogOpExpr(Expr leftExpr, String operator, Expr rightExpr) {
		this.leftExpr = leftExpr;
		this.operator = operator;
		this.rightExpr = rightExpr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(LOG_OP_EXPR ");
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
		if(leftExpr.getDataType().getType() != Type.BOOL || rightExpr.getDataType().getType() != Type.BOOL) {
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

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		this.leftExpr.generateCode(proc);
		this.rightExpr.generateCode(proc);
		proc.addInstruction(BytecodeTypes.getLogicalOperator(this.operator));
	}
}
