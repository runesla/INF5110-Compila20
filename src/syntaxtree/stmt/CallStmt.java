package syntaxtree.stmt;

import bytecode.CodeProcedure;
import bytecode.instructions.CALL;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import common.utils.TypeChecker;
import syntaxtree.Name;
import syntaxtree.decl.ParamDecl;
import syntaxtree.decl.ProcDecl;
import syntaxtree.expr.Expr;
import syntaxtree.types.DataType;
import java.util.ArrayList;
import java.util.List;
import static common.utils.StringUtil.*;

public class CallStmt extends Stmt {

	private final Name name;
	private final List<Expr> expr;
	private DataType dataType;

	public CallStmt(Name name, List<Expr> expr) {
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

		List<ParamDecl> args = new ArrayList<>();

		for (Expr e : this.expr) {
			e.typeCheck(symbolTable);

			args.add(new ParamDecl(e.getDataType()));
		}

		// Check argument matching against procedure parameters
		if(args.size() != proc.getParams().size()) {
			throw new SemanticException("Number of arguments does not match procedure parameters");
		} else {
			ParamDecl arg = null;
			ParamDecl par = null;

			for(int i = 0; i < args.size(); i++) {
				arg = args.get(i);
				par = proc.getParams().get(i);

				if(!(TypeChecker.isCompatibleType(arg.getDataType(), par.getDataType()))) {
					throw new SemanticException("Argument " + arg.getDataType().getType().getName().getNameValue()
							+ " does not match procedure parameter " + par.getDataType().getType().getName().getNameValue());
				}
			}
		}
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		for(Expr exp: this.expr) {
			exp.generateCode(proc);
		}

		proc.addInstruction(new CALL(proc.procedureNumber(name.getNameValue())));
	}
}
