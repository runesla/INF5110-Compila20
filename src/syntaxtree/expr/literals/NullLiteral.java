package syntaxtree.expr.literals;

import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.expr.LiteralExpr;
import syntaxtree.types.DataType;

public class NullLiteral extends LiteralExpr {

	public NullLiteral() { }

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(NULL_LITERAL)");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

	}

	@Override
	public DataType getDataType() {
		return null;
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {


	}
}
