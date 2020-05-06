package common;

import common.error.SyntaxException;
import syntaxtree.Node;
import syntaxtree.decl.Decl;
import bytecode.*;
import java.util.List;

public class Program extends Node {

    private final List<Decl> decls;
    private final String name;
    private final STL stdLib;
    //HashMap<String, ProcDecl> procs;
    //HashMap<String, String> types;

    public Program(String name, List<Decl> decls) throws SyntaxException {
        this.decls = decls;
        this.name = name;
        this.stdLib = new STL();
        //this.procs = new HashMap<>();
       // this.types = new HashMap<>();
        //loadSTL();
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

    public boolean checkSemantics(SymbolTable symbolTable) {

        try {
            for (Decl decl: decls) {
                decl.typeCheck(symbolTable);
                //decl.fieldTypeCheck(types, procs);
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
/*
        if(!procs.containsKey("main")) {
            throw new SyntaxException("No main procedure found");
        }
*/
        return true;
    }

    public void generateCode(CodeFile codeFile) {

    }
}
