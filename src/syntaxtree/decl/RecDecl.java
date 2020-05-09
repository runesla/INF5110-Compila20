package syntaxtree.decl;

import bytecode.CodeFile;
import bytecode.CodeStruct;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import common.utils.BytecodeTypes;
import syntaxtree.Name;
import syntaxtree.types.DataType;
import java.util.*;
import static common.utils.StringUtil.*;

public class RecDecl extends Decl {

	private List<ParamDecl> params;

	// Default constructor
	public RecDecl(Name name) {
		super(name);
		//this.params = new LinkedList<>();
	}	

	// Given params
	public RecDecl(Name name, List<ParamDecl> params) {
		super(name);
		this.params = params;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(STRUCT ");
		builder.append("(NAME ");
		builder.append(this.getName().getNameValue());
		builder.append(")");
		if(params != null) {
			for(ParamDecl p: params) {
				builder.append("\n" + repeat("\t", level+1) + "(VAR_DECL " + p.printAst(level + 1));
			}
		}
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public DataType getDataType() {
		return new DataType(this.getName());
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		// Create symbol table for this block
		//SymbolTable recSymbolTable = symbolTable.createChildTable();

		// Check params
		for(ParamDecl paramDecl: params) {
			symbolTable.insertVariable(paramDecl);
			paramDecl.typeCheck(symbolTable);
		}
	}

	@Override
	public void generateCode(CodeFile codeFile) throws CodeGenException {

		String recName = this.getName().getNameValue();

		codeFile.addStruct(recName);
		CodeStruct rec = new CodeStruct(recName);

		// Generate code for params and add to struct
		for(ParamDecl paramDecl: params) {
			paramDecl.generateCode(codeFile);
			rec.addVariable(paramDecl.getName().getNameValue(), BytecodeTypes.getCodeType(paramDecl.getDataType()));
		}

		codeFile.updateStruct(rec);
	}
}
