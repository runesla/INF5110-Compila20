package syntaxtree.expr.literals;

import bytecode.CodeProcedure;
import bytecode.instructions.PUSHINT;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.expr.LiteralExpr;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;

public class IntLiteral extends LiteralExpr {

	private final Integer literal;

	public IntLiteral(Integer literal) {
		this.literal = literal;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(INT_LITERAL ");
		builder.append(this.literal.toString());
		builder.append(")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

	}

	@Override
	public DataType getDataType() {
		return new DataType(Type.INT);
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		proc.addInstruction(new PUSHINT(literal));
	}
}
