lexer grammar GLexer;

options {
		language = Java;
		filter = true;
}

tokens {
		OUT;
}

@header {
package no.esito.genova.io.antlr;
import no.esito.genova.io.generator.*;
}

@members {
public GLexerSub l;
}
// ****************
// Lexer section
// ***************

// sections

RESERVED_MODE :
		{l.isTag()}?=> '@reserved' WS? NEWLINE 
                                         {
                                          $channel = HIDDEN;
                                          l.reserved();
                                         }
		(RESERVATION? NEWLINE)+;

fragment RESERVATION :
		RESERVED_ID WS? 
                  {
                   l.addReserved($RESERVED_ID.text);
                  };

fragment RESERVED_ID :
		(
		LETTER
		| UNDER
		| MINUS
		| DOT
		)+;

TYPES_MODE :
		'@types' WS? NEWLINE 
                       {
                        l.types();
                       };

TEMPLATE_MODE :
		'@template' WS? NEWLINE 
                          {
                           l.template();
                           l.out();
                          };

TYPE :
		{l.isTypes()}?=> (TYPE_ID ';') 
                                 {
                                  l.addTypdef($TYPE_ID.text);
                                 };

fragment TYPE_ID :
		(
		LETTER
		| UNDER
		| DOT
		)+;

TYPEDEF :
		'%TYPEDEF%' 
              {
               l.typedef();
              };

// stat_simple

BREAK :
		'%BREAK%' 
            {
             l.out();
            };

CONTINUE :
		'%CONTINUE%' 
               {
                l.out();
               };

ENDFILE :
		'%ENDFILE%' 
              {
               l.out();
              };

POPFILE :
		'%POPFILE%' 
              {
               l.out();
              };

LINE :
		'%LINE%' 
           {
            l.out();
           };

ENDLINE :
		'%ENDLINE%' 
              {
               l.out();
              };

INDENT :
		'%INDENT%' 
             {
              l.out();
             };

INDENT2 :
		'%INDENT:' 
             {
              l.expr();
             };

ENDINDENT :
		'%ENDINDENT%' 
                {
                 l.out();
                };

ENDCONTEXT :
		'%ENDCONTEXT%' 
                 {
                  l.out();
                 };

// stat_prm

ITERATE :
		'%ITERATE:' 
              {
               l.expr();
              };

LOOP :
		'%LOOP:' 
           {
            l.expr();
           };

CONTEXT :
		'%CONTEXT:' 
              {
               l.expr();
              };

IFCONTEXT :
		'%IFCONTEXT:' 
                {
                 l.expr();
                };

IF_ :
		'%IF:' 
         {
          l.expr();
         };

ELSEIF_ :
		'%ELSEIF:' 
             {
              l.expr();
             };

SET :
		'%SET:' 
          {
           l.expr();
          };

INFO :
		'%INFO:' 
           {
            l.expr();
           };

WARNING :
		'%WARNING:' 
              {
               l.expr();
              };

ERROR :
		'%ERROR:' 
            {
             l.expr();
            };

DEBUG :
		'%DEBUG:' 
            {
             l.expr();
            };

MACRO :
		'%MACRO:' 
            {
             l.id();
            };

RESERVED :
		'%ID:' 
         {
          l.id();
         };

TYPED :
		'%TYPE:' 
           {
            l.id();
           };

FILE :
		'%FILE%' 
           {
            l.file();
           };

NEWFILE :
		'%NEWFILE%' 
              {
               l.file();
              };

IGNOREFILE :
		'%IGNOREFILE%' 
                 {
                  l.file();
                 };

PUSHFILE :
		'%PUSHFILE%' 
               {
                l.file();
               };

COPYFILE :
		'%COPYFILE%' 
               {
                l.file();
               };

INCLUDE :
		'%INCLUDE%' 
              {
               l.file();
              };
//INCLUDE :
//    '%INCLUDE%' WS INCLUDE_PART NEWLINE
//                                      {
//                                       $channel = HIDDEN;
//                                       l.out();
//                                       l.doInclude($INCLUDE_PART.text, input);
//                                      };
//fragment INCLUDE_PART :
//		~(
//		'\r'
//		| '\n'
//		 )*;

// stat_cmt

REM :
		'%REM' 
         {
//          $channel = HIDDEN;
          l.cmt();
         };

ENDLOOP :
		'%ENDLOOP' 
             {
              l.cmt();
             };

ENDIF :
		'%ENDIF' 
           {
            l.cmt();
           };

ELSE_ :
		'%ELSE' 
          {
           l.cmt();
          };

ENDITERATE :
		'%ENDITERATE' 
                {
                 l.cmt();
                };

STR :
		'%STR:' 
          {
           l.expr();
          };

ENDSTR :
		'%ENDSTR%' 
             {
              l.out();
             };

DLM : 
		'%';

NEWLINE :
		('\r'? '\n') 
               {
                l.newline();
               };

WS :
		( 
		' '
		| '\t'
		)+
		
   {
    $channel = HIDDEN;
   };

ID :
		(
		LETTER
		| UNDER
		)+;

INT :
		DIGIT+;

fragment LETTER :
		'A'..'Z'
		| 'a'..'z';

fragment UNDER :
		'_';

DOT :
		'.';

MINUS :
		'-';

fragment DIGIT :
		'0'..'9';

LITERAL :
		'"' ~('"')* '"';

COLON :
		':';

SEMICOLON :
		';';

HASH :
		'#';

COMMA :
		',';

SQUOTE :
		'\'';

SLASH :
		'/';

LPARAN :
		'(';

RPARAN :
		')';

LBRACK :
		'{';

RBRACK :
		'}';

LSQUARE :
		'[';

RSQUARE :
		']';

APPEND :
		'++';

LT :
		'<';

GT :
		'>';

LE :
		'<';

GE :
		'>=';

EQUAL :
		'==';

ASSIGN :
		'=';

NE :
		'!=';

AND :
		'&';

OR :
		'|';

PLUS :
		'+';

MULTIPLY :
		'*';

NOT :
		'!';

TILDE :
		'~';

HAT :
		'^';

QUESTION :
		'?';
