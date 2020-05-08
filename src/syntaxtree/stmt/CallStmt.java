package syntaxtree.stmt;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.Name;
import syntaxtree.expr.Expr;
import syntaxtree.types.DataType;

import java.util.List;
import static common.utils.StringUtil.*;

public class CallStmt extends Stmt {

	private final Name name;
	private final List<Expr> expr;

	public CallStmt(Name name, List<Expr> expr) {
		this.name = name;
		this.expr = expr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(CALL_STMT ");
		builder.append(this.name.getNameValue());
		for(Expr e: expr) {
			builder.append("\n" + repeat("\t", level + 1) + e.printAst(level + 1));
		}
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		// Check if called symbol exists
		if(symbolTable.retrieveType(this.name) == null) {
			throw new SemanticException("No declaration exists of symbol " + this.name.getNameValue());
		}

		for(Expr e: expr) {
			e.typeCheck(symbolTable);
		}
	}

	@Override
	public DataType getDataType() {
		return null;
	}
}
