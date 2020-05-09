package syntaxtree;

import bytecode.CodeFile;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;

public abstract class Node {

    public abstract String printAst(int level);

    public abstract void typeCheck(SymbolTable symbolTable) throws SemanticException;
}
