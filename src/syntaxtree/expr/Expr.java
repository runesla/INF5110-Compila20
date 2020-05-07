package syntaxtree.expr;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.Node;
import syntaxtree.types.DataType;

public abstract class Expr extends Node {

    //public abstract void typeCheck(SymbolTable symbolTable) throws SemanticException;

    public abstract DataType getDataType() throws SemanticException;
}