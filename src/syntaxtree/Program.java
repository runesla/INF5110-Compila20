package syntaxtree;

import java.util.List;
import bytecode.*;

public class Program extends Node {

    List<Decl> decls;
    String name;

    public Program(String name, List<Decl> decls) {
        this.decls = decls;
        this.name = name;
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
