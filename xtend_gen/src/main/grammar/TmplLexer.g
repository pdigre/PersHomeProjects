lexer grammar TmplLexer;

options {
  language = Java;
  filter   = true;
}

tokens {
  OUT;
}

@header {
package no.esito.genova.io.antlr;
}

@members {
public TmplLexerSub l;
}
// ****************
// Lexer section
// ***************

REM
  :
  '@rem' 
         {
          l.cmt();
         }
  ;

COMMENT
  :
  '@//' 
        {
         l.cmt();
        }
  ;

SECTION
  :
  '@section' 
             {
              l.file();
             }
  ;

BEGIN
  :
  '@begin' 
             {
              l.file();
             }
  ;

CREATESECTION
  :
  '@createSection' 
                   {
                    l.file();
                   }
  ;

IF_
  :
  '@if' 
        {
         l.file();
        }
  ;

ENDIF
  :
  '@endif' WS? NEWLINE 
                       {
                        l.file();
                       }
  ;

EVENT
  :
  '@event' 
           {
            l.file();
           }
  ;

BOOL_START
  :
  '@(' 
       {
        l.boolStart();
       }
  ;

BOOL_END
  :
  ')@' 
       {
        l.boolEnd();
       }
  ;

ALFA
  :
  '@@' 
       {
        l.alfa();
       }
  ;

DOLLAR
  :
  '$$' 
       {
        l.dollar();
       }
  ;

NEWLINE
  :
  ('\r'? '\n')
  {
        l.newline();
       };

WS
  :
  (
    ' '
    | '\t'
  )+
  ;

ID
  :
  (
    LETTER
    | UNDER
  )+
  ;

INT
  :
  DIGIT+
  ;

fragment
LETTER
  :
  'A'..'Z'
  | 'a'..'z'
  ;

fragment
UNDER
  :
  '_'
  ;

DOT
  :
  '.'
  ;

MINUS
  :
  '-'
  ;

fragment
DIGIT
  :
  '0'..'9'
  ;

LITERAL
  :
  '"' ~('"' )* '"'
  ;

COLON
  :
  ':'
  ;

SEMICOLON
  :
  ';'
  ;

HASH
  :
  '#'
  ;

COMMA
  :
  ','
  ;

SQUOTE
  :
  '\''
  ;

SLASH
  :
  '/'
  ;

LPARAN
  :
  '('
  ;

RPARAN
  :
  ')'
  ;

LBRACK
  :
  '{'
  ;

RBRACK
  :
  '}'
  ;

LSQUARE
  :
  '['
  ;

RSQUARE
  :
  ']'
  ;

APPEND
  :
  '++'
  ;

LT
  :
  '<'
  ;

GT
  :
  '>'
  ;

LE
  :
  '<'
  ;

GE
  :
  '>='
  ;

EQUAL
  :
  '=='
  ;

ASSIGN
  :
  '='
  ;

NE
  :
  '!='
  ;

AND
  :
  '&'
  ;

OR
  :
  '|'
  ;

PLUS
  :
  '+'
  ;

MULTIPLY
  :
  '*'
  ;

NOT
  :
  '!'
  ;

TILDE
  :
  '~'
  ;

HAT
  :
  '^'
  ;

QUESTION
  :
  '?'
  ;
