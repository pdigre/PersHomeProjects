// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g 2012-02-04 23:44:57

package no.esito.genova.io.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class PtmParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "OUT", "WS", "NEWLINE", "RESERVATION", "RESERVED_MODE", "RESERVED_ID", "LETTER", "UNDER", "MINUS", "DOT", "TYPES_MODE", "TEMPLATE_MODE", "TYPE_ID", "TYPE", "TYPEDEF", "BREAK", "CONTINUE", "ENDFILE", "POPFILE", "LINE", "ENDLINE", "INDENT", "INDENT2", "ENDINDENT", "ENDCONTEXT", "ITERATE", "LOOP", "CONTEXT", "IFCONTEXT", "IF_", "ELSEIF_", "SET", "INFO", "WARNING", "ERROR", "DEBUG", "MACRO", "RESERVED", "TYPED", "FILE", "NEWFILE", "IGNOREFILE", "PUSHFILE", "COPYFILE", "INCLUDE", "REM", "ENDLOOP", "ENDIF", "ELSE_", "ENDITERATE", "STR", "ENDSTR", "DLM", "ID", "DIGIT", "INT", "LITERAL", "COLON", "SEMICOLON", "HASH", "COMMA", "SQUOTE", "SLASH", "LPARAN", "RPARAN", "LBRACK", "RBRACK", "LSQUARE", "RSQUARE", "APPEND", "LT", "GT", "LE", "GE", "EQUAL", "ASSIGN", "NE", "AND", "OR", "PLUS", "MULTIPLY", "NOT", "TILDE", "HAT", "QUESTION", "ATTRIBUTE", "ATTRIBUTE2", "VARIABLE", "VARIABLE2", "ARRAY", "SUB", "EXPR", "FUNCTION", "PATH", "THEN", "PROG"
    };
    public static final int FUNCTION=96;
    public static final int TYPED=42;
    public static final int LT=74;
    public static final int LSQUARE=71;
    public static final int LETTER=10;
    public static final int PUSHFILE=46;
    public static final int NOT=85;
    public static final int EOF=-1;
    public static final int BREAK=19;
    public static final int TYPE=17;
    public static final int COPYFILE=47;
    public static final int HAT=87;
    public static final int ENDCONTEXT=28;
    public static final int RESERVED=41;
    public static final int PATH=97;
    public static final int IFCONTEXT=32;
    public static final int LOOP=30;
    public static final int ENDINDENT=27;
    public static final int INCLUDE=48;
    public static final int ENDIF=51;
    public static final int RESERVED_MODE=8;
    public static final int ARRAY=93;
    public static final int NE=80;
    public static final int RBRACK=70;
    public static final int GE=77;
    public static final int TYPES_MODE=14;
    public static final int DLM=56;
    public static final int ENDSTR=55;
    public static final int SEMICOLON=62;
    public static final int INT=59;
    public static final int ERROR=38;
    public static final int FILE=43;
    public static final int WS=5;
    public static final int TEMPLATE_MODE=15;
    public static final int VARIABLE=91;
    public static final int OUT=4;
    public static final int IF_=33;
    public static final int ELSEIF_=34;
    public static final int OR=82;
    public static final int GT=75;
    public static final int TYPE_ID=16;
    public static final int WARNING=37;
    public static final int IGNOREFILE=45;
    public static final int APPEND=73;
    public static final int LBRACK=69;
    public static final int VARIABLE2=92;
    public static final int RESERVED_ID=9;
    public static final int ATTRIBUTE=89;
    public static final int SUB=94;
    public static final int ELSE_=52;
    public static final int AND=81;
    public static final int ID=57;
    public static final int INDENT=25;
    public static final int CONTEXT=31;
    public static final int DEBUG=39;
    public static final int STR=54;
    public static final int PROG=99;
    public static final int UNDER=11;
    public static final int EXPR=95;
    public static final int SLASH=66;
    public static final int THEN=98;
    public static final int INDENT2=26;
    public static final int CONTINUE=20;
    public static final int MULTIPLY=84;
    public static final int COMMA=64;
    public static final int RESERVATION=7;
    public static final int EQUAL=78;
    public static final int RPARAN=68;
    public static final int TILDE=86;
    public static final int PLUS=83;
    public static final int DIGIT=58;
    public static final int DOT=13;
    public static final int NEWFILE=44;
    public static final int ENDFILE=21;
    public static final int POPFILE=22;
    public static final int TYPEDEF=18;
    public static final int HASH=63;
    public static final int LITERAL=60;
    public static final int SET=35;
    public static final int RSQUARE=72;
    public static final int SQUOTE=65;
    public static final int REM=49;
    public static final int MINUS=12;
    public static final int LINE=23;
    public static final int ENDITERATE=53;
    public static final int INFO=36;
    public static final int COLON=61;
    public static final int ATTRIBUTE2=90;
    public static final int ITERATE=29;
    public static final int LPARAN=67;
    public static final int QUESTION=88;
    public static final int NEWLINE=6;
    public static final int ASSIGN=79;
    public static final int ENDLINE=24;
    public static final int MACRO=40;
    public static final int LE=76;
    public static final int ENDLOOP=50;

    // delegates
    // delegators


        public PtmParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PtmParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[110+1];
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PtmParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g"; }





    public static class prog_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prog"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:37:1: prog : ( stat )+ -> ^( PROG ( stat )+ ) ;
    public final PtmParser.prog_return prog() throws RecognitionException {
        PtmParser.prog_return retval = new PtmParser.prog_return();
        retval.start = input.LT(1);
        int prog_StartIndex = input.index();
        CommonTree root_0 = null;

        PtmParser.stat_return stat1 = null;


        RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:37:6: ( ( stat )+ -> ^( PROG ( stat )+ ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:38:3: ( stat )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:38:3: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==OUT||LA1_0==TYPES_MODE||(LA1_0>=TYPEDEF && LA1_0<=IF_)||(LA1_0>=SET && LA1_0<=REM)||(LA1_0>=STR && LA1_0<=DLM)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:38:4: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog159);
            	    stat1=stat();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stat.add(stat1.getTree());
            	    if ( state.backtracking==0 ) {

            	      //          System.out.println((stat1!=null?((CommonTree)stat1.tree):null).toStringTree());
            	              
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);



            // AST REWRITE
            // elements: stat
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 42:10: -> ^( PROG ( stat )+ )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:42:14: ^( PROG ( stat )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROG, "PROG"), root_1);

                if ( !(stream_stat.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_stat.hasNext() ) {
                    adaptor.addChild(root_1, stream_stat.nextTree());

                }
                stream_stat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, prog_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "prog"

    public static class stat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stat"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:44:1: stat : ( OUT | TYPES_MODE ( types2 )* ( NEWLINE )? TEMPLATE_MODE -> ^( TYPES_MODE ( types2 )* ) | TYPEDEF types -> ^( TYPEDEF types ) | MACRO ID DLM -> ^( MACRO ID ) | TYPED ID DLM -> ^( TYPED ID ) | RESERVED ID DLM -> ^( RESERVED ID ) | STR ID DLM -> ^( STR ID ) | BREAK | CONTINUE | POPFILE | ENDFILE | LINE | ENDLINE | INDENT | ENDINDENT | ENDCONTEXT | REM | ENDSTR | INDENT2 expr DLM -> ^( INDENT2 expr ) | CONTEXT ID DLM -> ^( CONTEXT ID ) | INFO expr DLM -> ^( INFO expr ) | WARNING expr DLM -> ^( WARNING expr ) | ERROR expr DLM -> ^( ERROR expr ) | DEBUG expr DLM -> ^( DEBUG expr ) | FILE filepath NEWLINE -> ^( FILE filepath ) | NEWFILE filepath NEWLINE -> ^( NEWFILE filepath ) | INCLUDE filepath NEWLINE -> ^( INCLUDE filepath ) | IGNOREFILE filepath NEWLINE -> ^( IGNOREFILE filepath ) | PUSHFILE filepath NEWLINE -> ^( PUSHFILE filepath ) | COPYFILE filepath filepath NEWLINE -> ^( COPYFILE filepath filepath ) | IFCONTEXT ID then2 ENDIF -> ^( IFCONTEXT ID then2 ) | IFCONTEXT ID then2 else2 ENDIF -> ^( IFCONTEXT ID then2 else2 ) | IF_ expr then2 ( elseif )* ( else2 )? ENDIF -> ^( IF_ expr then2 ( elseif )* ( else2 )? ) | SET settable ASSIGN expr DLM -> ^( SET settable expr ) | DLM expr DLM -> ^( SUB expr ) | ITERATE ID DLM ( stat )+ ENDITERATE -> ^( ITERATE ^( ID ( stat )+ ) ) | LOOP expr DLM ( stat )+ ENDLOOP -> ^( LOOP expr ^( SUB ( stat )+ ) ) );
    public final PtmParser.stat_return stat() throws RecognitionException {
        PtmParser.stat_return retval = new PtmParser.stat_return();
        retval.start = input.LT(1);
        int stat_StartIndex = input.index();
        CommonTree root_0 = null;

        Token OUT2=null;
        Token TYPES_MODE3=null;
        Token NEWLINE5=null;
        Token TEMPLATE_MODE6=null;
        Token TYPEDEF7=null;
        Token MACRO9=null;
        Token ID10=null;
        Token DLM11=null;
        Token TYPED12=null;
        Token ID13=null;
        Token DLM14=null;
        Token RESERVED15=null;
        Token ID16=null;
        Token DLM17=null;
        Token STR18=null;
        Token ID19=null;
        Token DLM20=null;
        Token BREAK21=null;
        Token CONTINUE22=null;
        Token POPFILE23=null;
        Token ENDFILE24=null;
        Token LINE25=null;
        Token ENDLINE26=null;
        Token INDENT27=null;
        Token ENDINDENT28=null;
        Token ENDCONTEXT29=null;
        Token REM30=null;
        Token ENDSTR31=null;
        Token INDENT232=null;
        Token DLM34=null;
        Token CONTEXT35=null;
        Token ID36=null;
        Token DLM37=null;
        Token INFO38=null;
        Token DLM40=null;
        Token WARNING41=null;
        Token DLM43=null;
        Token ERROR44=null;
        Token DLM46=null;
        Token DEBUG47=null;
        Token DLM49=null;
        Token FILE50=null;
        Token NEWLINE52=null;
        Token NEWFILE53=null;
        Token NEWLINE55=null;
        Token INCLUDE56=null;
        Token NEWLINE58=null;
        Token IGNOREFILE59=null;
        Token NEWLINE61=null;
        Token PUSHFILE62=null;
        Token NEWLINE64=null;
        Token COPYFILE65=null;
        Token NEWLINE68=null;
        Token IFCONTEXT69=null;
        Token ID70=null;
        Token ENDIF72=null;
        Token IFCONTEXT73=null;
        Token ID74=null;
        Token ENDIF77=null;
        Token IF_78=null;
        Token ENDIF83=null;
        Token SET84=null;
        Token ASSIGN86=null;
        Token DLM88=null;
        Token DLM89=null;
        Token DLM91=null;
        Token ITERATE92=null;
        Token ID93=null;
        Token DLM94=null;
        Token ENDITERATE96=null;
        Token LOOP97=null;
        Token DLM99=null;
        Token ENDLOOP101=null;
        PtmParser.types2_return types24 = null;

        PtmParser.types_return types8 = null;

        PtmParser.expr_return expr33 = null;

        PtmParser.expr_return expr39 = null;

        PtmParser.expr_return expr42 = null;

        PtmParser.expr_return expr45 = null;

        PtmParser.expr_return expr48 = null;

        PtmParser.filepath_return filepath51 = null;

        PtmParser.filepath_return filepath54 = null;

        PtmParser.filepath_return filepath57 = null;

        PtmParser.filepath_return filepath60 = null;

        PtmParser.filepath_return filepath63 = null;

        PtmParser.filepath_return filepath66 = null;

        PtmParser.filepath_return filepath67 = null;

        PtmParser.then2_return then271 = null;

        PtmParser.then2_return then275 = null;

        PtmParser.else2_return else276 = null;

        PtmParser.expr_return expr79 = null;

        PtmParser.then2_return then280 = null;

        PtmParser.elseif_return elseif81 = null;

        PtmParser.else2_return else282 = null;

        PtmParser.settable_return settable85 = null;

        PtmParser.expr_return expr87 = null;

        PtmParser.expr_return expr90 = null;

        PtmParser.stat_return stat95 = null;

        PtmParser.expr_return expr98 = null;

        PtmParser.stat_return stat100 = null;


        CommonTree OUT2_tree=null;
        CommonTree TYPES_MODE3_tree=null;
        CommonTree NEWLINE5_tree=null;
        CommonTree TEMPLATE_MODE6_tree=null;
        CommonTree TYPEDEF7_tree=null;
        CommonTree MACRO9_tree=null;
        CommonTree ID10_tree=null;
        CommonTree DLM11_tree=null;
        CommonTree TYPED12_tree=null;
        CommonTree ID13_tree=null;
        CommonTree DLM14_tree=null;
        CommonTree RESERVED15_tree=null;
        CommonTree ID16_tree=null;
        CommonTree DLM17_tree=null;
        CommonTree STR18_tree=null;
        CommonTree ID19_tree=null;
        CommonTree DLM20_tree=null;
        CommonTree BREAK21_tree=null;
        CommonTree CONTINUE22_tree=null;
        CommonTree POPFILE23_tree=null;
        CommonTree ENDFILE24_tree=null;
        CommonTree LINE25_tree=null;
        CommonTree ENDLINE26_tree=null;
        CommonTree INDENT27_tree=null;
        CommonTree ENDINDENT28_tree=null;
        CommonTree ENDCONTEXT29_tree=null;
        CommonTree REM30_tree=null;
        CommonTree ENDSTR31_tree=null;
        CommonTree INDENT232_tree=null;
        CommonTree DLM34_tree=null;
        CommonTree CONTEXT35_tree=null;
        CommonTree ID36_tree=null;
        CommonTree DLM37_tree=null;
        CommonTree INFO38_tree=null;
        CommonTree DLM40_tree=null;
        CommonTree WARNING41_tree=null;
        CommonTree DLM43_tree=null;
        CommonTree ERROR44_tree=null;
        CommonTree DLM46_tree=null;
        CommonTree DEBUG47_tree=null;
        CommonTree DLM49_tree=null;
        CommonTree FILE50_tree=null;
        CommonTree NEWLINE52_tree=null;
        CommonTree NEWFILE53_tree=null;
        CommonTree NEWLINE55_tree=null;
        CommonTree INCLUDE56_tree=null;
        CommonTree NEWLINE58_tree=null;
        CommonTree IGNOREFILE59_tree=null;
        CommonTree NEWLINE61_tree=null;
        CommonTree PUSHFILE62_tree=null;
        CommonTree NEWLINE64_tree=null;
        CommonTree COPYFILE65_tree=null;
        CommonTree NEWLINE68_tree=null;
        CommonTree IFCONTEXT69_tree=null;
        CommonTree ID70_tree=null;
        CommonTree ENDIF72_tree=null;
        CommonTree IFCONTEXT73_tree=null;
        CommonTree ID74_tree=null;
        CommonTree ENDIF77_tree=null;
        CommonTree IF_78_tree=null;
        CommonTree ENDIF83_tree=null;
        CommonTree SET84_tree=null;
        CommonTree ASSIGN86_tree=null;
        CommonTree DLM88_tree=null;
        CommonTree DLM89_tree=null;
        CommonTree DLM91_tree=null;
        CommonTree ITERATE92_tree=null;
        CommonTree ID93_tree=null;
        CommonTree DLM94_tree=null;
        CommonTree ENDITERATE96_tree=null;
        CommonTree LOOP97_tree=null;
        CommonTree DLM99_tree=null;
        CommonTree ENDLOOP101_tree=null;
        RewriteRuleTokenStream stream_TYPED=new RewriteRuleTokenStream(adaptor,"token TYPED");
        RewriteRuleTokenStream stream_NEWFILE=new RewriteRuleTokenStream(adaptor,"token NEWFILE");
        RewriteRuleTokenStream stream_IGNOREFILE=new RewriteRuleTokenStream(adaptor,"token IGNOREFILE");
        RewriteRuleTokenStream stream_TYPES_MODE=new RewriteRuleTokenStream(adaptor,"token TYPES_MODE");
        RewriteRuleTokenStream stream_DLM=new RewriteRuleTokenStream(adaptor,"token DLM");
        RewriteRuleTokenStream stream_TYPEDEF=new RewriteRuleTokenStream(adaptor,"token TYPEDEF");
        RewriteRuleTokenStream stream_PUSHFILE=new RewriteRuleTokenStream(adaptor,"token PUSHFILE");
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_ERROR=new RewriteRuleTokenStream(adaptor,"token ERROR");
        RewriteRuleTokenStream stream_FILE=new RewriteRuleTokenStream(adaptor,"token FILE");
        RewriteRuleTokenStream stream_ENDITERATE=new RewriteRuleTokenStream(adaptor,"token ENDITERATE");
        RewriteRuleTokenStream stream_INFO=new RewriteRuleTokenStream(adaptor,"token INFO");
        RewriteRuleTokenStream stream_CONTEXT=new RewriteRuleTokenStream(adaptor,"token CONTEXT");
        RewriteRuleTokenStream stream_DEBUG=new RewriteRuleTokenStream(adaptor,"token DEBUG");
        RewriteRuleTokenStream stream_COPYFILE=new RewriteRuleTokenStream(adaptor,"token COPYFILE");
        RewriteRuleTokenStream stream_STR=new RewriteRuleTokenStream(adaptor,"token STR");
        RewriteRuleTokenStream stream_ITERATE=new RewriteRuleTokenStream(adaptor,"token ITERATE");
        RewriteRuleTokenStream stream_RESERVED=new RewriteRuleTokenStream(adaptor,"token RESERVED");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_TEMPLATE_MODE=new RewriteRuleTokenStream(adaptor,"token TEMPLATE_MODE");
        RewriteRuleTokenStream stream_INDENT2=new RewriteRuleTokenStream(adaptor,"token INDENT2");
        RewriteRuleTokenStream stream_IF_=new RewriteRuleTokenStream(adaptor,"token IF_");
        RewriteRuleTokenStream stream_IFCONTEXT=new RewriteRuleTokenStream(adaptor,"token IFCONTEXT");
        RewriteRuleTokenStream stream_LOOP=new RewriteRuleTokenStream(adaptor,"token LOOP");
        RewriteRuleTokenStream stream_INCLUDE=new RewriteRuleTokenStream(adaptor,"token INCLUDE");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_WARNING=new RewriteRuleTokenStream(adaptor,"token WARNING");
        RewriteRuleTokenStream stream_MACRO=new RewriteRuleTokenStream(adaptor,"token MACRO");
        RewriteRuleTokenStream stream_ENDLOOP=new RewriteRuleTokenStream(adaptor,"token ENDLOOP");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        RewriteRuleSubtreeStream stream_settable=new RewriteRuleSubtreeStream(adaptor,"rule settable");
        RewriteRuleSubtreeStream stream_elseif=new RewriteRuleSubtreeStream(adaptor,"rule elseif");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_then2=new RewriteRuleSubtreeStream(adaptor,"rule then2");
        RewriteRuleSubtreeStream stream_types=new RewriteRuleSubtreeStream(adaptor,"rule types");
        RewriteRuleSubtreeStream stream_types2=new RewriteRuleSubtreeStream(adaptor,"rule types2");
        RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
        RewriteRuleSubtreeStream stream_else2=new RewriteRuleSubtreeStream(adaptor,"rule else2");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:44:6: ( OUT | TYPES_MODE ( types2 )* ( NEWLINE )? TEMPLATE_MODE -> ^( TYPES_MODE ( types2 )* ) | TYPEDEF types -> ^( TYPEDEF types ) | MACRO ID DLM -> ^( MACRO ID ) | TYPED ID DLM -> ^( TYPED ID ) | RESERVED ID DLM -> ^( RESERVED ID ) | STR ID DLM -> ^( STR ID ) | BREAK | CONTINUE | POPFILE | ENDFILE | LINE | ENDLINE | INDENT | ENDINDENT | ENDCONTEXT | REM | ENDSTR | INDENT2 expr DLM -> ^( INDENT2 expr ) | CONTEXT ID DLM -> ^( CONTEXT ID ) | INFO expr DLM -> ^( INFO expr ) | WARNING expr DLM -> ^( WARNING expr ) | ERROR expr DLM -> ^( ERROR expr ) | DEBUG expr DLM -> ^( DEBUG expr ) | FILE filepath NEWLINE -> ^( FILE filepath ) | NEWFILE filepath NEWLINE -> ^( NEWFILE filepath ) | INCLUDE filepath NEWLINE -> ^( INCLUDE filepath ) | IGNOREFILE filepath NEWLINE -> ^( IGNOREFILE filepath ) | PUSHFILE filepath NEWLINE -> ^( PUSHFILE filepath ) | COPYFILE filepath filepath NEWLINE -> ^( COPYFILE filepath filepath ) | IFCONTEXT ID then2 ENDIF -> ^( IFCONTEXT ID then2 ) | IFCONTEXT ID then2 else2 ENDIF -> ^( IFCONTEXT ID then2 else2 ) | IF_ expr then2 ( elseif )* ( else2 )? ENDIF -> ^( IF_ expr then2 ( elseif )* ( else2 )? ) | SET settable ASSIGN expr DLM -> ^( SET settable expr ) | DLM expr DLM -> ^( SUB expr ) | ITERATE ID DLM ( stat )+ ENDITERATE -> ^( ITERATE ^( ID ( stat )+ ) ) | LOOP expr DLM ( stat )+ ENDLOOP -> ^( LOOP expr ^( SUB ( stat )+ ) ) )
            int alt8=37;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:45:3: OUT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    OUT2=(Token)match(input,OUT,FOLLOW_OUT_in_stat193); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUT2_tree = (CommonTree)adaptor.create(OUT2);
                    adaptor.addChild(root_0, OUT2_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:46:5: TYPES_MODE ( types2 )* ( NEWLINE )? TEMPLATE_MODE
                    {
                    TYPES_MODE3=(Token)match(input,TYPES_MODE,FOLLOW_TYPES_MODE_in_stat199); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TYPES_MODE.add(TYPES_MODE3);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:46:16: ( types2 )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==TYPE||LA2_0==REM) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: types2
                    	    {
                    	    pushFollow(FOLLOW_types2_in_stat201);
                    	    types24=types2();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_types2.add(types24.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:46:24: ( NEWLINE )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==NEWLINE) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: NEWLINE
                            {
                            NEWLINE5=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat204); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE5);


                            }
                            break;

                    }

                    TEMPLATE_MODE6=(Token)match(input,TEMPLATE_MODE,FOLLOW_TEMPLATE_MODE_in_stat207); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TEMPLATE_MODE.add(TEMPLATE_MODE6);



                    // AST REWRITE
                    // elements: types2, TYPES_MODE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 47:5: -> ^( TYPES_MODE ( types2 )* )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:47:8: ^( TYPES_MODE ( types2 )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_TYPES_MODE.nextNode(), root_1);

                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:47:21: ( types2 )*
                        while ( stream_types2.hasNext() ) {
                            adaptor.addChild(root_1, stream_types2.nextTree());

                        }
                        stream_types2.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:48:5: TYPEDEF types
                    {
                    TYPEDEF7=(Token)match(input,TYPEDEF,FOLLOW_TYPEDEF_in_stat227); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TYPEDEF.add(TYPEDEF7);

                    pushFollow(FOLLOW_types_in_stat229);
                    types8=types();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_types.add(types8.getTree());


                    // AST REWRITE
                    // elements: TYPEDEF, types
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 49:5: -> ^( TYPEDEF types )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:49:8: ^( TYPEDEF types )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_TYPEDEF.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_types.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:50:7: MACRO ID DLM
                    {
                    MACRO9=(Token)match(input,MACRO,FOLLOW_MACRO_in_stat250); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MACRO.add(MACRO9);

                    ID10=(Token)match(input,ID,FOLLOW_ID_in_stat252); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID10);

                    DLM11=(Token)match(input,DLM,FOLLOW_DLM_in_stat254); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM11);



                    // AST REWRITE
                    // elements: ID, MACRO
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 51:9: -> ^( MACRO ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:51:12: ^( MACRO ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_MACRO.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:52:7: TYPED ID DLM
                    {
                    TYPED12=(Token)match(input,TYPED,FOLLOW_TYPED_in_stat279); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TYPED.add(TYPED12);

                    ID13=(Token)match(input,ID,FOLLOW_ID_in_stat281); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID13);

                    DLM14=(Token)match(input,DLM,FOLLOW_DLM_in_stat283); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM14);



                    // AST REWRITE
                    // elements: TYPED, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 53:9: -> ^( TYPED ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:53:12: ^( TYPED ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_TYPED.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:54:7: RESERVED ID DLM
                    {
                    RESERVED15=(Token)match(input,RESERVED,FOLLOW_RESERVED_in_stat308); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RESERVED.add(RESERVED15);

                    ID16=(Token)match(input,ID,FOLLOW_ID_in_stat310); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID16);

                    DLM17=(Token)match(input,DLM,FOLLOW_DLM_in_stat312); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM17);



                    // AST REWRITE
                    // elements: RESERVED, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 55:9: -> ^( RESERVED ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:55:12: ^( RESERVED ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_RESERVED.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:56:5: STR ID DLM
                    {
                    STR18=(Token)match(input,STR,FOLLOW_STR_in_stat335); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STR.add(STR18);

                    ID19=(Token)match(input,ID,FOLLOW_ID_in_stat337); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID19);

                    DLM20=(Token)match(input,DLM,FOLLOW_DLM_in_stat339); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM20);



                    // AST REWRITE
                    // elements: STR, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 57:5: -> ^( STR ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:57:8: ^( STR ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_STR.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:58:5: BREAK
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    BREAK21=(Token)match(input,BREAK,FOLLOW_BREAK_in_stat358); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BREAK21_tree = (CommonTree)adaptor.create(BREAK21);
                    adaptor.addChild(root_0, BREAK21_tree);
                    }

                    }
                    break;
                case 9 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:59:5: CONTINUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONTINUE22=(Token)match(input,CONTINUE,FOLLOW_CONTINUE_in_stat364); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONTINUE22_tree = (CommonTree)adaptor.create(CONTINUE22);
                    adaptor.addChild(root_0, CONTINUE22_tree);
                    }

                    }
                    break;
                case 10 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:60:5: POPFILE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    POPFILE23=(Token)match(input,POPFILE,FOLLOW_POPFILE_in_stat370); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POPFILE23_tree = (CommonTree)adaptor.create(POPFILE23);
                    adaptor.addChild(root_0, POPFILE23_tree);
                    }

                    }
                    break;
                case 11 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:61:5: ENDFILE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ENDFILE24=(Token)match(input,ENDFILE,FOLLOW_ENDFILE_in_stat376); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ENDFILE24_tree = (CommonTree)adaptor.create(ENDFILE24);
                    adaptor.addChild(root_0, ENDFILE24_tree);
                    }

                    }
                    break;
                case 12 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:62:5: LINE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LINE25=(Token)match(input,LINE,FOLLOW_LINE_in_stat382); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LINE25_tree = (CommonTree)adaptor.create(LINE25);
                    adaptor.addChild(root_0, LINE25_tree);
                    }

                    }
                    break;
                case 13 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:63:5: ENDLINE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ENDLINE26=(Token)match(input,ENDLINE,FOLLOW_ENDLINE_in_stat388); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ENDLINE26_tree = (CommonTree)adaptor.create(ENDLINE26);
                    adaptor.addChild(root_0, ENDLINE26_tree);
                    }

                    }
                    break;
                case 14 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:64:5: INDENT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    INDENT27=(Token)match(input,INDENT,FOLLOW_INDENT_in_stat394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INDENT27_tree = (CommonTree)adaptor.create(INDENT27);
                    adaptor.addChild(root_0, INDENT27_tree);
                    }

                    }
                    break;
                case 15 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:65:5: ENDINDENT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ENDINDENT28=(Token)match(input,ENDINDENT,FOLLOW_ENDINDENT_in_stat400); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ENDINDENT28_tree = (CommonTree)adaptor.create(ENDINDENT28);
                    adaptor.addChild(root_0, ENDINDENT28_tree);
                    }

                    }
                    break;
                case 16 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:66:5: ENDCONTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ENDCONTEXT29=(Token)match(input,ENDCONTEXT,FOLLOW_ENDCONTEXT_in_stat406); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ENDCONTEXT29_tree = (CommonTree)adaptor.create(ENDCONTEXT29);
                    adaptor.addChild(root_0, ENDCONTEXT29_tree);
                    }

                    }
                    break;
                case 17 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:67:5: REM
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    REM30=(Token)match(input,REM,FOLLOW_REM_in_stat412); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    REM30_tree = (CommonTree)adaptor.create(REM30);
                    adaptor.addChild(root_0, REM30_tree);
                    }

                    }
                    break;
                case 18 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:68:5: ENDSTR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ENDSTR31=(Token)match(input,ENDSTR,FOLLOW_ENDSTR_in_stat419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ENDSTR31_tree = (CommonTree)adaptor.create(ENDSTR31);
                    adaptor.addChild(root_0, ENDSTR31_tree);
                    }

                    }
                    break;
                case 19 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:69:5: INDENT2 expr DLM
                    {
                    INDENT232=(Token)match(input,INDENT2,FOLLOW_INDENT2_in_stat425); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INDENT2.add(INDENT232);

                    pushFollow(FOLLOW_expr_in_stat427);
                    expr33=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr33.getTree());
                    DLM34=(Token)match(input,DLM,FOLLOW_DLM_in_stat429); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM34);



                    // AST REWRITE
                    // elements: expr, INDENT2
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 70:5: -> ^( INDENT2 expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:70:8: ^( INDENT2 expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_INDENT2.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 20 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:71:5: CONTEXT ID DLM
                    {
                    CONTEXT35=(Token)match(input,CONTEXT,FOLLOW_CONTEXT_in_stat448); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONTEXT.add(CONTEXT35);

                    ID36=(Token)match(input,ID,FOLLOW_ID_in_stat450); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID36);

                    DLM37=(Token)match(input,DLM,FOLLOW_DLM_in_stat452); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM37);



                    // AST REWRITE
                    // elements: ID, CONTEXT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 72:5: -> ^( CONTEXT ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:72:8: ^( CONTEXT ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_CONTEXT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 21 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:73:5: INFO expr DLM
                    {
                    INFO38=(Token)match(input,INFO,FOLLOW_INFO_in_stat471); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INFO.add(INFO38);

                    pushFollow(FOLLOW_expr_in_stat473);
                    expr39=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr39.getTree());
                    DLM40=(Token)match(input,DLM,FOLLOW_DLM_in_stat475); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM40);



                    // AST REWRITE
                    // elements: expr, INFO
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 74:5: -> ^( INFO expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:74:8: ^( INFO expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_INFO.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 22 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:75:5: WARNING expr DLM
                    {
                    WARNING41=(Token)match(input,WARNING,FOLLOW_WARNING_in_stat494); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WARNING.add(WARNING41);

                    pushFollow(FOLLOW_expr_in_stat496);
                    expr42=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr42.getTree());
                    DLM43=(Token)match(input,DLM,FOLLOW_DLM_in_stat498); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM43);



                    // AST REWRITE
                    // elements: WARNING, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 76:5: -> ^( WARNING expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:76:8: ^( WARNING expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_WARNING.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 23 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:77:5: ERROR expr DLM
                    {
                    ERROR44=(Token)match(input,ERROR,FOLLOW_ERROR_in_stat517); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ERROR.add(ERROR44);

                    pushFollow(FOLLOW_expr_in_stat519);
                    expr45=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr45.getTree());
                    DLM46=(Token)match(input,DLM,FOLLOW_DLM_in_stat521); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM46);



                    // AST REWRITE
                    // elements: ERROR, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 78:5: -> ^( ERROR expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:78:8: ^( ERROR expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_ERROR.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 24 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:79:5: DEBUG expr DLM
                    {
                    DEBUG47=(Token)match(input,DEBUG,FOLLOW_DEBUG_in_stat540); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEBUG.add(DEBUG47);

                    pushFollow(FOLLOW_expr_in_stat542);
                    expr48=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr48.getTree());
                    DLM49=(Token)match(input,DLM,FOLLOW_DLM_in_stat544); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM49);



                    // AST REWRITE
                    // elements: DEBUG, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 80:5: -> ^( DEBUG expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:80:8: ^( DEBUG expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_DEBUG.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 25 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:81:5: FILE filepath NEWLINE
                    {
                    FILE50=(Token)match(input,FILE,FOLLOW_FILE_in_stat563); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FILE.add(FILE50);

                    pushFollow(FOLLOW_filepath_in_stat565);
                    filepath51=filepath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath.add(filepath51.getTree());
                    NEWLINE52=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat567); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE52);



                    // AST REWRITE
                    // elements: FILE, filepath
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 82:5: -> ^( FILE filepath )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:82:8: ^( FILE filepath )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_FILE.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_filepath.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 26 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:83:5: NEWFILE filepath NEWLINE
                    {
                    NEWFILE53=(Token)match(input,NEWFILE,FOLLOW_NEWFILE_in_stat586); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWFILE.add(NEWFILE53);

                    pushFollow(FOLLOW_filepath_in_stat588);
                    filepath54=filepath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath.add(filepath54.getTree());
                    NEWLINE55=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat590); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE55);



                    // AST REWRITE
                    // elements: NEWFILE, filepath
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 84:5: -> ^( NEWFILE filepath )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:84:8: ^( NEWFILE filepath )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_NEWFILE.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_filepath.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 27 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:85:5: INCLUDE filepath NEWLINE
                    {
                    INCLUDE56=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_stat609); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INCLUDE.add(INCLUDE56);

                    pushFollow(FOLLOW_filepath_in_stat611);
                    filepath57=filepath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath.add(filepath57.getTree());
                    NEWLINE58=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat613); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE58);



                    // AST REWRITE
                    // elements: INCLUDE, filepath
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 86:5: -> ^( INCLUDE filepath )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:86:8: ^( INCLUDE filepath )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_INCLUDE.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_filepath.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 28 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:87:5: IGNOREFILE filepath NEWLINE
                    {
                    IGNOREFILE59=(Token)match(input,IGNOREFILE,FOLLOW_IGNOREFILE_in_stat632); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IGNOREFILE.add(IGNOREFILE59);

                    pushFollow(FOLLOW_filepath_in_stat634);
                    filepath60=filepath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath.add(filepath60.getTree());
                    NEWLINE61=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat636); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE61);



                    // AST REWRITE
                    // elements: filepath, IGNOREFILE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 88:5: -> ^( IGNOREFILE filepath )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:88:8: ^( IGNOREFILE filepath )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_IGNOREFILE.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_filepath.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 29 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:89:5: PUSHFILE filepath NEWLINE
                    {
                    PUSHFILE62=(Token)match(input,PUSHFILE,FOLLOW_PUSHFILE_in_stat655); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PUSHFILE.add(PUSHFILE62);

                    pushFollow(FOLLOW_filepath_in_stat657);
                    filepath63=filepath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath.add(filepath63.getTree());
                    NEWLINE64=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat659); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE64);



                    // AST REWRITE
                    // elements: filepath, PUSHFILE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 90:5: -> ^( PUSHFILE filepath )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:90:8: ^( PUSHFILE filepath )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_PUSHFILE.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_filepath.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 30 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:91:5: COPYFILE filepath filepath NEWLINE
                    {
                    COPYFILE65=(Token)match(input,COPYFILE,FOLLOW_COPYFILE_in_stat678); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COPYFILE.add(COPYFILE65);

                    pushFollow(FOLLOW_filepath_in_stat680);
                    filepath66=filepath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath.add(filepath66.getTree());
                    pushFollow(FOLLOW_filepath_in_stat682);
                    filepath67=filepath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath.add(filepath67.getTree());
                    NEWLINE68=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat684); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE68);



                    // AST REWRITE
                    // elements: filepath, filepath, COPYFILE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 92:5: -> ^( COPYFILE filepath filepath )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:92:8: ^( COPYFILE filepath filepath )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_COPYFILE.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_filepath.nextTree());
                        adaptor.addChild(root_1, stream_filepath.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 31 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:93:5: IFCONTEXT ID then2 ENDIF
                    {
                    IFCONTEXT69=(Token)match(input,IFCONTEXT,FOLLOW_IFCONTEXT_in_stat705); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IFCONTEXT.add(IFCONTEXT69);

                    ID70=(Token)match(input,ID,FOLLOW_ID_in_stat707); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID70);

                    pushFollow(FOLLOW_then2_in_stat709);
                    then271=then2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_then2.add(then271.getTree());
                    ENDIF72=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat711); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENDIF.add(ENDIF72);



                    // AST REWRITE
                    // elements: IFCONTEXT, then2, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 94:5: -> ^( IFCONTEXT ID then2 )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:94:8: ^( IFCONTEXT ID then2 )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_IFCONTEXT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_then2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 32 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:95:5: IFCONTEXT ID then2 else2 ENDIF
                    {
                    IFCONTEXT73=(Token)match(input,IFCONTEXT,FOLLOW_IFCONTEXT_in_stat732); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IFCONTEXT.add(IFCONTEXT73);

                    ID74=(Token)match(input,ID,FOLLOW_ID_in_stat734); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID74);

                    pushFollow(FOLLOW_then2_in_stat736);
                    then275=then2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_then2.add(then275.getTree());
                    pushFollow(FOLLOW_else2_in_stat738);
                    else276=else2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_else2.add(else276.getTree());
                    ENDIF77=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat740); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENDIF.add(ENDIF77);



                    // AST REWRITE
                    // elements: else2, then2, ID, IFCONTEXT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 96:5: -> ^( IFCONTEXT ID then2 else2 )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:96:8: ^( IFCONTEXT ID then2 else2 )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_IFCONTEXT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_then2.nextTree());
                        adaptor.addChild(root_1, stream_else2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 33 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:97:5: IF_ expr then2 ( elseif )* ( else2 )? ENDIF
                    {
                    IF_78=(Token)match(input,IF_,FOLLOW_IF__in_stat763); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IF_.add(IF_78);

                    pushFollow(FOLLOW_expr_in_stat765);
                    expr79=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr79.getTree());
                    pushFollow(FOLLOW_then2_in_stat767);
                    then280=then2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_then2.add(then280.getTree());
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:97:20: ( elseif )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==ELSEIF_) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: elseif
                    	    {
                    	    pushFollow(FOLLOW_elseif_in_stat769);
                    	    elseif81=elseif();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_elseif.add(elseif81.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:97:28: ( else2 )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==ELSE_) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: else2
                            {
                            pushFollow(FOLLOW_else2_in_stat772);
                            else282=else2();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_else2.add(else282.getTree());

                            }
                            break;

                    }

                    ENDIF83=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat775); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENDIF.add(ENDIF83);



                    // AST REWRITE
                    // elements: then2, expr, elseif, IF_, else2
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 98:5: -> ^( IF_ expr then2 ( elseif )* ( else2 )? )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:98:8: ^( IF_ expr then2 ( elseif )* ( else2 )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());
                        adaptor.addChild(root_1, stream_then2.nextTree());
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:98:25: ( elseif )*
                        while ( stream_elseif.hasNext() ) {
                            adaptor.addChild(root_1, stream_elseif.nextTree());

                        }
                        stream_elseif.reset();
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:98:33: ( else2 )?
                        if ( stream_else2.hasNext() ) {
                            adaptor.addChild(root_1, stream_else2.nextTree());

                        }
                        stream_else2.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 34 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:99:5: SET settable ASSIGN expr DLM
                    {
                    SET84=(Token)match(input,SET,FOLLOW_SET_in_stat801); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SET.add(SET84);

                    pushFollow(FOLLOW_settable_in_stat803);
                    settable85=settable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_settable.add(settable85.getTree());
                    ASSIGN86=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat805); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN86);

                    pushFollow(FOLLOW_expr_in_stat807);
                    expr87=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr87.getTree());
                    DLM88=(Token)match(input,DLM,FOLLOW_DLM_in_stat809); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM88);



                    // AST REWRITE
                    // elements: SET, settable, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 100:5: -> ^( SET settable expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:100:8: ^( SET settable expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_SET.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_settable.nextTree());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 35 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:101:5: DLM expr DLM
                    {
                    DLM89=(Token)match(input,DLM,FOLLOW_DLM_in_stat830); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM89);

                    pushFollow(FOLLOW_expr_in_stat832);
                    expr90=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr90.getTree());
                    DLM91=(Token)match(input,DLM,FOLLOW_DLM_in_stat834); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM91);



                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 102:5: -> ^( SUB expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:102:8: ^( SUB expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUB, "SUB"), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 36 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:103:5: ITERATE ID DLM ( stat )+ ENDITERATE
                    {
                    ITERATE92=(Token)match(input,ITERATE,FOLLOW_ITERATE_in_stat853); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ITERATE.add(ITERATE92);

                    ID93=(Token)match(input,ID,FOLLOW_ID_in_stat855); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID93);

                    DLM94=(Token)match(input,DLM,FOLLOW_DLM_in_stat857); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM94);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:103:20: ( stat )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==OUT||LA6_0==TYPES_MODE||(LA6_0>=TYPEDEF && LA6_0<=IF_)||(LA6_0>=SET && LA6_0<=REM)||(LA6_0>=STR && LA6_0<=DLM)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: stat
                    	    {
                    	    pushFollow(FOLLOW_stat_in_stat859);
                    	    stat95=stat();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_stat.add(stat95.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    ENDITERATE96=(Token)match(input,ENDITERATE,FOLLOW_ENDITERATE_in_stat862); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENDITERATE.add(ENDITERATE96);



                    // AST REWRITE
                    // elements: ID, ITERATE, stat
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 104:5: -> ^( ITERATE ^( ID ( stat )+ ) )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:104:8: ^( ITERATE ^( ID ( stat )+ ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_ITERATE.nextNode(), root_1);

                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:104:18: ^( ID ( stat )+ )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(stream_ID.nextNode(), root_2);

                        if ( !(stream_stat.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_stat.hasNext() ) {
                            adaptor.addChild(root_2, stream_stat.nextTree());

                        }
                        stream_stat.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 37 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:105:5: LOOP expr DLM ( stat )+ ENDLOOP
                    {
                    LOOP97=(Token)match(input,LOOP,FOLLOW_LOOP_in_stat886); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LOOP.add(LOOP97);

                    pushFollow(FOLLOW_expr_in_stat888);
                    expr98=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr98.getTree());
                    DLM99=(Token)match(input,DLM,FOLLOW_DLM_in_stat890); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM99);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:105:19: ( stat )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==OUT||LA7_0==TYPES_MODE||(LA7_0>=TYPEDEF && LA7_0<=IF_)||(LA7_0>=SET && LA7_0<=REM)||(LA7_0>=STR && LA7_0<=DLM)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: stat
                    	    {
                    	    pushFollow(FOLLOW_stat_in_stat892);
                    	    stat100=stat();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_stat.add(stat100.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    ENDLOOP101=(Token)match(input,ENDLOOP,FOLLOW_ENDLOOP_in_stat895); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENDLOOP.add(ENDLOOP101);



                    // AST REWRITE
                    // elements: expr, LOOP, stat
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 106:5: -> ^( LOOP expr ^( SUB ( stat )+ ) )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:106:8: ^( LOOP expr ^( SUB ( stat )+ ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_LOOP.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:106:20: ^( SUB ( stat )+ )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUB, "SUB"), root_2);

                        if ( !(stream_stat.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_stat.hasNext() ) {
                            adaptor.addChild(root_2, stream_stat.nextTree());

                        }
                        stream_stat.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, stat_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "stat"

    public static class then2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "then2"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:108:1: then2 : DLM ( stat )+ -> ^( THEN ( stat )+ ) ;
    public final PtmParser.then2_return then2() throws RecognitionException {
        PtmParser.then2_return retval = new PtmParser.then2_return();
        retval.start = input.LT(1);
        int then2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DLM102=null;
        PtmParser.stat_return stat103 = null;


        CommonTree DLM102_tree=null;
        RewriteRuleTokenStream stream_DLM=new RewriteRuleTokenStream(adaptor,"token DLM");
        RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:108:7: ( DLM ( stat )+ -> ^( THEN ( stat )+ ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:109:3: DLM ( stat )+
            {
            DLM102=(Token)match(input,DLM,FOLLOW_DLM_in_then2925); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DLM.add(DLM102);

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:109:7: ( stat )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==OUT||LA9_0==TYPES_MODE||(LA9_0>=TYPEDEF && LA9_0<=IF_)||(LA9_0>=SET && LA9_0<=REM)||(LA9_0>=STR && LA9_0<=DLM)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_then2927);
            	    stat103=stat();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stat.add(stat103.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);



            // AST REWRITE
            // elements: stat
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 110:5: -> ^( THEN ( stat )+ )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:110:8: ^( THEN ( stat )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(THEN, "THEN"), root_1);

                if ( !(stream_stat.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_stat.hasNext() ) {
                    adaptor.addChild(root_1, stream_stat.nextTree());

                }
                stream_stat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, then2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "then2"

    public static class else2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "else2"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:112:1: else2 : ELSE_ ( stat )+ -> ^( ELSE_ ( stat )+ ) ;
    public final PtmParser.else2_return else2() throws RecognitionException {
        PtmParser.else2_return retval = new PtmParser.else2_return();
        retval.start = input.LT(1);
        int else2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ELSE_104=null;
        PtmParser.stat_return stat105 = null;


        CommonTree ELSE_104_tree=null;
        RewriteRuleTokenStream stream_ELSE_=new RewriteRuleTokenStream(adaptor,"token ELSE_");
        RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:112:7: ( ELSE_ ( stat )+ -> ^( ELSE_ ( stat )+ ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:113:3: ELSE_ ( stat )+
            {
            ELSE_104=(Token)match(input,ELSE_,FOLLOW_ELSE__in_else2952); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ELSE_.add(ELSE_104);

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:113:9: ( stat )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==OUT||LA10_0==TYPES_MODE||(LA10_0>=TYPEDEF && LA10_0<=IF_)||(LA10_0>=SET && LA10_0<=REM)||(LA10_0>=STR && LA10_0<=DLM)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_else2954);
            	    stat105=stat();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stat.add(stat105.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);



            // AST REWRITE
            // elements: stat, ELSE_
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 114:5: -> ^( ELSE_ ( stat )+ )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:114:8: ^( ELSE_ ( stat )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_ELSE_.nextNode(), root_1);

                if ( !(stream_stat.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_stat.hasNext() ) {
                    adaptor.addChild(root_1, stream_stat.nextTree());

                }
                stream_stat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, else2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "else2"

    public static class elseif_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elseif"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:116:1: elseif : ELSEIF_ expr then2 -> ^( ELSEIF_ expr then2 ) ;
    public final PtmParser.elseif_return elseif() throws RecognitionException {
        PtmParser.elseif_return retval = new PtmParser.elseif_return();
        retval.start = input.LT(1);
        int elseif_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ELSEIF_106=null;
        PtmParser.expr_return expr107 = null;

        PtmParser.then2_return then2108 = null;


        CommonTree ELSEIF_106_tree=null;
        RewriteRuleTokenStream stream_ELSEIF_=new RewriteRuleTokenStream(adaptor,"token ELSEIF_");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_then2=new RewriteRuleSubtreeStream(adaptor,"rule then2");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:116:8: ( ELSEIF_ expr then2 -> ^( ELSEIF_ expr then2 ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:117:3: ELSEIF_ expr then2
            {
            ELSEIF_106=(Token)match(input,ELSEIF_,FOLLOW_ELSEIF__in_elseif979); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ELSEIF_.add(ELSEIF_106);

            pushFollow(FOLLOW_expr_in_elseif981);
            expr107=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr107.getTree());
            pushFollow(FOLLOW_then2_in_elseif983);
            then2108=then2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_then2.add(then2108.getTree());


            // AST REWRITE
            // elements: ELSEIF_, expr, then2
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 118:5: -> ^( ELSEIF_ expr then2 )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:118:8: ^( ELSEIF_ expr then2 )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_ELSEIF_.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());
                adaptor.addChild(root_1, stream_then2.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, elseif_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elseif"

    public static class types_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "types"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:120:1: types : TYPE ( stat )* ( NEWLINE )+ -> ^( TYPE ( stat )* ) ;
    public final PtmParser.types_return types() throws RecognitionException {
        PtmParser.types_return retval = new PtmParser.types_return();
        retval.start = input.LT(1);
        int types_StartIndex = input.index();
        CommonTree root_0 = null;

        Token TYPE109=null;
        Token NEWLINE111=null;
        PtmParser.stat_return stat110 = null;


        CommonTree TYPE109_tree=null;
        CommonTree NEWLINE111_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_TYPE=new RewriteRuleTokenStream(adaptor,"token TYPE");
        RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:120:7: ( TYPE ( stat )* ( NEWLINE )+ -> ^( TYPE ( stat )* ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:121:5: TYPE ( stat )* ( NEWLINE )+
            {
            TYPE109=(Token)match(input,TYPE,FOLLOW_TYPE_in_types1010); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TYPE.add(TYPE109);

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:121:10: ( stat )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==OUT||LA11_0==TYPES_MODE||(LA11_0>=TYPEDEF && LA11_0<=IF_)||(LA11_0>=SET && LA11_0<=REM)||(LA11_0>=STR && LA11_0<=DLM)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_types1012);
            	    stat110=stat();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stat.add(stat110.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:121:16: ( NEWLINE )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==NEWLINE) ) {
                    int LA12_2 = input.LA(2);

                    if ( (synpred47_PtmParser()) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: NEWLINE
            	    {
            	    NEWLINE111=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_types1015); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE111);


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);



            // AST REWRITE
            // elements: stat, TYPE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 122:9: -> ^( TYPE ( stat )* )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:122:12: ^( TYPE ( stat )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_TYPE.nextNode(), root_1);

                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:122:19: ( stat )*
                while ( stream_stat.hasNext() ) {
                    adaptor.addChild(root_1, stream_stat.nextTree());

                }
                stream_stat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, types_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "types"

    public static class types2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "types2"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:123:1: types2 : ( types | REM );
    public final PtmParser.types2_return types2() throws RecognitionException {
        PtmParser.types2_return retval = new PtmParser.types2_return();
        retval.start = input.LT(1);
        int types2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token REM113=null;
        PtmParser.types_return types112 = null;


        CommonTree REM113_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:123:8: ( types | REM )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==TYPE) ) {
                alt13=1;
            }
            else if ( (LA13_0==REM) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:124:5: types
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_types_in_types21045);
                    types112=types();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, types112.getTree());

                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:124:13: REM
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    REM113=(Token)match(input,REM,FOLLOW_REM_in_types21049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    REM113_tree = (CommonTree)adaptor.create(REM113);
                    adaptor.addChild(root_0, REM113_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, types2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "types2"

    public static class settable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "settable"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:126:1: settable : ( ID ( array )* -> ^( ATTRIBUTE ID ( array )* ) | ID DOT ID ( array )* -> ^( ATTRIBUTE2 ID ID ( array )* ) | HASH ID ( array )* -> ^( VARIABLE ID ( array )* ) | ID HASH ID ( array )* -> ^( VARIABLE2 ID ID ( array )* ) );
    public final PtmParser.settable_return settable() throws RecognitionException {
        PtmParser.settable_return retval = new PtmParser.settable_return();
        retval.start = input.LT(1);
        int settable_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ID114=null;
        Token ID116=null;
        Token DOT117=null;
        Token ID118=null;
        Token HASH120=null;
        Token ID121=null;
        Token ID123=null;
        Token HASH124=null;
        Token ID125=null;
        PtmParser.array_return array115 = null;

        PtmParser.array_return array119 = null;

        PtmParser.array_return array122 = null;

        PtmParser.array_return array126 = null;


        CommonTree ID114_tree=null;
        CommonTree ID116_tree=null;
        CommonTree DOT117_tree=null;
        CommonTree ID118_tree=null;
        CommonTree HASH120_tree=null;
        CommonTree ID121_tree=null;
        CommonTree ID123_tree=null;
        CommonTree HASH124_tree=null;
        CommonTree ID125_tree=null;
        RewriteRuleTokenStream stream_HASH=new RewriteRuleTokenStream(adaptor,"token HASH");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_array=new RewriteRuleSubtreeStream(adaptor,"rule array");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:126:10: ( ID ( array )* -> ^( ATTRIBUTE ID ( array )* ) | ID DOT ID ( array )* -> ^( ATTRIBUTE2 ID ID ( array )* ) | HASH ID ( array )* -> ^( VARIABLE ID ( array )* ) | ID HASH ID ( array )* -> ^( VARIABLE2 ID ID ( array )* ) )
            int alt18=4;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ID) ) {
                switch ( input.LA(2) ) {
                case DOT:
                    {
                    alt18=2;
                    }
                    break;
                case HASH:
                    {
                    alt18=4;
                    }
                    break;
                case EOF:
                case MINUS:
                case DLM:
                case COLON:
                case SLASH:
                case RPARAN:
                case LSQUARE:
                case RSQUARE:
                case APPEND:
                case LT:
                case GT:
                case LE:
                case GE:
                case EQUAL:
                case ASSIGN:
                case NE:
                case AND:
                case OR:
                case PLUS:
                case MULTIPLY:
                case TILDE:
                case HAT:
                case QUESTION:
                    {
                    alt18=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA18_0==HASH) ) {
                alt18=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:127:3: ID ( array )*
                    {
                    ID114=(Token)match(input,ID,FOLLOW_ID_in_settable1059); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID114);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:127:6: ( array )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==LSQUARE) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: array
                    	    {
                    	    pushFollow(FOLLOW_array_in_settable1061);
                    	    array115=array();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_array.add(array115.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: ID, array
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 128:9: -> ^( ATTRIBUTE ID ( array )* )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:128:12: ^( ATTRIBUTE ID ( array )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:128:27: ( array )*
                        while ( stream_array.hasNext() ) {
                            adaptor.addChild(root_1, stream_array.nextTree());

                        }
                        stream_array.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:129:7: ID DOT ID ( array )*
                    {
                    ID116=(Token)match(input,ID,FOLLOW_ID_in_settable1090); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID116);

                    DOT117=(Token)match(input,DOT,FOLLOW_DOT_in_settable1092); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT117);

                    ID118=(Token)match(input,ID,FOLLOW_ID_in_settable1094); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID118);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:129:17: ( array )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==LSQUARE) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: array
                    	    {
                    	    pushFollow(FOLLOW_array_in_settable1096);
                    	    array119=array();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_array.add(array119.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: ID, ID, array
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 130:9: -> ^( ATTRIBUTE2 ID ID ( array )* )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:130:12: ^( ATTRIBUTE2 ID ID ( array )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATTRIBUTE2, "ATTRIBUTE2"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_ID.nextNode());
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:130:31: ( array )*
                        while ( stream_array.hasNext() ) {
                            adaptor.addChild(root_1, stream_array.nextTree());

                        }
                        stream_array.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:131:7: HASH ID ( array )*
                    {
                    HASH120=(Token)match(input,HASH,FOLLOW_HASH_in_settable1127); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HASH.add(HASH120);

                    ID121=(Token)match(input,ID,FOLLOW_ID_in_settable1129); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID121);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:131:15: ( array )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==LSQUARE) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: array
                    	    {
                    	    pushFollow(FOLLOW_array_in_settable1131);
                    	    array122=array();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_array.add(array122.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: ID, array
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 132:5: -> ^( VARIABLE ID ( array )* )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:132:8: ^( VARIABLE ID ( array )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VARIABLE, "VARIABLE"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:132:22: ( array )*
                        while ( stream_array.hasNext() ) {
                            adaptor.addChild(root_1, stream_array.nextTree());

                        }
                        stream_array.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:133:5: ID HASH ID ( array )*
                    {
                    ID123=(Token)match(input,ID,FOLLOW_ID_in_settable1154); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID123);

                    HASH124=(Token)match(input,HASH,FOLLOW_HASH_in_settable1156); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HASH.add(HASH124);

                    ID125=(Token)match(input,ID,FOLLOW_ID_in_settable1158); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID125);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:133:16: ( array )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==LSQUARE) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: array
                    	    {
                    	    pushFollow(FOLLOW_array_in_settable1160);
                    	    array126=array();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_array.add(array126.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: array, ID, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 134:5: -> ^( VARIABLE2 ID ID ( array )* )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:134:8: ^( VARIABLE2 ID ID ( array )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VARIABLE2, "VARIABLE2"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_ID.nextNode());
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:134:26: ( array )*
                        while ( stream_array.hasNext() ) {
                            adaptor.addChild(root_1, stream_array.nextTree());

                        }
                        stream_array.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, settable_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "settable"

    public static class array_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:136:1: array : LSQUARE expr RSQUARE -> ^( ARRAY expr ) ;
    public final PtmParser.array_return array() throws RecognitionException {
        PtmParser.array_return retval = new PtmParser.array_return();
        retval.start = input.LT(1);
        int array_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LSQUARE127=null;
        Token RSQUARE129=null;
        PtmParser.expr_return expr128 = null;


        CommonTree LSQUARE127_tree=null;
        CommonTree RSQUARE129_tree=null;
        RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
        RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:136:6: ( LSQUARE expr RSQUARE -> ^( ARRAY expr ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:137:1: LSQUARE expr RSQUARE
            {
            LSQUARE127=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_array1187); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LSQUARE.add(LSQUARE127);

            pushFollow(FOLLOW_expr_in_array1189);
            expr128=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr128.getTree());
            RSQUARE129=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_array1191); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE129);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 138:6: -> ^( ARRAY expr )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:138:9: ^( ARRAY expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY, "ARRAY"), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, array_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "array"

    public static class readable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "readable"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:140:1: readable : ( settable | RESERVED ID -> ^( RESERVED ID ) | TYPED ID -> ^( TYPED ID ) );
    public final PtmParser.readable_return readable() throws RecognitionException {
        PtmParser.readable_return retval = new PtmParser.readable_return();
        retval.start = input.LT(1);
        int readable_StartIndex = input.index();
        CommonTree root_0 = null;

        Token RESERVED131=null;
        Token ID132=null;
        Token TYPED133=null;
        Token ID134=null;
        PtmParser.settable_return settable130 = null;


        CommonTree RESERVED131_tree=null;
        CommonTree ID132_tree=null;
        CommonTree TYPED133_tree=null;
        CommonTree ID134_tree=null;
        RewriteRuleTokenStream stream_TYPED=new RewriteRuleTokenStream(adaptor,"token TYPED");
        RewriteRuleTokenStream stream_RESERVED=new RewriteRuleTokenStream(adaptor,"token RESERVED");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:140:10: ( settable | RESERVED ID -> ^( RESERVED ID ) | TYPED ID -> ^( TYPED ID ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case ID:
            case HASH:
                {
                alt19=1;
                }
                break;
            case RESERVED:
                {
                alt19=2;
                }
                break;
            case TYPED:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:141:3: settable
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_settable_in_readable1214);
                    settable130=settable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, settable130.getTree());

                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:142:5: RESERVED ID
                    {
                    RESERVED131=(Token)match(input,RESERVED,FOLLOW_RESERVED_in_readable1220); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RESERVED.add(RESERVED131);

                    ID132=(Token)match(input,ID,FOLLOW_ID_in_readable1222); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID132);



                    // AST REWRITE
                    // elements: ID, RESERVED
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 143:5: -> ^( RESERVED ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:143:8: ^( RESERVED ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_RESERVED.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:144:5: TYPED ID
                    {
                    TYPED133=(Token)match(input,TYPED,FOLLOW_TYPED_in_readable1241); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TYPED.add(TYPED133);

                    ID134=(Token)match(input,ID,FOLLOW_ID_in_readable1243); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID134);



                    // AST REWRITE
                    // elements: ID, TYPED
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 145:5: -> ^( TYPED ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:145:8: ^( TYPED ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_TYPED.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, readable_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "readable"

    public static class filepath_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filepath"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:147:1: filepath : ( filepart )+ -> ^( PATH ( filepart )+ ) ;
    public final PtmParser.filepath_return filepath() throws RecognitionException {
        PtmParser.filepath_return retval = new PtmParser.filepath_return();
        retval.start = input.LT(1);
        int filepath_StartIndex = input.index();
        CommonTree root_0 = null;

        PtmParser.filepart_return filepart135 = null;


        RewriteRuleSubtreeStream stream_filepart=new RewriteRuleSubtreeStream(adaptor,"rule filepart");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:147:10: ( ( filepart )+ -> ^( PATH ( filepart )+ ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:148:3: ( filepart )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:148:3: ( filepart )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                switch ( input.LA(1) ) {
                case MINUS:
                case DOT:
                case ID:
                case INT:
                case SLASH:
                    {
                    int LA20_2 = input.LA(2);

                    if ( (synpred58_PtmParser()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case DLM:
                    {
                    int LA20_3 = input.LA(2);

                    if ( (synpred58_PtmParser()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case MACRO:
                    {
                    int LA20_4 = input.LA(2);

                    if ( (synpred58_PtmParser()) ) {
                        alt20=1;
                    }


                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: filepart
            	    {
            	    pushFollow(FOLLOW_filepart_in_filepath1267);
            	    filepart135=filepart();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_filepart.add(filepart135.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);



            // AST REWRITE
            // elements: filepart
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 149:6: -> ^( PATH ( filepart )+ )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:149:9: ^( PATH ( filepart )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PATH, "PATH"), root_1);

                if ( !(stream_filepart.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_filepart.hasNext() ) {
                    adaptor.addChild(root_1, stream_filepart.nextTree());

                }
                stream_filepart.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, filepath_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "filepath"

    public static class filepart_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filepart"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:151:1: filepart : ( ( fileliteral )+ -> ^( LITERAL ( fileliteral )+ ) | DLM readable DLM -> ^( SUB readable ) | MACRO ID DLM -> ^( MACRO ID ) );
    public final PtmParser.filepart_return filepart() throws RecognitionException {
        PtmParser.filepart_return retval = new PtmParser.filepart_return();
        retval.start = input.LT(1);
        int filepart_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DLM137=null;
        Token DLM139=null;
        Token MACRO140=null;
        Token ID141=null;
        Token DLM142=null;
        PtmParser.fileliteral_return fileliteral136 = null;

        PtmParser.readable_return readable138 = null;


        CommonTree DLM137_tree=null;
        CommonTree DLM139_tree=null;
        CommonTree MACRO140_tree=null;
        CommonTree ID141_tree=null;
        CommonTree DLM142_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_DLM=new RewriteRuleTokenStream(adaptor,"token DLM");
        RewriteRuleTokenStream stream_MACRO=new RewriteRuleTokenStream(adaptor,"token MACRO");
        RewriteRuleSubtreeStream stream_readable=new RewriteRuleSubtreeStream(adaptor,"rule readable");
        RewriteRuleSubtreeStream stream_fileliteral=new RewriteRuleSubtreeStream(adaptor,"rule fileliteral");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:151:10: ( ( fileliteral )+ -> ^( LITERAL ( fileliteral )+ ) | DLM readable DLM -> ^( SUB readable ) | MACRO ID DLM -> ^( MACRO ID ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case DOT:
            case ID:
            case INT:
            case SLASH:
                {
                alt22=1;
                }
                break;
            case DLM:
                {
                alt22=2;
                }
                break;
            case MACRO:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:152:3: ( fileliteral )+
                    {
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:152:3: ( fileliteral )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>=MINUS && LA21_0<=DOT)||LA21_0==ID||LA21_0==INT||LA21_0==SLASH) ) {
                            int LA21_2 = input.LA(2);

                            if ( (synpred59_PtmParser()) ) {
                                alt21=1;
                            }


                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:0:0: fileliteral
                    	    {
                    	    pushFollow(FOLLOW_fileliteral_in_filepart1292);
                    	    fileliteral136=fileliteral();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_fileliteral.add(fileliteral136.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);



                    // AST REWRITE
                    // elements: fileliteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 153:7: -> ^( LITERAL ( fileliteral )+ )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:153:10: ^( LITERAL ( fileliteral )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LITERAL, "LITERAL"), root_1);

                        if ( !(stream_fileliteral.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_fileliteral.hasNext() ) {
                            adaptor.addChild(root_1, stream_fileliteral.nextTree());

                        }
                        stream_fileliteral.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:154:7: DLM readable DLM
                    {
                    DLM137=(Token)match(input,DLM,FOLLOW_DLM_in_filepart1316); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM137);

                    pushFollow(FOLLOW_readable_in_filepart1318);
                    readable138=readable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_readable.add(readable138.getTree());
                    DLM139=(Token)match(input,DLM,FOLLOW_DLM_in_filepart1320); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM139);



                    // AST REWRITE
                    // elements: readable
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 155:9: -> ^( SUB readable )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:155:12: ^( SUB readable )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUB, "SUB"), root_1);

                        adaptor.addChild(root_1, stream_readable.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:156:7: MACRO ID DLM
                    {
                    MACRO140=(Token)match(input,MACRO,FOLLOW_MACRO_in_filepart1345); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MACRO.add(MACRO140);

                    ID141=(Token)match(input,ID,FOLLOW_ID_in_filepart1347); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID141);

                    DLM142=(Token)match(input,DLM,FOLLOW_DLM_in_filepart1349); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DLM.add(DLM142);



                    // AST REWRITE
                    // elements: ID, MACRO
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 157:9: -> ^( MACRO ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:157:12: ^( MACRO ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_MACRO.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, filepart_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "filepart"

    public static class fileliteral_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fileliteral"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:159:1: fileliteral : ( ID | INT | MINUS | DOT | SLASH );
    public final PtmParser.fileliteral_return fileliteral() throws RecognitionException {
        PtmParser.fileliteral_return retval = new PtmParser.fileliteral_return();
        retval.start = input.LT(1);
        int fileliteral_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set143=null;

        CommonTree set143_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:159:13: ( ID | INT | MINUS | DOT | SLASH )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set143=(Token)input.LT(1);
            if ( (input.LA(1)>=MINUS && input.LA(1)<=DOT)||input.LA(1)==ID||input.LA(1)==INT||input.LA(1)==SLASH ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set143));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, fileliteral_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "fileliteral"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:166:1: expr : choice ( QUESTION expr COLON expr )* ;
    public final PtmParser.expr_return expr() throws RecognitionException {
        PtmParser.expr_return retval = new PtmParser.expr_return();
        retval.start = input.LT(1);
        int expr_StartIndex = input.index();
        CommonTree root_0 = null;

        Token QUESTION145=null;
        Token COLON147=null;
        PtmParser.choice_return choice144 = null;

        PtmParser.expr_return expr146 = null;

        PtmParser.expr_return expr148 = null;


        CommonTree QUESTION145_tree=null;
        CommonTree COLON147_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:166:6: ( choice ( QUESTION expr COLON expr )* )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:167:3: choice ( QUESTION expr COLON expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_choice_in_expr1420);
            choice144=choice();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, choice144.getTree());
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:167:10: ( QUESTION expr COLON expr )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==QUESTION) ) {
                    int LA23_2 = input.LA(2);

                    if ( (synpred66_PtmParser()) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:167:11: QUESTION expr COLON expr
            	    {
            	    QUESTION145=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_expr1423); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUESTION145_tree = (CommonTree)adaptor.create(QUESTION145);
            	    root_0 = (CommonTree)adaptor.becomeRoot(QUESTION145_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_expr_in_expr1426);
            	    expr146=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr146.getTree());
            	    COLON147=(Token)match(input,COLON,FOLLOW_COLON_in_expr1428); if (state.failed) return retval;
            	    pushFollow(FOLLOW_expr_in_expr1431);
            	    expr148=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr148.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, expr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class choice_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "choice"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:169:1: choice : mult ( op1 mult )* ;
    public final PtmParser.choice_return choice() throws RecognitionException {
        PtmParser.choice_return retval = new PtmParser.choice_return();
        retval.start = input.LT(1);
        int choice_StartIndex = input.index();
        CommonTree root_0 = null;

        PtmParser.mult_return mult149 = null;

        PtmParser.op1_return op1150 = null;

        PtmParser.mult_return mult151 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:169:8: ( mult ( op1 mult )* )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:170:3: mult ( op1 mult )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_mult_in_choice1443);
            mult149=mult();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult149.getTree());
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:170:8: ( op1 mult )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==MINUS||LA24_0==APPEND||(LA24_0>=AND && LA24_0<=PLUS)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:170:9: op1 mult
            	    {
            	    pushFollow(FOLLOW_op1_in_choice1446);
            	    op1150=op1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(op1150.getTree(), root_0);
            	    pushFollow(FOLLOW_mult_in_choice1449);
            	    mult151=mult();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult151.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, choice_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "choice"

    public static class op1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op1"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:172:1: op1 : ( PLUS | MINUS | APPEND | OR | AND );
    public final PtmParser.op1_return op1() throws RecognitionException {
        PtmParser.op1_return retval = new PtmParser.op1_return();
        retval.start = input.LT(1);
        int op1_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set152=null;

        CommonTree set152_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:172:5: ( PLUS | MINUS | APPEND | OR | AND )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set152=(Token)input.LT(1);
            if ( input.LA(1)==MINUS||input.LA(1)==APPEND||(input.LA(1)>=AND && input.LA(1)<=PLUS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set152));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, op1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "op1"

    public static class mult_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mult"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:179:1: mult : not ( op2 not )* ;
    public final PtmParser.mult_return mult() throws RecognitionException {
        PtmParser.mult_return retval = new PtmParser.mult_return();
        retval.start = input.LT(1);
        int mult_StartIndex = input.index();
        CommonTree root_0 = null;

        PtmParser.not_return not153 = null;

        PtmParser.op2_return op2154 = null;

        PtmParser.not_return not155 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:179:6: ( not ( op2 not )* )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:180:3: not ( op2 not )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_not_in_mult1495);
            not153=not();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, not153.getTree());
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:180:7: ( op2 not )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==SLASH||(LA25_0>=LT && LA25_0<=EQUAL)||LA25_0==NE||LA25_0==MULTIPLY||LA25_0==TILDE) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:180:8: op2 not
            	    {
            	    pushFollow(FOLLOW_op2_in_mult1498);
            	    op2154=op2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(op2154.getTree(), root_0);
            	    pushFollow(FOLLOW_not_in_mult1501);
            	    not155=not();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, not155.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, mult_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "mult"

    public static class op2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op2"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:182:1: op2 : ( MULTIPLY | SLASH | TILDE | EQUAL | NE | GT | GE | LT | LE );
    public final PtmParser.op2_return op2() throws RecognitionException {
        PtmParser.op2_return retval = new PtmParser.op2_return();
        retval.start = input.LT(1);
        int op2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set156=null;

        CommonTree set156_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:182:5: ( MULTIPLY | SLASH | TILDE | EQUAL | NE | GT | GE | LT | LE )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set156=(Token)input.LT(1);
            if ( input.LA(1)==SLASH||(input.LA(1)>=LT && input.LA(1)<=EQUAL)||input.LA(1)==NE||input.LA(1)==MULTIPLY||input.LA(1)==TILDE ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set156));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, op2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "op2"

    public static class not_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "not"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:193:1: not : ( NOT pow | pow );
    public final PtmParser.not_return not() throws RecognitionException {
        PtmParser.not_return retval = new PtmParser.not_return();
        retval.start = input.LT(1);
        int not_StartIndex = input.index();
        CommonTree root_0 = null;

        Token NOT157=null;
        PtmParser.pow_return pow158 = null;

        PtmParser.pow_return pow159 = null;


        CommonTree NOT157_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:193:5: ( NOT pow | pow )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==NOT) ) {
                alt26=1;
            }
            else if ( (LA26_0==MINUS||(LA26_0>=RESERVED && LA26_0<=TYPED)||LA26_0==ID||(LA26_0>=INT && LA26_0<=LITERAL)||LA26_0==HASH||LA26_0==LPARAN||LA26_0==PLUS) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:194:3: NOT pow
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NOT157=(Token)match(input,NOT,FOLLOW_NOT_in_not1571); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT157_tree = (CommonTree)adaptor.create(NOT157);
                    root_0 = (CommonTree)adaptor.becomeRoot(NOT157_tree, root_0);
                    }
                    pushFollow(FOLLOW_pow_in_not1574);
                    pow158=pow();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow158.getTree());

                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:195:5: pow
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pow_in_not1580);
                    pow159=pow();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow159.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, not_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "not"

    public static class pow_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pow"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:197:1: pow : atom ( HAT pow )? ;
    public final PtmParser.pow_return pow() throws RecognitionException {
        PtmParser.pow_return retval = new PtmParser.pow_return();
        retval.start = input.LT(1);
        int pow_StartIndex = input.index();
        CommonTree root_0 = null;

        Token HAT161=null;
        PtmParser.atom_return atom160 = null;

        PtmParser.pow_return pow162 = null;


        CommonTree HAT161_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:197:5: ( atom ( HAT pow )? )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:198:3: atom ( HAT pow )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_pow1590);
            atom160=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom160.getTree());
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:198:8: ( HAT pow )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==HAT) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:198:9: HAT pow
                    {
                    HAT161=(Token)match(input,HAT,FOLLOW_HAT_in_pow1593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HAT161_tree = (CommonTree)adaptor.create(HAT161);
                    root_0 = (CommonTree)adaptor.becomeRoot(HAT161_tree, root_0);
                    }
                    pushFollow(FOLLOW_pow_in_pow1596);
                    pow162=pow();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow162.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, pow_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pow"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:200:1: atom : ( ( PLUS | MINUS )? INT | LITERAL | readable | ( LPARAN expr RPARAN ) | function );
    public final PtmParser.atom_return atom() throws RecognitionException {
        PtmParser.atom_return retval = new PtmParser.atom_return();
        retval.start = input.LT(1);
        int atom_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set163=null;
        Token INT164=null;
        Token LITERAL165=null;
        Token LPARAN167=null;
        Token RPARAN169=null;
        PtmParser.readable_return readable166 = null;

        PtmParser.expr_return expr168 = null;

        PtmParser.function_return function170 = null;


        CommonTree set163_tree=null;
        CommonTree INT164_tree=null;
        CommonTree LITERAL165_tree=null;
        CommonTree LPARAN167_tree=null;
        CommonTree RPARAN169_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:200:6: ( ( PLUS | MINUS )? INT | LITERAL | readable | ( LPARAN expr RPARAN ) | function )
            int alt29=5;
            switch ( input.LA(1) ) {
            case MINUS:
            case INT:
            case PLUS:
                {
                alt29=1;
                }
                break;
            case LITERAL:
                {
                alt29=2;
                }
                break;
            case ID:
                {
                int LA29_3 = input.LA(2);

                if ( (LA29_3==EOF||(LA29_3>=MINUS && LA29_3<=DOT)||LA29_3==DLM||LA29_3==COLON||LA29_3==HASH||LA29_3==SLASH||LA29_3==RPARAN||(LA29_3>=LSQUARE && LA29_3<=EQUAL)||(LA29_3>=NE && LA29_3<=MULTIPLY)||(LA29_3>=TILDE && LA29_3<=QUESTION)) ) {
                    alt29=3;
                }
                else if ( (LA29_3==LPARAN) ) {
                    alt29=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 3, input);

                    throw nvae;
                }
                }
                break;
            case RESERVED:
            case TYPED:
            case HASH:
                {
                alt29=3;
                }
                break;
            case LPARAN:
                {
                alt29=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:201:3: ( PLUS | MINUS )? INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:201:3: ( PLUS | MINUS )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==MINUS||LA28_0==PLUS) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:
                            {
                            set163=(Token)input.LT(1);
                            if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set163));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    INT164=(Token)match(input,INT,FOLLOW_INT_in_atom1627); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT164_tree = (CommonTree)adaptor.create(INT164);
                    root_0 = (CommonTree)adaptor.becomeRoot(INT164_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:206:5: LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LITERAL165=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_atom1634); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LITERAL165_tree = (CommonTree)adaptor.create(LITERAL165);
                    adaptor.addChild(root_0, LITERAL165_tree);
                    }

                    }
                    break;
                case 3 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:207:5: readable
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_readable_in_atom1640);
                    readable166=readable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, readable166.getTree());

                    }
                    break;
                case 4 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:208:5: ( LPARAN expr RPARAN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:208:5: ( LPARAN expr RPARAN )
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:208:6: LPARAN expr RPARAN
                    {
                    LPARAN167=(Token)match(input,LPARAN,FOLLOW_LPARAN_in_atom1647); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_atom1650);
                    expr168=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr168.getTree());
                    RPARAN169=(Token)match(input,RPARAN,FOLLOW_RPARAN_in_atom1652); if (state.failed) return retval;

                    }


                    }
                    break;
                case 5 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:209:5: function
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_in_atom1660);
                    function170=function();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function170.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, atom_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class function_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:211:1: function : ID LPARAN expr RPARAN -> ^( FUNCTION ID expr ) ;
    public final PtmParser.function_return function() throws RecognitionException {
        PtmParser.function_return retval = new PtmParser.function_return();
        retval.start = input.LT(1);
        int function_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ID171=null;
        Token LPARAN172=null;
        Token RPARAN174=null;
        PtmParser.expr_return expr173 = null;


        CommonTree ID171_tree=null;
        CommonTree LPARAN172_tree=null;
        CommonTree RPARAN174_tree=null;
        RewriteRuleTokenStream stream_LPARAN=new RewriteRuleTokenStream(adaptor,"token LPARAN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_RPARAN=new RewriteRuleTokenStream(adaptor,"token RPARAN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:211:10: ( ID LPARAN expr RPARAN -> ^( FUNCTION ID expr ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:212:1: ID LPARAN expr RPARAN
            {
            ID171=(Token)match(input,ID,FOLLOW_ID_in_function1670); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID171);

            LPARAN172=(Token)match(input,LPARAN,FOLLOW_LPARAN_in_function1672); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPARAN.add(LPARAN172);

            pushFollow(FOLLOW_expr_in_function1674);
            expr173=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr173.getTree());
            RPARAN174=(Token)match(input,RPARAN,FOLLOW_RPARAN_in_function1676); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPARAN.add(RPARAN174);



            // AST REWRITE
            // elements: expr, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 213:3: -> ^( FUNCTION ID expr )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:213:6: ^( FUNCTION ID expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, function_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function"

    // $ANTLR start synpred34_PtmParser
    public final void synpred34_PtmParser_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:93:5: ( IFCONTEXT ID then2 ENDIF )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:93:5: IFCONTEXT ID then2 ENDIF
        {
        match(input,IFCONTEXT,FOLLOW_IFCONTEXT_in_synpred34_PtmParser705); if (state.failed) return ;
        match(input,ID,FOLLOW_ID_in_synpred34_PtmParser707); if (state.failed) return ;
        pushFollow(FOLLOW_then2_in_synpred34_PtmParser709);
        then2();

        state._fsp--;
        if (state.failed) return ;
        match(input,ENDIF,FOLLOW_ENDIF_in_synpred34_PtmParser711); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_PtmParser

    // $ANTLR start synpred35_PtmParser
    public final void synpred35_PtmParser_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:95:5: ( IFCONTEXT ID then2 else2 ENDIF )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:95:5: IFCONTEXT ID then2 else2 ENDIF
        {
        match(input,IFCONTEXT,FOLLOW_IFCONTEXT_in_synpred35_PtmParser732); if (state.failed) return ;
        match(input,ID,FOLLOW_ID_in_synpred35_PtmParser734); if (state.failed) return ;
        pushFollow(FOLLOW_then2_in_synpred35_PtmParser736);
        then2();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_else2_in_synpred35_PtmParser738);
        else2();

        state._fsp--;
        if (state.failed) return ;
        match(input,ENDIF,FOLLOW_ENDIF_in_synpred35_PtmParser740); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_PtmParser

    // $ANTLR start synpred47_PtmParser
    public final void synpred47_PtmParser_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:121:16: ( NEWLINE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:121:16: NEWLINE
        {
        match(input,NEWLINE,FOLLOW_NEWLINE_in_synpred47_PtmParser1015); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_PtmParser

    // $ANTLR start synpred58_PtmParser
    public final void synpred58_PtmParser_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:148:3: ( filepart )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:148:3: filepart
        {
        pushFollow(FOLLOW_filepart_in_synpred58_PtmParser1267);
        filepart();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_PtmParser

    // $ANTLR start synpred59_PtmParser
    public final void synpred59_PtmParser_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:152:3: ( fileliteral )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:152:3: fileliteral
        {
        pushFollow(FOLLOW_fileliteral_in_synpred59_PtmParser1292);
        fileliteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_PtmParser

    // $ANTLR start synpred66_PtmParser
    public final void synpred66_PtmParser_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:167:11: ( QUESTION expr COLON expr )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmParser.g:167:11: QUESTION expr COLON expr
        {
        match(input,QUESTION,FOLLOW_QUESTION_in_synpred66_PtmParser1423); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred66_PtmParser1426);
        expr();

        state._fsp--;
        if (state.failed) return ;
        match(input,COLON,FOLLOW_COLON_in_synpred66_PtmParser1428); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred66_PtmParser1431);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_PtmParser

    // Delegated rules

    public final boolean synpred35_PtmParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_PtmParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_PtmParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_PtmParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_PtmParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_PtmParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_PtmParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_PtmParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_PtmParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_PtmParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_PtmParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_PtmParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\47\uffff";
    static final String DFA8_eofS =
        "\47\uffff";
    static final String DFA8_minS =
        "\1\4\36\uffff\1\0\7\uffff";
    static final String DFA8_maxS =
        "\1\70\36\uffff\1\0\7\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\1\32\1\33\1\34\1\35\1\36\1\uffff\1\41\1\42\1\43\1\44\1\45\1\37"+
        "\1\40";
    static final String DFA8_specialS =
        "\37\uffff\1\0\7\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\11\uffff\1\2\3\uffff\1\3\1\10\1\11\1\13\1\12\1\14\1\15"+
            "\1\16\1\23\1\17\1\20\1\43\1\44\1\24\1\37\1\40\1\uffff\1\41\1"+
            "\25\1\26\1\27\1\30\1\4\1\6\1\5\1\31\1\32\1\34\1\35\1\36\1\33"+
            "\1\21\4\uffff\1\7\1\22\1\42",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "44:1: stat : ( OUT | TYPES_MODE ( types2 )* ( NEWLINE )? TEMPLATE_MODE -> ^( TYPES_MODE ( types2 )* ) | TYPEDEF types -> ^( TYPEDEF types ) | MACRO ID DLM -> ^( MACRO ID ) | TYPED ID DLM -> ^( TYPED ID ) | RESERVED ID DLM -> ^( RESERVED ID ) | STR ID DLM -> ^( STR ID ) | BREAK | CONTINUE | POPFILE | ENDFILE | LINE | ENDLINE | INDENT | ENDINDENT | ENDCONTEXT | REM | ENDSTR | INDENT2 expr DLM -> ^( INDENT2 expr ) | CONTEXT ID DLM -> ^( CONTEXT ID ) | INFO expr DLM -> ^( INFO expr ) | WARNING expr DLM -> ^( WARNING expr ) | ERROR expr DLM -> ^( ERROR expr ) | DEBUG expr DLM -> ^( DEBUG expr ) | FILE filepath NEWLINE -> ^( FILE filepath ) | NEWFILE filepath NEWLINE -> ^( NEWFILE filepath ) | INCLUDE filepath NEWLINE -> ^( INCLUDE filepath ) | IGNOREFILE filepath NEWLINE -> ^( IGNOREFILE filepath ) | PUSHFILE filepath NEWLINE -> ^( PUSHFILE filepath ) | COPYFILE filepath filepath NEWLINE -> ^( COPYFILE filepath filepath ) | IFCONTEXT ID then2 ENDIF -> ^( IFCONTEXT ID then2 ) | IFCONTEXT ID then2 else2 ENDIF -> ^( IFCONTEXT ID then2 else2 ) | IF_ expr then2 ( elseif )* ( else2 )? ENDIF -> ^( IF_ expr then2 ( elseif )* ( else2 )? ) | SET settable ASSIGN expr DLM -> ^( SET settable expr ) | DLM expr DLM -> ^( SUB expr ) | ITERATE ID DLM ( stat )+ ENDITERATE -> ^( ITERATE ^( ID ( stat )+ ) ) | LOOP expr DLM ( stat )+ ENDLOOP -> ^( LOOP expr ^( SUB ( stat )+ ) ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_31 = input.LA(1);

                         
                        int index8_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_PtmParser()) ) {s = 37;}

                        else if ( (synpred35_PtmParser()) ) {s = 38;}

                         
                        input.seek(index8_31);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_stat_in_prog159 = new BitSet(new long[]{0x01C3FFFBFFFC4012L});
    public static final BitSet FOLLOW_OUT_in_stat193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPES_MODE_in_stat199 = new BitSet(new long[]{0x0002000000028040L});
    public static final BitSet FOLLOW_types2_in_stat201 = new BitSet(new long[]{0x0002000000028040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat204 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_TEMPLATE_MODE_in_stat207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPEDEF_in_stat227 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_types_in_stat229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MACRO_in_stat250 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_stat252 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPED_in_stat279 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_stat281 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RESERVED_in_stat308 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_stat310 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_stat335 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_stat337 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_stat358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_stat364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POPFILE_in_stat370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDFILE_in_stat376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_stat382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDLINE_in_stat388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDENT_in_stat394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDINDENT_in_stat400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDCONTEXT_in_stat406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REM_in_stat412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDSTR_in_stat419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDENT2_in_stat425 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_stat427 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTEXT_in_stat448 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_stat450 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INFO_in_stat471 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_stat473 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WARNING_in_stat494 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_stat496 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ERROR_in_stat517 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_stat519 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUG_in_stat540 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_stat542 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILE_in_stat563 = new BitSet(new long[]{0x0B00010000003000L,0x0000000000000004L});
    public static final BitSet FOLLOW_filepath_in_stat565 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWFILE_in_stat586 = new BitSet(new long[]{0x0B00010000003000L,0x0000000000000004L});
    public static final BitSet FOLLOW_filepath_in_stat588 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_stat609 = new BitSet(new long[]{0x0B00010000003000L,0x0000000000000004L});
    public static final BitSet FOLLOW_filepath_in_stat611 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IGNOREFILE_in_stat632 = new BitSet(new long[]{0x0B00010000003000L,0x0000000000000004L});
    public static final BitSet FOLLOW_filepath_in_stat634 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PUSHFILE_in_stat655 = new BitSet(new long[]{0x0B00010000003000L,0x0000000000000004L});
    public static final BitSet FOLLOW_filepath_in_stat657 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COPYFILE_in_stat678 = new BitSet(new long[]{0x0B00010000003000L,0x0000000000000004L});
    public static final BitSet FOLLOW_filepath_in_stat680 = new BitSet(new long[]{0x0B00010000003000L,0x0000000000000004L});
    public static final BitSet FOLLOW_filepath_in_stat682 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IFCONTEXT_in_stat705 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_stat707 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_then2_in_stat709 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_ENDIF_in_stat711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IFCONTEXT_in_stat732 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_stat734 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_then2_in_stat736 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_else2_in_stat738 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_ENDIF_in_stat740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF__in_stat763 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_stat765 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_then2_in_stat767 = new BitSet(new long[]{0x0018000400000000L});
    public static final BitSet FOLLOW_elseif_in_stat769 = new BitSet(new long[]{0x0018000400000000L});
    public static final BitSet FOLLOW_else2_in_stat772 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_ENDIF_in_stat775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_stat801 = new BitSet(new long[]{0x8200000000000000L});
    public static final BitSet FOLLOW_settable_in_stat803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ASSIGN_in_stat805 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_stat807 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLM_in_stat830 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_stat832 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ITERATE_in_stat853 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_stat855 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat857 = new BitSet(new long[]{0x01E3FFFBFFFC4010L});
    public static final BitSet FOLLOW_stat_in_stat859 = new BitSet(new long[]{0x01E3FFFBFFFC4010L});
    public static final BitSet FOLLOW_ENDITERATE_in_stat862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOOP_in_stat886 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_stat888 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_stat890 = new BitSet(new long[]{0x01C7FFFBFFFC4010L});
    public static final BitSet FOLLOW_stat_in_stat892 = new BitSet(new long[]{0x01C7FFFBFFFC4010L});
    public static final BitSet FOLLOW_ENDLOOP_in_stat895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLM_in_then2925 = new BitSet(new long[]{0x01C3FFFBFFFC4010L});
    public static final BitSet FOLLOW_stat_in_then2927 = new BitSet(new long[]{0x01C3FFFBFFFC4012L});
    public static final BitSet FOLLOW_ELSE__in_else2952 = new BitSet(new long[]{0x01C3FFFBFFFC4010L});
    public static final BitSet FOLLOW_stat_in_else2954 = new BitSet(new long[]{0x01C3FFFBFFFC4012L});
    public static final BitSet FOLLOW_ELSEIF__in_elseif979 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_elseif981 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_then2_in_elseif983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_types1010 = new BitSet(new long[]{0x01C3FFFBFFFC4050L});
    public static final BitSet FOLLOW_stat_in_types1012 = new BitSet(new long[]{0x01C3FFFBFFFC4050L});
    public static final BitSet FOLLOW_NEWLINE_in_types1015 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_types_in_types21045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REM_in_types21049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_settable1059 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_array_in_settable1061 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_settable1090 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_DOT_in_settable1092 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_settable1094 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_array_in_settable1096 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_HASH_in_settable1127 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_settable1129 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_array_in_settable1131 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_settable1154 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_HASH_in_settable1156 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_settable1158 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_array_in_settable1160 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_LSQUARE_in_array1187 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_array1189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RSQUARE_in_array1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_settable_in_readable1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RESERVED_in_readable1220 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_readable1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPED_in_readable1241 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_readable1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filepart_in_filepath1267 = new BitSet(new long[]{0x0B00010000003002L,0x0000000000000004L});
    public static final BitSet FOLLOW_fileliteral_in_filepart1292 = new BitSet(new long[]{0x0A00000000003002L,0x0000000000000004L});
    public static final BitSet FOLLOW_DLM_in_filepart1316 = new BitSet(new long[]{0x8200060000000000L});
    public static final BitSet FOLLOW_readable_in_filepart1318 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_filepart1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MACRO_in_filepart1345 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_filepart1347 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_DLM_in_filepart1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_fileliteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_expr1420 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_QUESTION_in_expr1423 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_expr1426 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_COLON_in_expr1428 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_expr1431 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_mult_in_choice1443 = new BitSet(new long[]{0x0000000000001002L,0x00000000000E0200L});
    public static final BitSet FOLLOW_op1_in_choice1446 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_mult_in_choice1449 = new BitSet(new long[]{0x0000000000001002L,0x00000000000E0200L});
    public static final BitSet FOLLOW_set_in_op10 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_in_mult1495 = new BitSet(new long[]{0x0000000000000002L,0x0000000000517C04L});
    public static final BitSet FOLLOW_op2_in_mult1498 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_not_in_mult1501 = new BitSet(new long[]{0x0000000000000002L,0x0000000000517C04L});
    public static final BitSet FOLLOW_set_in_op20 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_not1571 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_pow_in_not1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pow_in_not1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_pow1590 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_HAT_in_pow1593 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_pow_in_pow1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_atom1608 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_INT_in_atom1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_atom1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readable_in_atom1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPARAN_in_atom1647 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_atom1650 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RPARAN_in_atom1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_atom1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_function1670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPARAN_in_function1672 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_function1674 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RPARAN_in_function1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IFCONTEXT_in_synpred34_PtmParser705 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_synpred34_PtmParser707 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_then2_in_synpred34_PtmParser709 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_ENDIF_in_synpred34_PtmParser711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IFCONTEXT_in_synpred35_PtmParser732 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ID_in_synpred35_PtmParser734 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_then2_in_synpred35_PtmParser736 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_else2_in_synpred35_PtmParser738 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_ENDIF_in_synpred35_PtmParser740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_synpred47_PtmParser1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filepart_in_synpred58_PtmParser1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fileliteral_in_synpred59_PtmParser1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUESTION_in_synpred66_PtmParser1423 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_synpred66_PtmParser1426 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_COLON_in_synpred66_PtmParser1428 = new BitSet(new long[]{0x9A00060000001000L,0x0000000000280008L});
    public static final BitSet FOLLOW_expr_in_synpred66_PtmParser1431 = new BitSet(new long[]{0x0000000000000002L});

}