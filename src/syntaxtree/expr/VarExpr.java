package syntaxtree.expr;

import bytecode.CodeProcedure;
import bytecode.instructions.*;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.Name;
import syntaxtree.decl.ParamDecl;
import syntaxtree.decl.RecDecl;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;

public class VarExpr extends Expr {

	private final Name name;
	private Expr expr;
	private DataType dataType;

	public VarExpr(Name name) {
		this.name = name;
	}

	public VarExpr(
			Name name,
			DataType dataType) {
		this.name = name;
		this.dataType = dataType;
	}

	public VarExpr(
			Name name,
			Expr expr) {
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

	public Name getName() {
		return this.name;
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

		// Assign datatype based on registered variable type
		// This is if the expression is not a DOT operator
		if(this.expr == null) {
			this.dataType = symbolTable.retrieveVariable(this.name).getDataType();

			return;
		}

		// Else if expression is a DOT operator, access the appropriate declaration
		this.expr.typeCheck(symbolTable);

		if(this.expr.getDataType().getType() == Type.UDT) {
			RecDecl rec = symbolTable.retrieveType(this.expr.getDataType());

			for(ParamDecl par: rec.getParams()) {
				if(this.name.equals(par.getName())) {
					this.dataType = par.getDataType();

					return;
				}
			}
		} else {
			throw new SemanticException("Type cannot be primitive");
		}
	}

	@Override
	public DataType getDataType() throws SemanticException {
		if(this.dataType == null) {
			throw new SemanticException("Undetermined return type in expression " + this.name.getNameValue());
		}

		return this.dataType;
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		generateLoadCode(proc);
	}

	public void generateLoadCode(CodeProcedure proc) throws CodeGenException {

		Instruction instr = null;

		// Check if expression is a dot operator
		if(this.expr == null) {

			if(proc.variableNumber(this.name.getNameValue()) == -1) {
				instr = new LOADGLOBAL(proc.globalVariableNumber(this.name.getNameValue()));
			} else {
				instr = new LOADLOCAL(proc.variableNumber(this.name.getNameValue()));
			}

		} else {
			this.expr.generateCode(proc);

			try {
				instr = new GETFIELD(
						proc.fieldNumber(
								this.expr.getDataType().getName().getNameValue(),
								this.name.getNameValue()
						),
						proc.structNumber(this.expr.getDataType().getName().getNameValue())
				);
			} catch (SemanticException e) {
				e.printStackTrace();
			}
		}

		proc.addInstruction(instr);
	}

	public void generateStoreCode(CodeProcedure proc) throws CodeGenException {
		Instruction instr = null;

		// Check if expression is a dot operator
		if(this.expr == null) {

			if(proc.variableNumber(this.name.getNameValue()) == -1) {
				instr = new STOREGLOBAL(proc.globalVariableNumber(this.name.getNameValue()));
			} else {
				instr = new STORELOCAL(proc.variableNumber(this.name.getNameValue()));
			}

		} else {
			this.expr.generateCode(proc);

			try {
				instr = new PUTFIELD(
						proc.fieldNumber(
								this.expr.getDataType().getName().getNameValue(),
								this.name.getNameValue()
						),
						proc.structNumber(this.expr.getDataType().getName().getNameValue())
				);
			} catch (SemanticException e) {
				e.printStackTrace();
			}

		}
		proc.addInstruction(instr);
	}
}
