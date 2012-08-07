parser grammar TmplParser;

options {
  language     = Java;
  backtrack    = true;
  memoize      = true;
  output       = AST;
  tokenVocab   = TmplLexer;
  ASTLabelType = CommonTree;
}

tokens {
  EXPR;
  PATH;
  OPTIONAL;
  BLOCK;
  PROG;
  SECTIONS;
  HEADER;
}

@header {
package no.esito.genova.io.antlr;
}

@members {

}
// ****************
// Grammar section
// ****************

prog
  :
  block sections
    ->
      ^(PROG block sections)
  ;

sections
  :
  section*
    ->
      ^(SECTIONS section*)
  ;

section
  :
  SECTION WS+ filepath filepath2 WS* NEWLINE block
    ->
      ^(SECTION filepath filepath2 block)
  ;

filepath2
  :
  (WS+ filepath)?
    ->
      ^(OPTIONAL filepath?)
  ;

stat
  :
  OUT
  | BEGIN WS* NEWLINE
  | CREATESECTION WS+ filepath filepath2 WS* NEWLINE
    ->
      ^(CREATESECTION filepath filepath2)
  | REM
  | COMMENT
  | IF_ WS+ BOOL_START expr BOOL_END NEWLINE block ENDIF
    ->
      ^(IF_ expr block)
  | EVENT WS+ expr WS* NEWLINE
    ->
      ^(EVENT expr)
  | DOLLAR expr DOLLAR
    ->
      ^(DOLLAR expr)
  | ALFA ID ALFA
    ->
      ^(ALFA ID)
  | BOOL_START expr BOOL_END
    ->
      ^(BOOL_START expr)
  ;

block
  :
  (stat 
        {
         //         System.out.println($stat.tree.toStringTree());
        })*
    ->
      ^(BLOCK stat*)
  ;

filepath
  :
  filepart+
    ->
      ^(PATH filepart+)
  ;

filepart
  :
  ID
  | INT
  | MINUS
  | DOT
  | SLASH
  | ALFA ID ALFA
    ->
      ^(ALFA ID)
  ;

readable
  :
  ID DOT ID
  | ID (WS+ ID)?
  | ALFA ID ALFA
    ->
      ^(ALFA ID)
  ;

expr
  :
  choice (QUESTION^ expr? COLON expr?)*
  ;

choice
  :
  mult (op1^ mult)*
  ;

op1
  :
  PLUS
  | MINUS
  | APPEND
  | OR
  | AND
  ;

mult
  :
  not (op2^ not)*
  ;

op2
  :
  MULTIPLY
  | SLASH
  | TILDE
  | EQUAL
  | NE
  | GT
  | GE
  | LT
  | LE
  ;

not
  :
  NOT^ pow
  | pow
  ;

pow
  :
  atom (HAT^ pow)?
  ;

atom
  :
  (
    PLUS
    | MINUS
  )?
  INT^
  | LITERAL
  | readable
  | (LPARAN! expr RPARAN!)
  ;
