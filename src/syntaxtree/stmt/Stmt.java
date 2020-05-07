package syntaxtree.stmt;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.Node;
import syntaxtree.types.DataType;

public abstract class Stmt extends Node {

    //public abstract void typeCheck(SymbolTable symbolTable) throws SemanticException;

    public abstract DataType getDataType();

}