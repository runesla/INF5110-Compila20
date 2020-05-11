package syntaxtree.decl;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.type.CodeType;
import common.error.CodeGenException;
import common.utils.BytecodeTypes;
import syntaxtree.Name;
import syntaxtree.types.DataType;

public class LibProcDecl extends ProcDecl {

    private ParamDecl param;

    public LibProcDecl(Name name, DataType returnType) {
        super(name, returnType);
    }

    public LibProcDecl(Name name, DataType returnType, ParamDecl param) {
        super(name, returnType);
        this.param = param;
    }

    public void addParameter(ParamDecl param) {
        this.param = param;
    }

    @Override
    public void generateCode(CodeFile codeFile) throws CodeGenException {
        String procName = this.getName().getNameValue();
        CodeType returnType = BytecodeTypes.getCodeType(this.getDataType());

        codeFile.addProcedure(procName);
        CodeProcedure proc = new CodeProcedure(procName, returnType, codeFile);

        if(this.param != null) {
            this.param.generateCode(proc);
            CodeType paramType = BytecodeTypes.getCodeType(this.param.getDataType());
            proc.addParameter(this.param.getName().getNameValue(), paramType);
        }

        codeFile.updateProcedure(proc);
    }
}
