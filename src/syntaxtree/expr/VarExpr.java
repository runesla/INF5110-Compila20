package syntaxtree.expr;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.Name;
import syntaxtree.decl.RecDecl;
import syntaxtree.decl.VarDecl;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;

public class VarExpr extends Expr {

	private final Name name;
	private Expr expr;
	private DataType dataType;

	public VarExpr(Name name) {
		//this.name = new Name(name);
		this.name = name;
	}

	public VarExpr(
			Name name,
			DataType dataType) {
		//this.name = new Name(name);;
		this.name = name;
		this.dataType = dataType;
	}

	public VarExpr(
			Name name,
			Expr expr) {
		//this.name = new Name(name);;
		this.name = name;
		this.expr = expr;
	}

	public VarExpr(
			String name,
			DataType dataType,
			Expr expr) {
		this.name = new Name(name);;
		this.dataType = dataType;
		this.expr = expr;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		if(this.expr != null) {
			builder.append(this.expr.printAst(level + 1));
			builder.append(" . ");
		}
		builder.append("(NAME ");
		builder.append(this.name.getNameValue());
		builder.append(")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		// Assign datatype based on registered type
		if(this.dataType == null) {
			this.dataType = symbolTable.retrieveVariable(this.name).getDataType();
		}

		// Check valid type
		if(this.expr != null) {
			this.expr.typeCheck(symbolTable);

			if(this.expr.getDataType().getType() != this.dataType.getType()) {
				throw new SemanticException("Type mismatch between variable and expression");
			}
		}
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {

	}

	@Override
	public DataType getDataType() throws SemanticException {
		if(this.dataType == null) {
			throw new SemanticException("Undetermined return type in expression " + this.name.getNameValue());
		}

		return this.dataType;
	}
}
