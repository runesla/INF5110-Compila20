package common;

import common.error.SyntaxException;
import syntaxtree.DataType;
import syntaxtree.Type;
import syntaxtree.decl.ParamFieldDecl;
import syntaxtree.decl.ProcDecl;
import java.util.ArrayList;

public class STL {

    private static final ArrayList<ProcDecl> STL = new ArrayList<>();

    public STL() throws SyntaxException {

        ProcDecl readint = new ProcDecl("readint", new DataType(Type.INT));
        ProcDecl readfloat = new ProcDecl("readfloat", new DataType(Type.FLOAT));
        ProcDecl readchar = new ProcDecl("readchar", new DataType(Type.INT));             // Returns ASCII value. Return -1 for EOF
        ProcDecl readstring = new ProcDecl("readstring", new DataType(Type.STRING));      // Read string until first whitespace
        ProcDecl readline = new ProcDecl("readline", new DataType(Type.STRING));

        STL.add(readint);
        STL.add(readfloat);
        STL.add(readchar);
        STL.add(readstring);
        STL.add(readline);

        ProcDecl printint = new ProcDecl("printint");
        printint.addParameter(new ParamFieldDecl("i", new DataType(Type.INT)));

        ProcDecl printfloat = new ProcDecl("printfloat");
        printfloat.addParameter(new ParamFieldDecl("f", new DataType(Type.FLOAT)));

        ProcDecl printstr = new ProcDecl("printstr");                           // Write one string
        printstr.addParameter(new ParamFieldDecl("s", new DataType(Type.STRING)));

        ProcDecl printline = new ProcDecl("printline");                         // Write one line, followed by a "newline"
        printstr.addParameter(new ParamFieldDecl("s", new DataType(Type.STRING)));

        STL.add(printint);
        STL.add(printfloat);
        STL.add(printstr);
        STL.add(printline);
    }

    public ArrayList<ProcDecl> getSTL() {
        return STL;
    }
}
