package syntaxtree.decl;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.type.CodeType;
import common.error.CodeGenException;
import common.utils.BytecodeTypes;
import syntaxtree.Name;
import syntaxtree.types.DataType;
import java.util.List;

public class LibProcDecl extends ProcDecl {

    public LibProcDecl(Name name, DataType returnType, List<ParamDecl> params) {
        super(name, returnType, params);
    }

    @Override
    public void generateCode(CodeFile codeFile) throws CodeGenException {
        String procName = this.getName().getNameValue();
        CodeType returnType = BytecodeTypes.getCodeType(this.getDataType());

        codeFile.addProcedure(procName);
        CodeProcedure proc = new CodeProcedure(procName, returnType, codeFile);

//        if(this.param != null) {
//          this.param.generateCode(proc);
//          CodeType paramType = BytecodeTypes.getCodeType(this.param.getDataType());
//          proc.addParameter(this.param.getName().getNameValue(), paramType);
//        }

        if(this.getParams() != null) {
            for(ParamDecl param: this.getParams()) {
                CodeType paramType = BytecodeTypes.getCodeType(param.getDataType());
                proc.addParameter(param.getName().getNameValue(), paramType);
            }
        }

        codeFile.updateProcedure(proc);
    }
}
