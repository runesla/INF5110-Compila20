package common;

import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.decl.ProcDecl;
import syntaxtree.decl.RecDecl;
import syntaxtree.decl.VarDecl;
import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<Name, ProcDecl> procedures;
    private Map<Name, VarDecl> variables;
    private Map<Name, RecDecl> records;
    private Map<Name, DataType> userDefinedTypes;

    public SymbolTable() {
        procedures = new HashMap<>();
        variables = new HashMap<>();
        records = new HashMap<>();
        userDefinedTypes = new HashMap<>();
    }

    public void insertProcedure(ProcDecl proc) throws SemanticException {
        if(procedures.containsKey(proc.getName())) {
            throw new SemanticException("Duplicate declaration");
        }
        procedures.put(proc.getName(), proc);
    }

    public ProcDecl retrieveProcedure(Name name) {
        return procedures.get(name);
    }

    public void insertVariable(VarDecl var) throws SemanticException {
        if(variables.containsKey(var.getName())) {
            throw new SemanticException("Duplicate declaration");
        }
        variables.put(var.getName(), var);
    }

    public VarDecl retrieveVariable(Name name) {
        return variables.get(   name);
    }

    public void insertRecord(RecDecl rec) throws SemanticException {
        if(records.containsKey(rec.getName())) {
            throw new SemanticException("Duplicate declaration");
        }
        records.put(rec.getName(), rec);
    }

    public RecDecl retrieveRecord(Name name) {
        return records.get(name);
    }

    public void insertUserDefinedType(DataType dataType) throws SemanticException {
        if(userDefinedTypes.containsKey(dataType.getName())) {
            throw new SemanticException("Duplicate declaration");
        }
        userDefinedTypes.put(dataType.getName(), dataType);
    }

    public DataType retrieveType(Name name) {
        return userDefinedTypes.get(name);
    }
}
