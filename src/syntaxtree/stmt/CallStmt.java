package syntaxtree.stmt;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.CALL;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.Name;
import syntaxtree.decl.ProcDecl;
import syntaxtree.expr.Expr;
import syntaxtree.types.DataType;
import java.util.List;
import static common.utils.StringUtil.*;

public class CallStmt extends Stmt {

	private final Name name;
	private final List<Expr> expr;
	private DataType dataType;

	public CallStmt(Name name, List<Expr> expr) {
		//this.name = new Name(name);
		this.name = name;
		this.expr = expr;
	}

	public DataType getDataType() throws SemanticException {
		if(this.dataType == null) {
			throw new SemanticException("No datatype defined for call statement");
		}
		return this.dataType;
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
		ProcDecl proc = symbolTable.retrieveProcedure(this.name);

		if(proc == null) {
			throw new SemanticException("No declaration exists of symbol " + this.name.getNameValue());
		}

		this.dataType = proc.getDataType();

		for(Expr e: expr) {
			e.typeCheck(symbolTable);
		}
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {

		for(Expr exp: expr) {
			exp.generateCode(proc);
		}

		proc.addInstruction(new CALL(proc.procedureNumber(proc.getName())));
	}
}
