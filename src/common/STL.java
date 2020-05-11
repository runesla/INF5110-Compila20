package common;

import common.error.SyntaxException;
import syntaxtree.Name;
import syntaxtree.decl.LibProcDecl;
import syntaxtree.decl.ParamDecl;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;
import java.util.ArrayList;

public class STL {

    private static final ArrayList<LibProcDecl> STL = new ArrayList<>();

    public STL() throws SyntaxException {

        LibProcDecl readint = new LibProcDecl(new Name("readint"), new DataType(Type.INT));
        LibProcDecl readfloat = new LibProcDecl(new Name("readfloat"), new DataType(Type.FLOAT));
        LibProcDecl readchar = new LibProcDecl(new Name("readchar"), new DataType(Type.INT));             // Returns ASCII value. Return -1 for EOF
        LibProcDecl readstring = new LibProcDecl(new Name("readstring"), new DataType(Type.STRING));      // Read string until first whitespace
        LibProcDecl readline = new LibProcDecl(new Name("readline"), new DataType(Type.STRING));

        STL.add(readint);
        STL.add(readfloat);
        STL.add(readchar);
        STL.add(readstring);
        STL.add(readline);

        LibProcDecl printint = new LibProcDecl(new Name("printint"), new DataType(Type.VOID));
        printint.addParameter(new ParamDecl(new Name("i"), new DataType(Type.INT)));

        LibProcDecl printfloat = new LibProcDecl(new Name("printfloat"), new DataType(Type.VOID));
        printfloat.addParameter(new ParamDecl(new Name("f"), new DataType(Type.FLOAT)));

        LibProcDecl printstr = new LibProcDecl(new Name("printstr"), new DataType(Type.VOID));                                     // Write one string
        printstr.addParameter(new ParamDecl(new Name("s"), new DataType(Type.STRING)));

        LibProcDecl printline = new LibProcDecl(new Name("printline"), new DataType(Type.VOID));                                   // Write one line, followed by a "newline"
        printstr.addParameter(new ParamDecl(new Name("s"), new DataType(Type.STRING)));

        STL.add(printint);
        STL.add(printfloat);
        STL.add(printstr);
        STL.add(printline);
    }

    public ArrayList<LibProcDecl> getSTL() {
        return STL;
    }

}
