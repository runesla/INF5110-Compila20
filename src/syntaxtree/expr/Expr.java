package syntaxtree.expr;

import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.Node;
import syntaxtree.decl.ProcDecl;
import syntaxtree.types.DataType;

public abstract class Expr extends Node {

    //public abstract void typeCheck(SymbolTable symbolTable) throws SemanticException;

    public abstract DataType getDataType() throws SemanticException;

    public abstract void generateCode(CodeProcedure proc) throws CodeGenException;
}