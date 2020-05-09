package syntaxtree.expr;

import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.stmt.CallStmt;
import syntaxtree.types.DataType;
import static common.utils.StringUtil.*;

public class CallExpr extends Expr {
	
	private final CallStmt callStmt;

	public CallExpr(CallStmt callStmt) {
		this.callStmt = callStmt;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(CALL_EXPR ");
		builder.append("\n" + repeat("\t", level + 1) + callStmt.printAst(level + 1));
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {
		callStmt.typeCheck(symbolTable);
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		callStmt.generateCode(proc);
	}

	@Override
	public DataType getDataType() throws SemanticException {
		return callStmt.getDataType();
	}
}
