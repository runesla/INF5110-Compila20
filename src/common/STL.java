package common;

import common.error.SyntaxException;
import syntaxtree.Name;
import syntaxtree.decl.ParamDecl;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;
import syntaxtree.decl.ProcDecl;
import java.util.ArrayList;

public class STL {

    private static final ArrayList<ProcDecl> STL = new ArrayList<>();

    public STL() throws SyntaxException {

        ProcDecl readint = new ProcDecl(new Name("readint"), new DataType(Type.INT));
        ProcDecl readfloat = new ProcDecl(new Name("readfloat"), new DataType(Type.FLOAT));
        ProcDecl readchar = new ProcDecl(new Name("readchar"), new DataType(Type.INT));             // Returns ASCII value. Return -1 for EOF
        ProcDecl readstring = new ProcDecl(new Name("readstring"), new DataType(Type.STRING));      // Read string until first whitespace
        ProcDecl readline = new ProcDecl(new Name("readline"), new DataType(Type.STRING));

        STL.add(readint);
        STL.add(readfloat);
        STL.add(readchar);
        STL.add(readstring);
        STL.add(readline);

        ProcDecl printint = new ProcDecl(new Name("printint"), new DataType(Type.VOID));
        printint.addParameter(new ParamDecl(new Name("i"), new DataType(Type.INT)));

        ProcDecl printfloat = new ProcDecl(new Name("printfloat"), new DataType(Type.VOID));
        printfloat.addParameter(new ParamDecl(new Name("f"), new DataType(Type.FLOAT)));

        ProcDecl printstr = new ProcDecl(new Name("printstr"), new DataType(Type.VOID));                                     // Write one string
        printstr.addParameter(new ParamDecl(new Name("s"), new DataType(Type.STRING)));

        ProcDecl printline = new ProcDecl(new Name("printline"), new DataType(Type.VOID));                                   // Write one line, followed by a "newline"
        printstr.addParameter(new ParamDecl(new Name("s"), new DataType(Type.STRING)));

        STL.add(printint);
        STL.add(printfloat);
        STL.add(printstr);
        STL.add(printline);
    }

    public ArrayList<ProcDecl> getSTL() {
        return STL;
    }
}
