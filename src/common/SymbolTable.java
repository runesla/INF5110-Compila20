package common;

import common.error.SemanticException;
import syntaxtree.decl.*;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.types.Type;
import java.util.*;

import static syntaxtree.types.Type.*;

public class SymbolTable {

    private Map<Name, ProcDecl> procedures;
    private Map<Name, VarDecl> variables;
    private Map<Name, RecDecl> userDefinedTypes;
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
        } else if (decl instanceof RecDecl) {
            insertUserDefinedType((RecDecl) decl);
        } else if (decl instanceof VarDecl) {
            insertVariable((VarDecl) decl);
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
            throw new SemanticException("Duplicate variable declaration " + var.getName().getNameValue() + " of type " + var.getDataType().getType().get());
        }
        variables.put(var.getName(), var);
    }

    public VarDecl retrieveVariable(Name name) {
        return variables.get(name);
    }

    public void insertUserDefinedType(RecDecl udt) throws SemanticException {
        if(!isPrimitive(udt.getDataType().getType())) {
            if (userDefinedTypes.containsKey(udt.getName())) {
                throw new SemanticException("Duplicate type declaration " + udt.getName().getNameValue());
            }
            userDefinedTypes.put(udt.getName(), udt);
        }
        System.out.println("Type " + udt.getName().getNameValue() + " added to symboltable");
    }

    public RecDecl retrieveType(Name name) {
        return userDefinedTypes.get(name);
    }

    public RecDecl retrieveType(Type type) {
        return userDefinedTypes.get(type.getName());
    }

    public ArrayList<SymbolTable> getChildTables() {
        return this.childTables;
    }

    public SymbolTable createChildTable() {
        SymbolTable childTable = new SymbolTable();
        childTable.procedures.putAll(this.procedures);
        childTable.variables.putAll(this.variables);
        childTable.userDefinedTypes.putAll(this.userDefinedTypes);
        return childTable;
    }

    public void copyToChild(SymbolTable childTable) {
        childTable.procedures.putAll(procedures);
        childTable.variables.putAll(variables);
        childTable.userDefinedTypes.putAll(userDefinedTypes);
    }

    private boolean isPrimitive(Type type) {
        return type == INT || type == BOOL || type == FLOAT || type == STRING;
    }

    public List<ProcDecl> getProcs() {
        List<ProcDecl> procs = new ArrayList<>();
        Iterator itr = procedures.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry pair = (Map.Entry)itr.next();
            procs.add((ProcDecl) pair.getValue());
        }
        return procs;
    }

    public List<VarDecl> getVars() {
        List<VarDecl> vars = new ArrayList<>();
        Iterator itr = variables.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry pair = (Map.Entry)itr.next();
            vars.add((VarDecl) pair.getValue());
        }
        return vars;
    }

    public List<DataType> getRegisteredTypes() {
        List<DataType> types = new ArrayList<>();
        Iterator itr = userDefinedTypes.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry pair = (Map.Entry)itr.next();
            types.add((DataType) pair.getValue());
        }
        return types;
    }
}
