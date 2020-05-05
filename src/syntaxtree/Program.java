package syntaxtree;

import error.*;
import syntaxtree.decl.Decl;
import syntaxtree.decl.ParamFieldDecl;
import syntaxtree.decl.ProcDecl;
import bytecode.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Program extends Node {

    List<Decl> decls;
    String name;
    HashMap<String, ProcDecl> procs;
    HashMap<String, String> types;

    public Program(String name, List<Decl> decls) {
        this.decls = decls;
        this.name = name;
        this.procs = new HashMap<>();
        this.types = new HashMap<>();
        loadSTL(procs, types);
    }

    // Standard library
    private void loadSTL(HashMap<String, ProcDecl> procs, HashMap<String, String> types) {

        Type primitiveInteger = new Type("int");
        Type primitiveFloat = new Type("float");
        Type primitiveString = new Type("string");
        Type primitiveBool = new Type("bool");

        types.put("int", primitiveInteger.getTypeNameValue());
        types.put("float", primitiveFloat.getTypeNameValue());
        types.put("string", primitiveString.getTypeNameValue());
        types.put("bool", primitiveBool.getTypeNameValue());

        ProcDecl readint = new ProcDecl("readint", primitiveInteger);
        ProcDecl readfloat = new ProcDecl("readfloat", primitiveFloat);
        ProcDecl readchar = new ProcDecl("readchar", primitiveInteger);                                                          // Returns ASCII value. Return -1 for EOF
        ProcDecl readstring = new ProcDecl("readstring", primitiveString);                                                       // Read string until first whitespace
        ProcDecl readline = new ProcDecl("readline", primitiveString);                                                           // Read one line
        ProcDecl printint = new ProcDecl("printint", Collections.singletonList(new ParamFieldDecl("i", primitiveInteger)));
        ProcDecl printfloat = new ProcDecl("printfloat", Collections.singletonList(new ParamFieldDecl("f", primitiveFloat)));
        ProcDecl printstr = new ProcDecl("printstr", Collections.singletonList(new ParamFieldDecl("s", primitiveString)));       // Write one string
        ProcDecl printline = new ProcDecl("printline", Collections.singletonList(new ParamFieldDecl("s", primitiveString)));     // Write one line, followed by a "newline"

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

    public boolean typeCheck() throws SyntaxException {

        boolean typeCheckOk = false;

        for(Decl d : decls) {
            d.fieldTypeCheck(types, procs);
        }

        if(!procs.containsKey("main")) {
            throw new SyntaxException("No main procedure found");
        }

        typeCheckOk = true;

        return typeCheckOk;
    }

    public void generateCode(CodeFile codeFile) {

    }
}
