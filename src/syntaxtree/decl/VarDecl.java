package syntaxtree.decl;

import bytecode.CodeFile;
import bytecode.type.RefType;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import common.utils.BytecodeTypes;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.expr.Expr;
import syntaxtree.types.Type;

import static common.utils.StringUtil.*;

public class VarDecl extends Decl {
	
	private DataType dataType;
	private Expr expr;

	public VarDecl(
			Name name,
			DataType dataType) {
		super(name);
		this.dataType = dataType;
	}

	public VarDecl(
			Name name,
			Expr expr) {
		super(name);
		this.expr = expr;
	}

	public VarDecl(
			Name name,
			DataType dataType,
			Expr expr) {
		super(name);
		this.dataType = dataType;
		this.expr = expr;
	}

	@Override
	public DataType getDataType() {
		return this.dataType;
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		if(this.dataType == null) {
			VarDecl var = symbolTable.retrieveVariable(this.getName());

			if(var == null) {
				throw new SemanticException("Undeclared type");
			}

			this.dataType = var.getDataType();
		}

		if(this.expr != null) {
			this.expr.typeCheck(symbolTable);
		}
	}

	@Override
	public void generateCode(CodeFile codeFile) throws CodeGenException {

		String var = this.getName().getNameValue();

		codeFile.addVariable(var);

		if(this.getDataType().getType() == Type.UDT) {
			codeFile.updateVariable(var, new RefType(codeFile.structNumber(this.getDataType().getName().getNameValue())));
		} else {
			codeFile.updateVariable(var, BytecodeTypes.getCodeType(this.dataType));
		}
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(VAR_DECL ");
		builder.append("\n" + repeat("\t", level + 1) + this.dataType.printAst(level));
		builder.append(" : ");
		builder.append(" (NAME ");
		builder.append(this.getName().getNameValue());
		builder.append(")");
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}
}
