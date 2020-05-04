package syntaxtree;

import java.util.*;
import syntaxtree.ProcDecl;
import syntaxtree.ParamDecl;
import bytecode.*;

public class Program extends Node {

    List<Decl> decls;
    String name;
    HashMap<String, ProcDecl> procs;

    public Program(String name, List<Decl> decls) {
        this.decls = decls;
        this.name = name;
        this.procs = new HashMap<>();
        loadSTL(procs);
    }

    // Standard library
    private void loadSTL(HashMap<String, ProcDecl> procs) {
        ProcDecl readint = new ProcDecl("readint", new Type("int"));
        ProcDecl readfloat = new ProcDecl("readfloat", new Type("float"));
        ProcDecl readchar = new ProcDecl("readchar", new Type("int"));                                                              // Returns ASCII value. Return -1 for EOF
        ProcDecl readstring = new ProcDecl("readstring", new Type("string"));                                                       // Read string until first whitespace
        ProcDecl readline = new ProcDecl("readline", new Type("string"));                                                           // Read one line
        ProcDecl printint = new ProcDecl("printint", Collections.singletonList(new ParamFieldDecl("i", new Type("int"))));
        ProcDecl printfloat = new ProcDecl("printfloat", Collections.singletonList(new ParamFieldDecl("f", new Type("float"))));
        ProcDecl printstr = new ProcDecl("printstr", Collections.singletonList(new ParamFieldDecl("s", new Type("string"))));       // Write one string
        ProcDecl printline = new ProcDecl("printline", Collections.singletonList(new ParamFieldDecl("s", new Type("string"))));     // Write one line, followed by a "newline"

        procs.put("readint", readint);
        procs.put("readfloat", readfloat);
        procs.put("readchar", readchar);
        procs.put("readstring", readstring);
        procs.put("readline", readline);
        procs.put("printint", printint);
        procs.put("printfloat", printfloat);
        procs.put("printstr", printstr);
        procs.put("printline", printline);
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

    public boolean typeCheck() {
        return true;
    }

    public void generateCode(CodeFile codeFile) {

    }
}
