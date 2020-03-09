
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon Mar 09 12:16:16 CET 2020
//----------------------------------------------------

package parser;

import java_cup.runtime.*;
import syntaxtree.*;
import java.util.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Mon Mar 09 12:16:16 CET 2020
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\031\000\002\002\004\000\002\003\007\000\002\017" +
    "\003\000\002\017\002\000\002\016\003\000\002\016\005" +
    "\000\002\004\003\000\002\004\003\000\002\005\006\000" +
    "\002\005\010\000\002\005\006\000\002\007\007\000\002" +
    "\015\003\000\002\015\002\000\002\013\003\000\002\013" +
    "\005\000\002\010\005\000\002\023\003\000\002\024\006" +
    "\000\002\026\003\000\002\026\005\000\002\002\003\000" +
    "\002\002\003\000\002\002\006\000\002\002\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\004\004\005\001\002\000\004\002\064\001" +
    "\002\000\004\061\006\001\002\000\004\005\007\001\002" +
    "\000\010\006\ufffe\025\016\053\010\001\002\000\004\061" +
    "\044\001\002\000\006\006\ufffd\042\ufffd\001\002\000\006" +
    "\006\ufffa\042\ufffa\001\002\000\006\006\ufffb\042\ufffb\001" +
    "\002\000\004\006\043\001\002\000\006\006\uffff\042\041" +
    "\001\002\000\004\061\017\001\002\000\004\030\020\001" +
    "\002\000\006\031\ufff4\061\022\001\002\000\006\031\ufff5" +
    "\042\037\001\002\000\004\041\026\001\002\000\006\031" +
    "\ufff3\042\ufff3\001\002\000\004\031\025\001\002\000\006" +
    "\006\ufff6\042\ufff6\001\002\000\012\022\030\055\033\060" +
    "\032\061\027\001\002\000\014\006\uffe9\027\uffe9\031\uffe9" +
    "\042\uffe9\054\uffe9\001\002\000\004\026\034\001\002\000" +
    "\006\031\ufff1\042\ufff1\001\002\000\014\006\uffeb\027\uffeb" +
    "\031\uffeb\042\uffeb\054\uffeb\001\002\000\014\006\uffec\027" +
    "\uffec\031\uffec\042\uffec\054\uffec\001\002\000\012\022\030" +
    "\055\033\060\032\061\027\001\002\000\004\027\036\001" +
    "\002\000\014\006\uffea\027\uffea\031\uffea\042\uffea\054\uffea" +
    "\001\002\000\004\061\022\001\002\000\006\031\ufff2\042" +
    "\ufff2\001\002\000\006\025\016\053\010\001\002\000\006" +
    "\006\ufffc\042\ufffc\001\002\000\004\002\000\001\002\000" +
    "\006\041\045\054\046\001\002\000\012\022\030\055\033" +
    "\060\032\061\027\001\002\000\004\022\050\001\002\000" +
    "\010\006\ufff0\033\ufff0\042\ufff0\001\002\000\004\026\052" +
    "\001\002\000\006\006\ufff7\042\ufff7\001\002\000\006\022" +
    "\050\061\053\001\002\000\004\027\uffee\001\002\000\004" +
    "\027\060\001\002\000\004\033\056\001\002\000\004\061" +
    "\057\001\002\000\004\027\uffed\001\002\000\010\006\uffef" +
    "\033\uffef\042\uffef\001\002\000\010\006\ufff9\042\ufff9\054" +
    "\062\001\002\000\004\022\050\001\002\000\006\006\ufff8" +
    "\042\ufff8\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\004\003\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\014\004\010\005\012" +
    "\007\011\016\014\017\013\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\010\022\013\020\015\023\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\002\030\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\002\034\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\010\037\001\001\000" +
    "\002\001\001\000\010\004\041\005\012\007\011\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\002\060\001\001\000\006\023\050\024\046\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\010\023\054\024\046\026\053\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\023\062\024\046\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}





}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // type ::= ID 
            {
              Type RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Type(name); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // type ::= REF LPAR type RPAR 
            {
              Type RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Type t = (Type)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new RefType(t); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // type ::= TYPE_BOOL 
            {
              Type RESULT =null;
		 RESULT = new Type("bool"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // type ::= TYPE_INT 
            {
              Type RESULT =null;
		 RESULT = new Type("int"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // var ::= expr DOT ID 
            {
              VarExpr RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr e = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new VarExpr(name, e); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("var",20, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // var ::= ID 
            {
              VarExpr RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new VarExpr(name); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("var",20, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // ref_var ::= REF LPAR var RPAR 
            {
              RefVarExpr RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		VarExpr e = (VarExpr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new RefVarExpr(e); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ref_var",18, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expr ::= ref_var 
            {
              Expr RESULT =null;
		int rvleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rvright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		RefVarExpr rv = (RefVarExpr)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = rv; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expr",17, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // paramfield_decl ::= ID COLON type 
            {
              ParamFieldDecl RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Type t = (Type)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ParamFieldDecl(name, t); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("paramfield_decl",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // rec_params ::= rec_params SEMI paramfield_decl 
            {
              List<ParamFieldDecl> RESULT =null;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		List<ParamFieldDecl> rp = (List<ParamFieldDecl>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int pfdleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int pfdright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParamFieldDecl pfd = (ParamFieldDecl)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 rp.add(pfd); RESULT = rp; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("rec_params",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // rec_params ::= paramfield_decl 
            {
              List<ParamFieldDecl> RESULT =null;
		int pfdleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int pfdright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParamFieldDecl pfd = (ParamFieldDecl)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 List<ParamFieldDecl> pfl = new LinkedList<ParamFieldDecl>(); pfl.add(pfd); RESULT = pfl; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("rec_params",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // opt_rec_params ::= 
            {
              List<ParamFieldDecl> RESULT =null;
		 RESULT = new LinkedList<ParamFieldDecl>(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("opt_rec_params",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // opt_rec_params ::= rec_params 
            {
              List<ParamFieldDecl> RESULT =null;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		List<ParamFieldDecl> rp = (List<ParamFieldDecl>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = rp; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("opt_rec_params",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // rec_decl ::= STRUCT ID LCURLY opt_rec_params RCURLY 
            {
              RecDecl RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int orpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int orpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		List<ParamFieldDecl> orp = (List<ParamFieldDecl>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new RecDecl(name, orp); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("rec_decl",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // var_decl ::= VAR ID ASSIGN expr 
            {
              VarDecl RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Expr e = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new VarDecl(name, e); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("var_decl",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // var_decl ::= VAR ID COLON type ASSIGN expr 
            {
              VarDecl RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Type t = (Type)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Expr e = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new VarDecl(name, t, e); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("var_decl",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // var_decl ::= VAR ID COLON type 
            {
              VarDecl RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Type t = (Type)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new VarDecl(name, t); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("var_decl",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // decl ::= rec_decl 
            {
              Decl RESULT =null;
		int rlleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rlright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		RecDecl rl = (RecDecl)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = rl; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("decl",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // decl ::= var_decl 
            {
              Decl RESULT =null;
		int vdleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vdright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		VarDecl vd = (VarDecl)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = vd; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("decl",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // decl_list ::= decl_list SEMI decl 
            {
              List<Decl> RESULT =null;
		int dlleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int dlright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		List<Decl> dl = (List<Decl>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Decl d = (Decl)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 dl.add(d); RESULT = dl; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("decl_list",12, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // decl_list ::= decl 
            {
              List<Decl> RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Decl d = (Decl)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 List<Decl> dl = new LinkedList<Decl>(); dl.add(d); RESULT = dl; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("decl_list",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // opt_decl_list ::= 
            {
              List<Decl> RESULT =null;
		 RESULT = new LinkedList<Decl>(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("opt_decl_list",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // opt_decl_list ::= decl_list 
            {
              List<Decl> RESULT =null;
		int dlleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int dlright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		List<Decl> dl = (List<Decl>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = dl; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("opt_decl_list",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // program ::= PROGRAM ID BEGIN opt_decl_list END 
            {
              Program RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int dlleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dlright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		List<Decl> dl = (List<Decl>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new Program(name, dl); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("program",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Program start_val = (Program)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

