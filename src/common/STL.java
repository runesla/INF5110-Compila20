package common;

import common.error.SyntaxException;
import syntaxtree.Name;
import syntaxtree.decl.LibProcDecl;
import syntaxtree.decl.ParamDecl;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class STL {

    private static final ArrayList<LibProcDecl> STL = new ArrayList<>();

    public STL() throws SyntaxException {

        LibProcDecl readint = new LibProcDecl(
                new Name("readint"),
                new DataType(Type.INT),
                Arrays.asList(new ParamDecl(new Name("i"), new DataType(Type.INT)))
        );

        LibProcDecl readfloat = new LibProcDecl(
                new Name("readfloat"),
                new DataType(Type.FLOAT),
                Arrays.asList(new ParamDecl(new Name("f"), new DataType(Type.FLOAT)))
        );

        LibProcDecl readchar = new LibProcDecl(                         // Returns ASCII value. Return -1 for EOF
                new Name("readchar"),
                new DataType(Type.INT),
                Arrays.asList(new ParamDecl(new Name("c"), new DataType(Type.INT)))
        );

        LibProcDecl readstring = new LibProcDecl(                       // Read string until first whitespace
                new Name("readstring"),
                new DataType(Type.STRING),
                Arrays.asList(new ParamDecl(new Name("s"), new DataType(Type.STRING)))
        );

        LibProcDecl readline = new LibProcDecl(
                new Name("readline"),
                new DataType(Type.STRING),
                Arrays.asList(new ParamDecl(new Name("l"), new DataType(Type.STRING)))
        );

        STL.add(readint);
        STL.add(readfloat);
        STL.add(readchar);
        STL.add(readstring);
        STL.add(readline);

        LibProcDecl printint = new LibProcDecl(
                new Name("printint"),
                new DataType(Type.VOID),
                Arrays.asList(new ParamDecl(new Name("i"), new DataType(Type.INT)))
        );
        //printint.addParameter(new ParamDecl(new Name("i"), new DataType(Type.INT)));

        LibProcDecl printfloat = new LibProcDecl(
                new Name("printfloat"),
                new DataType(Type.VOID),
                Arrays.asList(new ParamDecl(new Name("f"), new DataType(Type.FLOAT)))
        );
        //printfloat.addParameter(new ParamDecl(new Name("f"), new DataType(Type.FLOAT)));

        LibProcDecl printstr = new LibProcDecl(                             // Write one string
                new Name("printstr"),
                new DataType(Type.VOID),
                Arrays.asList(new ParamDecl(new Name("s"), new DataType(Type.STRING)))
        );
        //printstr.addParameter(new ParamDecl(new Name("s"), new DataType(Type.STRING)));

        LibProcDecl printline = new LibProcDecl(                            // Write one line, followed by a "newline"
                new Name("printline"),
                new DataType(Type.VOID),
                Arrays.asList(new ParamDecl(new Name("s"), new DataType(Type.STRING)))
        );
        //printstr.addParameter(new ParamDecl(new Name("s"), new DataType(Type.STRING)));

        STL.add(printint);
        STL.add(printfloat);
        STL.add(printstr);
        STL.add(printline);
    }

    public ArrayList<LibProcDecl> getSTL() {
        return STL;
    }

}
