package cmp20parser;
import java_cup.runtime.*;
%%

%class Lexer
%unicode
%cup
%line
%column
%public
%{
 StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }

%}
LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]
SingleLineComment = "//" [^\r\n]* {LineTerminator}
MultiLineComment = "(*" [^*] ~"*)"
Identifier = [:jletter:] [:jletterdigit:]*
IntLiteral = 0 | [1-9][0-9]*
FloatLiteral = {IntLiteral} \. {IntLiteral}

%state STRING

%%
<YYINITIAL>{
        {WhiteSpace}                    {}
	{SingleLineComment}		{}
	{MultiLineComment}		{}

	/* Keywords */
        "program"                       { return symbol(sym.PROGRAM); }
        "begin"                         { return symbol(sym.BEGIN); }
	"procedure"			{ return symbol(sym.PROCEDURE); }
        "end"                           { return symbol(sym.END); }
	"var"				{ return symbol(sym.VAR); }
	"then"				{ return symbol(sym.THEN); }
	"if"				{ return symbol(sym.IF); }
	"else"				{ return symbol(sym.ELSE); }
	"fi"				{ return symbol(sym.FI); }
	"return"			{ return symbol(sym.RETURN); }
	"struct"			{ return symbol(sym.STRUCT); }
	"ref"				{ return symbol(sym.REF); }
	"deref"				{ return symbol(sym.DEREF); }
	"while"				{ return symbol(sym.WHILE); }
	"do"				{ return symbol(sym.DO); }
	"od"				{ return symbol(sym.OD); }
	"not"				{ return symbol(sym.NOT); }
	"in"				{ return symbol(sym.IN); }
	"new"				{ return symbol(sym.NEW); }

	/* Symbols  */
        "("                             { return symbol(sym.LPAR); }
        ")"                             { return symbol(sym.RPAR); }
	"{"				{ return symbol(sym.LCURLY); }
	"}"				{ return symbol(sym.RCURLY); }
	","				{ return symbol(sym.COMMA); }
	"."				{ return symbol(sym.DOT); }
	"*"				{ return symbol(sym.MULOP); }
	"/"				{ return symbol(sym.DIVOP); }
	"+"				{ return symbol(sym.ADDOP); }
	"-"				{ return symbol(sym.SUBOP); }
	"^"				{ return symbol(sym.EXP); }
	":"				{ return symbol(sym.COLON); }
	"="				{ return symbol(sym.EQ); }
	":="				{ return symbol(sym.ASSIGN); }
	"<"				{ return symbol(sym.LT); }
	">"				{ return symbol(sym.GT); }
	"<="				{ return symbol(sym.LTEQUAL); }
	">="				{ return symbol(sym.GTEQUAL); }
        ";"                             { return symbol(sym.SEMI); }
	"&&"				{ return symbol(sym.LOG_AND); }
	"||"				{ return symbol(sym.LOG_OR); }	
	"<>"				{ return symbol(sym.NEQUAL); }
	":="				{ return symbol(sym.ASSIGN); }

	/* Types */
	"int"				{ return symbol(sym.TYPE_INT); }
	"float"				{ return symbol(sym.TYPE_FLOAT); }
	"string"			{ return symbol(sym.TYPE_STRING); }
	"bool"				{ return symbol(sym.TYPE_BOOL); }

	/* Boolean constants */
	"true"				{ return symbol(sym.TYPE_BOOL, new Boolean(true)); }
	"false"				{ return symbol(sym.TYPE_BOOL, new Boolean(false)); }
	
	/* Null */
	"null"				{ return symbol(sym.NULL); }

	/* String literal */
	\"				{ yybegin(STRING); string.setLength(0); }

	/* Float literal */
	{FloatLiteral}			{ return symbol(sym.FLOAT_LITERAL, new Float(yytext())); }

	/* Int literal */
	{IntLiteral}			{ return symbol(sym.INT_LITERAL, new Integer(yytext())); }

	/* Identifier */
        {Identifier}                    { return symbol(sym.ID, yytext()); }
}

<STRING> {

	\"				{ yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, string.toString()); }

	[^\n\r\"\\]+			{ string.append(yytext()); }
	\\t				{ string.append('\t'); }
	\\n				{ string.append('\n'); }
	\\r				{ string.append('\r'); }
	\\				{ string.append('\\'); }
	\\\"				{ string.append('\"'); }

}

.					{ throw new Error("Illegal character '" + yytext() + "' at line " + yyline + ", column " + yycolumn + "."); }
