package common;

import syntaxtree.decl.ParamFieldDecl;
import syntaxtree.decl.ProcDecl;
import java.util.ArrayList;

public class STL {

    private static final ArrayList<ProcDecl> STL = new ArrayList<>();

    public STL() {

        ProcDecl readint = new ProcDecl("readint", BuiltInTypes.INT);
        ProcDecl readfloat = new ProcDecl("readfloat", BuiltInTypes.FLOAT);
        ProcDecl readchar = new ProcDecl("readchar", BuiltInTypes.STRING);          // Returns ASCII value. Return -1 for EOF
        ProcDecl readstring = new ProcDecl("readstring", BuiltInTypes.STRING);      // Read string until first whitespace
        ProcDecl readline = new ProcDecl("readline", BuiltInTypes.STRING);

        STL.add(readint);
        STL.add(readfloat);
        STL.add(readchar);
        STL.add(readstring);
        STL.add(readline);

        ProcDecl printint = new ProcDecl("printint");
        printint.addParameter(new ParamFieldDecl("i", BuiltInTypes.INT));

        ProcDecl printfloat = new ProcDecl("printfloat");
        printfloat.addParameter(new ParamFieldDecl("f", BuiltInTypes.FLOAT));

        ProcDecl printstr = new ProcDecl("printstr");                           // Write one string
        printstr.addParameter(new ParamFieldDecl("s", BuiltInTypes.STRING));

        ProcDecl printline = new ProcDecl("printline");                         // Write one line, followed by a "newline"
        printstr.addParameter(new ParamFieldDecl("s", BuiltInTypes.STRING));

        STL.add(printint);
        STL.add(printfloat);
        STL.add(printstr);
        STL.add(printline);
    }

    public ArrayList<ProcDecl> getSTL() {
        return STL;
    }
}
