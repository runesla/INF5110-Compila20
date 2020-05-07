package common;

import common.error.SemanticException;
import syntaxtree.decl.*;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.types.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static syntaxtree.types.Type.*;

public class SymbolTable {

    private Map<Name, ProcDecl> procedures;
    private Map<Name, VarDecl> variables;
    private Map<Name, DataType> userDefinedTypes;
    private ArrayList<SymbolTable> childTables;

    public SymbolTable() {
        this.procedures = new HashMap<>();
        this.variables = new HashMap<>();
        this.userDefinedTypes = new HashMap<>();
        this.childTables = new ArrayList<>();
    }

    public void insert(Decl decl) throws SemanticException {
        if(decl instanceof ProcDecl) {
            insertProcedure((ProcDecl) decl);
        } else if (decl instanceof ParamDecl) {
            insertVariable((ParamDecl) decl);
        } else if (decl instanceof VarDecl) {
            insertVariable((VarDecl) decl);
        } else if (decl instanceof RecDecl) {
            insertUserDefinedType(decl.getDataType());
        }
    }

    public void insertProcedure(ProcDecl proc) throws SemanticException {
        if(procedures.containsKey(proc.getName())) {
            throw new SemanticException("Duplicate procedure declaration " + proc.getName().getNameValue());
        }
        procedures.put(proc.getName(), proc);
    }

    public ProcDecl retrieveProcedure(Name name) {
        return procedures.get(name);
    }

    public void insertVariable(VarDecl var) throws SemanticException {

        if(variables.containsKey(var.getName())) {
            throw new SemanticException("Duplicate variable declaration " + var.getName().getNameValue() + " of type " + var.getDataType().getType().toString());
        }
        variables.put(var.getName(), var);

    }

    public VarDecl retrieveVariable(Name name) {
        return variables.get(name);
    }

    public void insertUserDefinedType(DataType dataType) throws SemanticException {
        if(!isPrimitive(dataType.getType())) {
            if(userDefinedTypes.containsKey(dataType.getName())) {
                throw new SemanticException("Duplicate type declaration " + dataType.getName().getNameValue());
            }
            userDefinedTypes.put(dataType.getName(), dataType);
        }
    }

    public DataType retrieveType(Name name) {
        return userDefinedTypes.get(name);
    }

    public ArrayList<SymbolTable> getChildTables() {
        return this.childTables;
    }

    private boolean isPrimitive(Type type) {
        return type == INT || type == BOOL || type == FLOAT || type == STRING;
    }
}
