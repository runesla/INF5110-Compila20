package syntaxtree.decl;

import bytecode.CodeFile;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import common.utils.BytecodeTypes;
import common.utils.TypeChecker;
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

/*		// ATTEMPT #2
		if(!(TypeChecker.isPrimitive(this.dataType.getType()))) {
			if(this.dataType.getType() == Type.UDT) {

				DataType type = symbolTable.retrieveType(this.getName()).getDataType();

				if(this.dataType.equals(type)) {
					throw new SemanticException("Undeclared struct " + this.dataType.getName().getNameValue());
				}
			} else {
				throw new SemanticException("Invalid type " + this.getDataType().getName().getNameValue() +
						" for declaration " + this.getName().getNameValue());
			}
		}

 */
		/* // ATTEMPT #1
		if(this.dataType == null) {
			this.expr.typeCheck(symbolTable);
			this.dataType = symbolTable.retrieveVariable(this.getName()).getDataType();

		} else {
			if(!(TypeChecker.isPrimitive(this.dataType.getType()))) {
				if (symbolTable.retrieveType(this.dataType.getName()) == null) {
					throw new SemanticException("Undeclared struct or invalid type " + this.dataType.getName().getNameValue());
				}
			}
		}

		 */
	}

	@Override
	public void generateCode(CodeFile codeFile) throws CodeGenException {

		String var = this.getName().getNameValue();

		codeFile.addVariable(var);
		codeFile.updateVariable(var, BytecodeTypes.getCodeType(this.dataType));
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
