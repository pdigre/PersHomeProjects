parser grammar TmplParser;

options {
		language = Java;
		backtrack = true;
		memoize = true;
		output = AST;
		tokenVocab = TmplLexer;
		ASTLabelType = CommonTree;
}

tokens {
    ATTRIBUTE;
    ATTRIBUTE2;
    VARIABLE;
    VARIABLE2;
    ARRAY;
		SUB;
		EXPR;
		FUNCTION;
		PATH;
		THEN;
		PROG;
}

@header {
package no.esito.genova.io.antlr;
}

@members {

}
// ****************
// Grammar section
// ****************

prog :
		(stat{
//          System.out.println($stat.tree.toStringTree());
        } 
)+
         ->  ^(PROG stat+);

stat :
		OUT
		| TYPES_MODE types2* NEWLINE? TEMPLATE_MODE
				-> ^(TYPES_MODE types2* )
		| TYPEDEF types
				-> ^(TYPEDEF types )
    | MACRO ID DLM
        -> ^(MACRO ID )
    | TYPED ID DLM
        -> ^(TYPED ID )
    | RESERVED ID DLM
        -> ^(RESERVED ID )
		| STR ID DLM
				-> ^(STR ID )
		| BREAK
		| CONTINUE
		| POPFILE
		| ENDFILE
		| LINE
		| ENDLINE
		| INDENT
		| ENDINDENT
		| ENDCONTEXT
		| REM 
		| ENDSTR
		| INDENT2 expr DLM
				-> ^(INDENT2 expr )
		| CONTEXT ID DLM
				-> ^(CONTEXT ID )
		| INFO expr DLM
				-> ^(INFO expr )
		| WARNING expr DLM
				-> ^(WARNING expr )
		| ERROR expr DLM
				-> ^(ERROR expr )
		| DEBUG expr DLM
				-> ^(DEBUG expr )
		| FILE filepath NEWLINE
				-> ^(FILE filepath )
		| NEWFILE filepath NEWLINE
				-> ^(NEWFILE filepath )
		| INCLUDE filepath NEWLINE
				-> ^(INCLUDE filepath )
		| IGNOREFILE filepath NEWLINE
				-> ^(IGNOREFILE filepath )
		| PUSHFILE filepath NEWLINE
				-> ^(PUSHFILE filepath )
		| COPYFILE filepath filepath NEWLINE
				-> ^(COPYFILE filepath filepath )
		| IFCONTEXT ID then2 ENDIF
				-> ^(IFCONTEXT ID then2 )
		| IFCONTEXT ID then2 else2 ENDIF
				-> ^(IFCONTEXT ID then2 else2 )
		| IF_ expr then2 elseif* else2? ENDIF
				-> ^(IF_ expr then2 elseif* else2?)
		| SET settable ASSIGN expr DLM
				-> ^(SET settable expr )
		| DLM expr DLM
				-> ^(SUB expr )
		| ITERATE ID DLM stat+ ENDITERATE
				-> ^(ITERATE ^(ID stat+) )
		| LOOP expr DLM stat+ ENDLOOP
				-> ^(LOOP expr ^(SUB stat+) );

then2 :
		DLM stat+
				-> ^(THEN stat+ );

else2 :
		ELSE_ stat+
				-> ^(ELSE_ stat+ );

elseif :
		ELSEIF_ expr then2
				-> ^(ELSEIF_ expr then2 );

types :
    TYPE stat* NEWLINE+
        -> ^(TYPE stat* );
types2 :
    types | REM;

settable :
		ID array*
        -> ^(ATTRIBUTE ID array* )
    | ID DOT ID array*
        -> ^(ATTRIBUTE2 ID ID array* )
    | HASH ID array*
				-> ^(VARIABLE ID array* )
		| ID HASH ID array*
				-> ^(VARIABLE2 ID ID array* ); 

array:
LSQUARE expr RSQUARE
     -> ^(ARRAY expr);

readable :
		settable
		| RESERVED ID
				-> ^(RESERVED ID )
		| TYPED ID
				-> ^(TYPED ID ); 

filepath :
		filepart+
		   -> ^(PATH filepart+);

filepart :
		fileliteral+
		    -> ^(LITERAL fileliteral+)
    | DLM readable DLM
        -> ^(SUB readable )
    | MACRO ID DLM
        -> ^(MACRO ID );

fileliteral :
    ID
    |INT
    | MINUS
    | DOT
    | SLASH ;

expr :
		choice (QUESTION^ expr COLON! expr)*;

choice :
		mult (op1^ mult)*;

op1 :
		PLUS
		| MINUS
		| APPEND
		| OR
		| AND;

mult :
		not (op2^ not)*;

op2 :
		MULTIPLY
		| SLASH
		| TILDE
		| EQUAL
		| NE
		| GT
		| GE
		| LT
		| LE;

not :
		NOT^ pow
		| pow;

pow :
		atom (HAT^ pow)?;

atom :
		(
		PLUS
		| MINUS
		)?
		INT^
		| LITERAL
		| readable
		| (LPARAN! expr RPARAN!)
		| function;
		
function :
ID LPARAN expr RPARAN
  -> ^(FUNCTION ID expr);

		
