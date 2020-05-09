package syntaxtree.stmt;

import bytecode.CodeProcedure;
import common.error.CodeGenException;
import syntaxtree.Node;

public abstract class Stmt extends Node {

    public abstract void generateCode(CodeProcedure proc) throws CodeGenException;
}