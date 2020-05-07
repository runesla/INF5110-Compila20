package common;

import common.error.SemanticException;
import common.error.SyntaxException;
import syntaxtree.Node;
import syntaxtree.decl.Decl;
import bytecode.*;
import syntaxtree.decl.ProcDecl;
import java.util.List;

public class Program extends Node {

    private final List<Decl> decls;
    private final String name;
    private final STL stdLib;

    public Program(String name, List<Decl> decls) throws SyntaxException {
        this.decls = decls;
        this.name = name;
        this.stdLib = new STL();
    }

    @Override
    public String printAst(int level){
        StringBuilder sb = new StringBuilder();
        sb.append("(PROGRAM ");
        sb.append("(NAME ");
        sb.append(this.name);
        sb.append(")\n");
        for (Decl decl : decls) {
            sb.append("\t" + decl.printAst(level + 1));
            sb.append("\n");
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public void typeCheck(SymbolTable symbolTable) throws SemanticException {

        boolean hasMain = false;

        for (Decl decl: decls) {
            symbolTable.insert(decl);
            decl.typeCheck(symbolTable);

            if(decl instanceof ProcDecl && decl.getName().getNameValue().equals("main")) {
                hasMain = true;
            }
        }

        if(!hasMain) {
            throw new SemanticException("No main procedure found");
        }
    }

    public void generateCode(CodeFile codeFile) {

    }
}
