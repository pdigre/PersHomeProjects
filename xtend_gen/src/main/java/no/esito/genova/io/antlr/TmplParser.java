// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g 2012-02-05 10:53:22

package no.esito.genova.io.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class TmplParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "OUT", "REM", "COMMENT", "SECTION", "BEGIN", "CREATESECTION", "IF_", "WS", "NEWLINE", "ENDIF", "EVENT", "BOOL_START", "BOOL_END", "ALFA", "DOLLAR", "LETTER", "UNDER", "ID", "DIGIT", "INT", "DOT", "MINUS", "LITERAL", "COLON", "SEMICOLON", "HASH", "COMMA", "SQUOTE", "SLASH", "LPARAN", "RPARAN", "LBRACK", "RBRACK", "LSQUARE", "RSQUARE", "APPEND", "LT", "GT", "LE", "GE", "EQUAL", "ASSIGN", "NE", "AND", "OR", "PLUS", "MULTIPLY", "NOT", "TILDE", "HAT", "QUESTION", "EXPR", "PATH", "OPTIONAL", "BLOCK", "PROG", "SECTIONS", "HEADER"
    };
    public static final int DOLLAR=18;
    public static final int APPEND=39;
    public static final int LT=40;
    public static final int LBRACK=35;
    public static final int LSQUARE=37;
    public static final int LETTER=19;
    public static final int NOT=51;
    public static final int ALFA=17;
    public static final int ID=21;
    public static final int AND=47;
    public static final int EOF=-1;
    public static final int HAT=53;
    public static final int PROG=59;
    public static final int UNDER=20;
    public static final int EXPR=55;
    public static final int SLASH=32;
    public static final int MULTIPLY=50;
    public static final int PATH=56;
    public static final int COMMA=30;
    public static final int EQUAL=44;
    public static final int BEGIN=8;
    public static final int TILDE=52;
    public static final int RPARAN=34;
    public static final int ENDIF=13;
    public static final int PLUS=49;
    public static final int DIGIT=22;
    public static final int HEADER=61;
    public static final int COMMENT=6;
    public static final int DOT=24;
    public static final int NE=46;
    public static final int RBRACK=36;
    public static final int GE=43;
    public static final int SECTION=7;
    public static final int BOOL_END=16;
    public static final int CREATESECTION=9;
    public static final int HASH=29;
    public static final int LITERAL=26;
    public static final int INT=23;
    public static final int SEMICOLON=28;
    public static final int REM=5;
    public static final int MINUS=25;
    public static final int SQUOTE=31;
    public static final int RSQUARE=38;
    public static final int EVENT=14;
    public static final int OPTIONAL=57;
    public static final int COLON=27;
    public static final int LPARAN=33;
    public static final int WS=11;
    public static final int NEWLINE=12;
    public static final int QUESTION=54;
    public static final int OUT=4;
    public static final int IF_=10;
    public static final int BLOCK=58;
    public static final int OR=48;
    public static final int SECTIONS=60;
    public static final int ASSIGN=45;
    public static final int GT=41;
    public static final int BOOL_START=15;
    public static final int LE=42;

    // delegates
    // delegators


        public TmplParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TmplParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[69+1];
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return TmplParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g"; }





    public static class prog_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prog"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:33:1: prog : block sections -> ^( PROG block sections ) ;
    public final TmplParser.prog_return prog() throws RecognitionException {
        TmplParser.prog_return retval = new TmplParser.prog_return();
        retval.start = input.LT(1);
        int prog_StartIndex = input.index();
        CommonTree root_0 = null;

        TmplParser.block_return block1 = null;

        TmplParser.sections_return sections2 = null;


        RewriteRuleSubtreeStream stream_sections=new RewriteRuleSubtreeStream(adaptor,"rule sections");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:34:3: ( block sections -> ^( PROG block sections ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:35:3: block sections
            {
            pushFollow(FOLLOW_block_in_prog150);
            block1=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block1.getTree());
            pushFollow(FOLLOW_sections_in_prog152);
            sections2=sections();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sections.add(sections2.getTree());


            // AST REWRITE
            // elements: sections, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 36:5: -> ^( PROG block sections )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:37:7: ^( PROG block sections )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROG, "PROG"), root_1);

                adaptor.addChild(root_1, stream_block.nextTree());
                adaptor.addChild(root_1, stream_sections.nextTree());

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

    public static class sections_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sections"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:40:1: sections : ( section )* -> ^( SECTIONS ( section )* ) ;
    public final TmplParser.sections_return sections() throws RecognitionException {
        TmplParser.sections_return retval = new TmplParser.sections_return();
        retval.start = input.LT(1);
        int sections_StartIndex = input.index();
        CommonTree root_0 = null;

        TmplParser.section_return section3 = null;


        RewriteRuleSubtreeStream stream_section=new RewriteRuleSubtreeStream(adaptor,"rule section");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:41:3: ( ( section )* -> ^( SECTIONS ( section )* ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:42:3: ( section )*
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:42:3: ( section )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==SECTION) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: section
            	    {
            	    pushFollow(FOLLOW_section_in_sections187);
            	    section3=section();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_section.add(section3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: section
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 43:5: -> ^( SECTIONS ( section )* )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:44:7: ^( SECTIONS ( section )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SECTIONS, "SECTIONS"), root_1);

                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:44:18: ( section )*
                while ( stream_section.hasNext() ) {
                    adaptor.addChild(root_1, stream_section.nextTree());

                }
                stream_section.reset();

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
            if ( state.backtracking>0 ) { memoize(input, 2, sections_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "sections"

    public static class section_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "section"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:47:1: section : SECTION ( WS )+ filepath filepath2 ( WS )* NEWLINE block -> ^( SECTION filepath filepath2 block ) ;
    public final TmplParser.section_return section() throws RecognitionException {
        TmplParser.section_return retval = new TmplParser.section_return();
        retval.start = input.LT(1);
        int section_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SECTION4=null;
        Token WS5=null;
        Token WS8=null;
        Token NEWLINE9=null;
        TmplParser.filepath_return filepath6 = null;

        TmplParser.filepath2_return filepath27 = null;

        TmplParser.block_return block10 = null;


        CommonTree SECTION4_tree=null;
        CommonTree WS5_tree=null;
        CommonTree WS8_tree=null;
        CommonTree NEWLINE9_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_SECTION=new RewriteRuleTokenStream(adaptor,"token SECTION");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        RewriteRuleSubtreeStream stream_filepath2=new RewriteRuleSubtreeStream(adaptor,"rule filepath2");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:48:3: ( SECTION ( WS )+ filepath filepath2 ( WS )* NEWLINE block -> ^( SECTION filepath filepath2 block ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:49:3: SECTION ( WS )+ filepath filepath2 ( WS )* NEWLINE block
            {
            SECTION4=(Token)match(input,SECTION,FOLLOW_SECTION_in_section222); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SECTION.add(SECTION4);

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:49:11: ( WS )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==WS) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
            	    {
            	    WS5=(Token)match(input,WS,FOLLOW_WS_in_section224); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_WS.add(WS5);


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            pushFollow(FOLLOW_filepath_in_section227);
            filepath6=filepath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath.add(filepath6.getTree());
            pushFollow(FOLLOW_filepath2_in_section229);
            filepath27=filepath2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath2.add(filepath27.getTree());
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:49:34: ( WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
            	    {
            	    WS8=(Token)match(input,WS,FOLLOW_WS_in_section231); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_WS.add(WS8);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_section234); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE9);

            pushFollow(FOLLOW_block_in_section236);
            block10=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block10.getTree());


            // AST REWRITE
            // elements: filepath, filepath2, block, SECTION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 50:5: -> ^( SECTION filepath filepath2 block )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:51:7: ^( SECTION filepath filepath2 block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_SECTION.nextNode(), root_1);

                adaptor.addChild(root_1, stream_filepath.nextTree());
                adaptor.addChild(root_1, stream_filepath2.nextTree());
                adaptor.addChild(root_1, stream_block.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 3, section_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "section"

    public static class filepath2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filepath2"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:54:1: filepath2 : ( ( WS )+ filepath )? -> ^( OPTIONAL ( filepath )? ) ;
    public final TmplParser.filepath2_return filepath2() throws RecognitionException {
        TmplParser.filepath2_return retval = new TmplParser.filepath2_return();
        retval.start = input.LT(1);
        int filepath2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token WS11=null;
        TmplParser.filepath_return filepath12 = null;


        CommonTree WS11_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:55:3: ( ( ( WS )+ filepath )? -> ^( OPTIONAL ( filepath )? ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:56:3: ( ( WS )+ filepath )?
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:56:3: ( ( WS )+ filepath )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:56:4: ( WS )+ filepath
                    {
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:56:4: ( WS )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==WS) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
                    	    {
                    	    WS11=(Token)match(input,WS,FOLLOW_WS_in_filepath2274); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_WS.add(WS11);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    pushFollow(FOLLOW_filepath_in_filepath2277);
                    filepath12=filepath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath.add(filepath12.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: filepath
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 57:5: -> ^( OPTIONAL ( filepath )? )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:58:7: ^( OPTIONAL ( filepath )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);

                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:58:18: ( filepath )?
                if ( stream_filepath.hasNext() ) {
                    adaptor.addChild(root_1, stream_filepath.nextTree());

                }
                stream_filepath.reset();

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
            if ( state.backtracking>0 ) { memoize(input, 4, filepath2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "filepath2"

    public static class stat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stat"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:61:1: stat : ( OUT | BEGIN ( WS )* NEWLINE | CREATESECTION ( WS )+ filepath filepath2 ( WS )* NEWLINE -> ^( CREATESECTION filepath filepath2 ) | REM | COMMENT | IF_ ( WS )+ BOOL_START expr BOOL_END NEWLINE block ENDIF -> ^( IF_ expr block ) | EVENT ( WS )+ expr ( WS )* NEWLINE -> ^( EVENT expr ) | DOLLAR expr DOLLAR -> ^( DOLLAR expr ) | ALFA ID ALFA -> ^( ALFA ID ) | BOOL_START expr BOOL_END -> ^( BOOL_START expr ) );
    public final TmplParser.stat_return stat() throws RecognitionException {
        TmplParser.stat_return retval = new TmplParser.stat_return();
        retval.start = input.LT(1);
        int stat_StartIndex = input.index();
        CommonTree root_0 = null;

        Token OUT13=null;
        Token BEGIN14=null;
        Token WS15=null;
        Token NEWLINE16=null;
        Token CREATESECTION17=null;
        Token WS18=null;
        Token WS21=null;
        Token NEWLINE22=null;
        Token REM23=null;
        Token COMMENT24=null;
        Token IF_25=null;
        Token WS26=null;
        Token BOOL_START27=null;
        Token BOOL_END29=null;
        Token NEWLINE30=null;
        Token ENDIF32=null;
        Token EVENT33=null;
        Token WS34=null;
        Token WS36=null;
        Token NEWLINE37=null;
        Token DOLLAR38=null;
        Token DOLLAR40=null;
        Token ALFA41=null;
        Token ID42=null;
        Token ALFA43=null;
        Token BOOL_START44=null;
        Token BOOL_END46=null;
        TmplParser.filepath_return filepath19 = null;

        TmplParser.filepath2_return filepath220 = null;

        TmplParser.expr_return expr28 = null;

        TmplParser.block_return block31 = null;

        TmplParser.expr_return expr35 = null;

        TmplParser.expr_return expr39 = null;

        TmplParser.expr_return expr45 = null;


        CommonTree OUT13_tree=null;
        CommonTree BEGIN14_tree=null;
        CommonTree WS15_tree=null;
        CommonTree NEWLINE16_tree=null;
        CommonTree CREATESECTION17_tree=null;
        CommonTree WS18_tree=null;
        CommonTree WS21_tree=null;
        CommonTree NEWLINE22_tree=null;
        CommonTree REM23_tree=null;
        CommonTree COMMENT24_tree=null;
        CommonTree IF_25_tree=null;
        CommonTree WS26_tree=null;
        CommonTree BOOL_START27_tree=null;
        CommonTree BOOL_END29_tree=null;
        CommonTree NEWLINE30_tree=null;
        CommonTree ENDIF32_tree=null;
        CommonTree EVENT33_tree=null;
        CommonTree WS34_tree=null;
        CommonTree WS36_tree=null;
        CommonTree NEWLINE37_tree=null;
        CommonTree DOLLAR38_tree=null;
        CommonTree DOLLAR40_tree=null;
        CommonTree ALFA41_tree=null;
        CommonTree ID42_tree=null;
        CommonTree ALFA43_tree=null;
        CommonTree BOOL_START44_tree=null;
        CommonTree BOOL_END46_tree=null;
        RewriteRuleTokenStream stream_DOLLAR=new RewriteRuleTokenStream(adaptor,"token DOLLAR");
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_BOOL_START=new RewriteRuleTokenStream(adaptor,"token BOOL_START");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ALFA=new RewriteRuleTokenStream(adaptor,"token ALFA");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_EVENT=new RewriteRuleTokenStream(adaptor,"token EVENT");
        RewriteRuleTokenStream stream_BOOL_END=new RewriteRuleTokenStream(adaptor,"token BOOL_END");
        RewriteRuleTokenStream stream_IF_=new RewriteRuleTokenStream(adaptor,"token IF_");
        RewriteRuleTokenStream stream_CREATESECTION=new RewriteRuleTokenStream(adaptor,"token CREATESECTION");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        RewriteRuleSubtreeStream stream_filepath2=new RewriteRuleSubtreeStream(adaptor,"rule filepath2");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:62:3: ( OUT | BEGIN ( WS )* NEWLINE | CREATESECTION ( WS )+ filepath filepath2 ( WS )* NEWLINE -> ^( CREATESECTION filepath filepath2 ) | REM | COMMENT | IF_ ( WS )+ BOOL_START expr BOOL_END NEWLINE block ENDIF -> ^( IF_ expr block ) | EVENT ( WS )+ expr ( WS )* NEWLINE -> ^( EVENT expr ) | DOLLAR expr DOLLAR -> ^( DOLLAR expr ) | ALFA ID ALFA -> ^( ALFA ID ) | BOOL_START expr BOOL_END -> ^( BOOL_START expr ) )
            int alt12=10;
            switch ( input.LA(1) ) {
            case OUT:
                {
                alt12=1;
                }
                break;
            case BEGIN:
                {
                alt12=2;
                }
                break;
            case CREATESECTION:
                {
                alt12=3;
                }
                break;
            case REM:
                {
                alt12=4;
                }
                break;
            case COMMENT:
                {
                alt12=5;
                }
                break;
            case IF_:
                {
                alt12=6;
                }
                break;
            case EVENT:
                {
                alt12=7;
                }
                break;
            case DOLLAR:
                {
                alt12=8;
                }
                break;
            case ALFA:
                {
                alt12=9;
                }
                break;
            case BOOL_START:
                {
                alt12=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:63:3: OUT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    OUT13=(Token)match(input,OUT,FOLLOW_OUT_in_stat313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUT13_tree = (CommonTree)adaptor.create(OUT13);
                    adaptor.addChild(root_0, OUT13_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:64:5: BEGIN ( WS )* NEWLINE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    BEGIN14=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_stat319); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BEGIN14_tree = (CommonTree)adaptor.create(BEGIN14);
                    adaptor.addChild(root_0, BEGIN14_tree);
                    }
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:64:11: ( WS )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==WS) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
                    	    {
                    	    WS15=(Token)match(input,WS,FOLLOW_WS_in_stat321); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    WS15_tree = (CommonTree)adaptor.create(WS15);
                    	    adaptor.addChild(root_0, WS15_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    NEWLINE16=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEWLINE16_tree = (CommonTree)adaptor.create(NEWLINE16);
                    adaptor.addChild(root_0, NEWLINE16_tree);
                    }

                    }
                    break;
                case 3 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:65:5: CREATESECTION ( WS )+ filepath filepath2 ( WS )* NEWLINE
                    {
                    CREATESECTION17=(Token)match(input,CREATESECTION,FOLLOW_CREATESECTION_in_stat330); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATESECTION.add(CREATESECTION17);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:65:19: ( WS )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==WS) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
                    	    {
                    	    WS18=(Token)match(input,WS,FOLLOW_WS_in_stat332); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_WS.add(WS18);


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

                    pushFollow(FOLLOW_filepath_in_stat335);
                    filepath19=filepath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath.add(filepath19.getTree());
                    pushFollow(FOLLOW_filepath2_in_stat337);
                    filepath220=filepath2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filepath2.add(filepath220.getTree());
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:65:42: ( WS )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==WS) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
                    	    {
                    	    WS21=(Token)match(input,WS,FOLLOW_WS_in_stat339); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_WS.add(WS21);


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    NEWLINE22=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat342); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE22);



                    // AST REWRITE
                    // elements: filepath2, filepath, CREATESECTION
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 66:5: -> ^( CREATESECTION filepath filepath2 )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:67:7: ^( CREATESECTION filepath filepath2 )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_CREATESECTION.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_filepath.nextTree());
                        adaptor.addChild(root_1, stream_filepath2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:68:5: REM
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    REM23=(Token)match(input,REM,FOLLOW_REM_in_stat368); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    REM23_tree = (CommonTree)adaptor.create(REM23);
                    adaptor.addChild(root_0, REM23_tree);
                    }

                    }
                    break;
                case 5 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:69:5: COMMENT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    COMMENT24=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_stat374); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMENT24_tree = (CommonTree)adaptor.create(COMMENT24);
                    adaptor.addChild(root_0, COMMENT24_tree);
                    }

                    }
                    break;
                case 6 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:70:5: IF_ ( WS )+ BOOL_START expr BOOL_END NEWLINE block ENDIF
                    {
                    IF_25=(Token)match(input,IF_,FOLLOW_IF__in_stat380); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IF_.add(IF_25);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:70:9: ( WS )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==WS) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
                    	    {
                    	    WS26=(Token)match(input,WS,FOLLOW_WS_in_stat382); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_WS.add(WS26);


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

                    BOOL_START27=(Token)match(input,BOOL_START,FOLLOW_BOOL_START_in_stat385); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BOOL_START.add(BOOL_START27);

                    pushFollow(FOLLOW_expr_in_stat387);
                    expr28=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr28.getTree());
                    BOOL_END29=(Token)match(input,BOOL_END,FOLLOW_BOOL_END_in_stat389); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BOOL_END.add(BOOL_END29);

                    NEWLINE30=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat391); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE30);

                    pushFollow(FOLLOW_block_in_stat393);
                    block31=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block.add(block31.getTree());
                    ENDIF32=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat395); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ENDIF.add(ENDIF32);



                    // AST REWRITE
                    // elements: IF_, block, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 71:5: -> ^( IF_ expr block )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:72:7: ^( IF_ expr block )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());
                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:73:5: EVENT ( WS )+ expr ( WS )* NEWLINE
                    {
                    EVENT33=(Token)match(input,EVENT,FOLLOW_EVENT_in_stat421); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EVENT.add(EVENT33);

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:73:11: ( WS )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==WS) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
                    	    {
                    	    WS34=(Token)match(input,WS,FOLLOW_WS_in_stat423); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_WS.add(WS34);


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

                    pushFollow(FOLLOW_expr_in_stat426);
                    expr35=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr35.getTree());
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:73:20: ( WS )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==WS) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
                    	    {
                    	    WS36=(Token)match(input,WS,FOLLOW_WS_in_stat428); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_WS.add(WS36);


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    NEWLINE37=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat431); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE37);



                    // AST REWRITE
                    // elements: EVENT, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 74:5: -> ^( EVENT expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:75:7: ^( EVENT expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_EVENT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:76:5: DOLLAR expr DOLLAR
                    {
                    DOLLAR38=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_stat455); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOLLAR.add(DOLLAR38);

                    pushFollow(FOLLOW_expr_in_stat457);
                    expr39=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr39.getTree());
                    DOLLAR40=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_stat459); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOLLAR.add(DOLLAR40);



                    // AST REWRITE
                    // elements: DOLLAR, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 77:5: -> ^( DOLLAR expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:78:7: ^( DOLLAR expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_DOLLAR.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:79:5: ALFA ID ALFA
                    {
                    ALFA41=(Token)match(input,ALFA,FOLLOW_ALFA_in_stat483); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ALFA.add(ALFA41);

                    ID42=(Token)match(input,ID,FOLLOW_ID_in_stat485); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID42);

                    ALFA43=(Token)match(input,ALFA,FOLLOW_ALFA_in_stat487); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ALFA.add(ALFA43);



                    // AST REWRITE
                    // elements: ID, ALFA
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 80:5: -> ^( ALFA ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:81:7: ^( ALFA ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_ALFA.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:82:5: BOOL_START expr BOOL_END
                    {
                    BOOL_START44=(Token)match(input,BOOL_START,FOLLOW_BOOL_START_in_stat511); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BOOL_START.add(BOOL_START44);

                    pushFollow(FOLLOW_expr_in_stat513);
                    expr45=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr45.getTree());
                    BOOL_END46=(Token)match(input,BOOL_END,FOLLOW_BOOL_END_in_stat515); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BOOL_END.add(BOOL_END46);



                    // AST REWRITE
                    // elements: BOOL_START, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 83:5: -> ^( BOOL_START expr )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:84:7: ^( BOOL_START expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BOOL_START.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 5, stat_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "stat"

    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:87:1: block : ( stat )* -> ^( BLOCK ( stat )* ) ;
    public final TmplParser.block_return block() throws RecognitionException {
        TmplParser.block_return retval = new TmplParser.block_return();
        retval.start = input.LT(1);
        int block_StartIndex = input.index();
        CommonTree root_0 = null;

        TmplParser.stat_return stat47 = null;


        RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:88:3: ( ( stat )* -> ^( BLOCK ( stat )* ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:89:3: ( stat )*
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:89:3: ( stat )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=OUT && LA13_0<=COMMENT)||(LA13_0>=BEGIN && LA13_0<=IF_)||(LA13_0>=EVENT && LA13_0<=BOOL_START)||(LA13_0>=ALFA && LA13_0<=DOLLAR)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:89:4: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_block549);
            	    stat47=stat();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stat.add(stat47.getTree());
            	    if ( state.backtracking==0 ) {

            	               //         System.out.println((stat47!=null?((CommonTree)stat47.tree):null).toStringTree());
            	              
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
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
            // 93:5: -> ^( BLOCK ( stat )* )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:94:7: ^( BLOCK ( stat )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:94:15: ( stat )*
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
            if ( state.backtracking>0 ) { memoize(input, 6, block_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class filepath_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filepath"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:97:1: filepath : ( filepart )+ -> ^( PATH ( filepart )+ ) ;
    public final TmplParser.filepath_return filepath() throws RecognitionException {
        TmplParser.filepath_return retval = new TmplParser.filepath_return();
        retval.start = input.LT(1);
        int filepath_StartIndex = input.index();
        CommonTree root_0 = null;

        TmplParser.filepart_return filepart48 = null;


        RewriteRuleSubtreeStream stream_filepart=new RewriteRuleSubtreeStream(adaptor,"rule filepart");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:98:3: ( ( filepart )+ -> ^( PATH ( filepart )+ ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:99:3: ( filepart )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:99:3: ( filepart )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==ALFA||LA14_0==ID||(LA14_0>=INT && LA14_0<=MINUS)||LA14_0==SLASH) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: filepart
            	    {
            	    pushFollow(FOLLOW_filepart_in_filepath596);
            	    filepart48=filepart();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_filepart.add(filepart48.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
            // 100:5: -> ^( PATH ( filepart )+ )
            {
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:101:7: ^( PATH ( filepart )+ )
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
            if ( state.backtracking>0 ) { memoize(input, 7, filepath_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "filepath"

    public static class filepart_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filepart"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:104:1: filepart : ( ID | INT | MINUS | DOT | SLASH | ALFA ID ALFA -> ^( ALFA ID ) );
    public final TmplParser.filepart_return filepart() throws RecognitionException {
        TmplParser.filepart_return retval = new TmplParser.filepart_return();
        retval.start = input.LT(1);
        int filepart_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ID49=null;
        Token INT50=null;
        Token MINUS51=null;
        Token DOT52=null;
        Token SLASH53=null;
        Token ALFA54=null;
        Token ID55=null;
        Token ALFA56=null;

        CommonTree ID49_tree=null;
        CommonTree INT50_tree=null;
        CommonTree MINUS51_tree=null;
        CommonTree DOT52_tree=null;
        CommonTree SLASH53_tree=null;
        CommonTree ALFA54_tree=null;
        CommonTree ID55_tree=null;
        CommonTree ALFA56_tree=null;
        RewriteRuleTokenStream stream_ALFA=new RewriteRuleTokenStream(adaptor,"token ALFA");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:105:3: ( ID | INT | MINUS | DOT | SLASH | ALFA ID ALFA -> ^( ALFA ID ) )
            int alt15=6;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt15=1;
                }
                break;
            case INT:
                {
                alt15=2;
                }
                break;
            case MINUS:
                {
                alt15=3;
                }
                break;
            case DOT:
                {
                alt15=4;
                }
                break;
            case SLASH:
                {
                alt15=5;
                }
                break;
            case ALFA:
                {
                alt15=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:106:3: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID49=(Token)match(input,ID,FOLLOW_ID_in_filepart631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID49_tree = (CommonTree)adaptor.create(ID49);
                    adaptor.addChild(root_0, ID49_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:107:5: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    INT50=(Token)match(input,INT,FOLLOW_INT_in_filepart637); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT50_tree = (CommonTree)adaptor.create(INT50);
                    adaptor.addChild(root_0, INT50_tree);
                    }

                    }
                    break;
                case 3 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:108:5: MINUS
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    MINUS51=(Token)match(input,MINUS,FOLLOW_MINUS_in_filepart643); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS51_tree = (CommonTree)adaptor.create(MINUS51);
                    adaptor.addChild(root_0, MINUS51_tree);
                    }

                    }
                    break;
                case 4 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:109:5: DOT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DOT52=(Token)match(input,DOT,FOLLOW_DOT_in_filepart649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOT52_tree = (CommonTree)adaptor.create(DOT52);
                    adaptor.addChild(root_0, DOT52_tree);
                    }

                    }
                    break;
                case 5 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:110:5: SLASH
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SLASH53=(Token)match(input,SLASH,FOLLOW_SLASH_in_filepart655); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SLASH53_tree = (CommonTree)adaptor.create(SLASH53);
                    adaptor.addChild(root_0, SLASH53_tree);
                    }

                    }
                    break;
                case 6 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:111:5: ALFA ID ALFA
                    {
                    ALFA54=(Token)match(input,ALFA,FOLLOW_ALFA_in_filepart661); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ALFA.add(ALFA54);

                    ID55=(Token)match(input,ID,FOLLOW_ID_in_filepart663); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID55);

                    ALFA56=(Token)match(input,ALFA,FOLLOW_ALFA_in_filepart665); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ALFA.add(ALFA56);



                    // AST REWRITE
                    // elements: ALFA, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 112:5: -> ^( ALFA ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:113:7: ^( ALFA ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_ALFA.nextNode(), root_1);

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
            if ( state.backtracking>0 ) { memoize(input, 8, filepart_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "filepart"

    public static class readable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "readable"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:116:1: readable : ( ID ( ( WS )+ ID )? | ALFA ID ALFA -> ^( ALFA ID ) );
    public final TmplParser.readable_return readable() throws RecognitionException {
        TmplParser.readable_return retval = new TmplParser.readable_return();
        retval.start = input.LT(1);
        int readable_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ID57=null;
        Token WS58=null;
        Token ID59=null;
        Token ALFA60=null;
        Token ID61=null;
        Token ALFA62=null;

        CommonTree ID57_tree=null;
        CommonTree WS58_tree=null;
        CommonTree ID59_tree=null;
        CommonTree ALFA60_tree=null;
        CommonTree ID61_tree=null;
        CommonTree ALFA62_tree=null;
        RewriteRuleTokenStream stream_ALFA=new RewriteRuleTokenStream(adaptor,"token ALFA");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:117:3: ( ID ( ( WS )+ ID )? | ALFA ID ALFA -> ^( ALFA ID ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ID) ) {
                alt18=1;
            }
            else if ( (LA18_0==ALFA) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:118:3: ID ( ( WS )+ ID )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID57=(Token)match(input,ID,FOLLOW_ID_in_readable698); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID57_tree = (CommonTree)adaptor.create(ID57);
                    adaptor.addChild(root_0, ID57_tree);
                    }
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:118:6: ( ( WS )+ ID )?
                    int alt17=2;
                    alt17 = dfa17.predict(input);
                    switch (alt17) {
                        case 1 :
                            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:118:7: ( WS )+ ID
                            {
                            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:118:7: ( WS )+
                            int cnt16=0;
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==WS) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:0:0: WS
                            	    {
                            	    WS58=(Token)match(input,WS,FOLLOW_WS_in_readable701); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    WS58_tree = (CommonTree)adaptor.create(WS58);
                            	    adaptor.addChild(root_0, WS58_tree);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt16 >= 1 ) break loop16;
                            	    if (state.backtracking>0) {state.failed=true; return retval;}
                                        EarlyExitException eee =
                                            new EarlyExitException(16, input);
                                        throw eee;
                                }
                                cnt16++;
                            } while (true);

                            ID59=(Token)match(input,ID,FOLLOW_ID_in_readable704); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ID59_tree = (CommonTree)adaptor.create(ID59);
                            adaptor.addChild(root_0, ID59_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:119:5: ALFA ID ALFA
                    {
                    ALFA60=(Token)match(input,ALFA,FOLLOW_ALFA_in_readable712); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ALFA.add(ALFA60);

                    ID61=(Token)match(input,ID,FOLLOW_ID_in_readable714); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID61);

                    ALFA62=(Token)match(input,ALFA,FOLLOW_ALFA_in_readable716); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ALFA.add(ALFA62);



                    // AST REWRITE
                    // elements: ID, ALFA
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 120:5: -> ^( ALFA ID )
                    {
                        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:121:7: ^( ALFA ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_ALFA.nextNode(), root_1);

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
            if ( state.backtracking>0 ) { memoize(input, 9, readable_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "readable"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:124:1: expr : choice ( QUESTION expr COLON expr )* ;
    public final TmplParser.expr_return expr() throws RecognitionException {
        TmplParser.expr_return retval = new TmplParser.expr_return();
        retval.start = input.LT(1);
        int expr_StartIndex = input.index();
        CommonTree root_0 = null;

        Token QUESTION64=null;
        Token COLON66=null;
        TmplParser.choice_return choice63 = null;

        TmplParser.expr_return expr65 = null;

        TmplParser.expr_return expr67 = null;


        CommonTree QUESTION64_tree=null;
        CommonTree COLON66_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:125:3: ( choice ( QUESTION expr COLON expr )* )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:126:3: choice ( QUESTION expr COLON expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_choice_in_expr749);
            choice63=choice();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, choice63.getTree());
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:126:10: ( QUESTION expr COLON expr )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==QUESTION) ) {
                    int LA19_2 = input.LA(2);

                    if ( (synpred31_TmplParser()) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:126:11: QUESTION expr COLON expr
            	    {
            	    QUESTION64=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_expr752); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUESTION64_tree = (CommonTree)adaptor.create(QUESTION64);
            	    root_0 = (CommonTree)adaptor.becomeRoot(QUESTION64_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_expr_in_expr755);
            	    expr65=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr65.getTree());
            	    COLON66=(Token)match(input,COLON,FOLLOW_COLON_in_expr757); if (state.failed) return retval;
            	    pushFollow(FOLLOW_expr_in_expr760);
            	    expr67=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr67.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
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
            if ( state.backtracking>0 ) { memoize(input, 10, expr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class choice_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "choice"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:129:1: choice : mult ( op1 mult )* ;
    public final TmplParser.choice_return choice() throws RecognitionException {
        TmplParser.choice_return retval = new TmplParser.choice_return();
        retval.start = input.LT(1);
        int choice_StartIndex = input.index();
        CommonTree root_0 = null;

        TmplParser.mult_return mult68 = null;

        TmplParser.op1_return op169 = null;

        TmplParser.mult_return mult70 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:130:3: ( mult ( op1 mult )* )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:131:3: mult ( op1 mult )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_mult_in_choice777);
            mult68=mult();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult68.getTree());
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:131:8: ( op1 mult )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==MINUS||LA20_0==APPEND||(LA20_0>=AND && LA20_0<=PLUS)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:131:9: op1 mult
            	    {
            	    pushFollow(FOLLOW_op1_in_choice780);
            	    op169=op1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(op169.getTree(), root_0);
            	    pushFollow(FOLLOW_mult_in_choice783);
            	    mult70=mult();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult70.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
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
            if ( state.backtracking>0 ) { memoize(input, 11, choice_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "choice"

    public static class op1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op1"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:134:1: op1 : ( PLUS | MINUS | APPEND | OR | AND );
    public final TmplParser.op1_return op1() throws RecognitionException {
        TmplParser.op1_return retval = new TmplParser.op1_return();
        retval.start = input.LT(1);
        int op1_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set71=null;

        CommonTree set71_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:135:3: ( PLUS | MINUS | APPEND | OR | AND )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set71=(Token)input.LT(1);
            if ( input.LA(1)==MINUS||input.LA(1)==APPEND||(input.LA(1)>=AND && input.LA(1)<=PLUS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set71));
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
            if ( state.backtracking>0 ) { memoize(input, 12, op1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "op1"

    public static class mult_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mult"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:143:1: mult : not ( op2 not )* ;
    public final TmplParser.mult_return mult() throws RecognitionException {
        TmplParser.mult_return retval = new TmplParser.mult_return();
        retval.start = input.LT(1);
        int mult_StartIndex = input.index();
        CommonTree root_0 = null;

        TmplParser.not_return not72 = null;

        TmplParser.op2_return op273 = null;

        TmplParser.not_return not74 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:144:3: ( not ( op2 not )* )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:145:3: not ( op2 not )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_not_in_mult839);
            not72=not();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, not72.getTree());
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:145:7: ( op2 not )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==SLASH||(LA21_0>=LT && LA21_0<=EQUAL)||LA21_0==NE||LA21_0==MULTIPLY||LA21_0==TILDE) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:145:8: op2 not
            	    {
            	    pushFollow(FOLLOW_op2_in_mult842);
            	    op273=op2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(op273.getTree(), root_0);
            	    pushFollow(FOLLOW_not_in_mult845);
            	    not74=not();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, not74.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
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
            if ( state.backtracking>0 ) { memoize(input, 13, mult_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "mult"

    public static class op2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op2"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:148:1: op2 : ( MULTIPLY | SLASH | TILDE | EQUAL | NE | GT | GE | LT | LE );
    public final TmplParser.op2_return op2() throws RecognitionException {
        TmplParser.op2_return retval = new TmplParser.op2_return();
        retval.start = input.LT(1);
        int op2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set75=null;

        CommonTree set75_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:149:3: ( MULTIPLY | SLASH | TILDE | EQUAL | NE | GT | GE | LT | LE )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set75=(Token)input.LT(1);
            if ( input.LA(1)==SLASH||(input.LA(1)>=LT && input.LA(1)<=EQUAL)||input.LA(1)==NE||input.LA(1)==MULTIPLY||input.LA(1)==TILDE ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set75));
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
            if ( state.backtracking>0 ) { memoize(input, 14, op2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "op2"

    public static class not_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "not"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:161:1: not : ( NOT pow | pow );
    public final TmplParser.not_return not() throws RecognitionException {
        TmplParser.not_return retval = new TmplParser.not_return();
        retval.start = input.LT(1);
        int not_StartIndex = input.index();
        CommonTree root_0 = null;

        Token NOT76=null;
        TmplParser.pow_return pow77 = null;

        TmplParser.pow_return pow78 = null;


        CommonTree NOT76_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:162:3: ( NOT pow | pow )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NOT) ) {
                alt22=1;
            }
            else if ( (LA22_0==ALFA||LA22_0==ID||LA22_0==INT||(LA22_0>=MINUS && LA22_0<=LITERAL)||LA22_0==LPARAN||LA22_0==PLUS) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:163:3: NOT pow
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NOT76=(Token)match(input,NOT,FOLLOW_NOT_in_not925); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT76_tree = (CommonTree)adaptor.create(NOT76);
                    root_0 = (CommonTree)adaptor.becomeRoot(NOT76_tree, root_0);
                    }
                    pushFollow(FOLLOW_pow_in_not928);
                    pow77=pow();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow77.getTree());

                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:164:5: pow
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pow_in_not934);
                    pow78=pow();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow78.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 15, not_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "not"

    public static class pow_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pow"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:167:1: pow : atom ( HAT pow )? ;
    public final TmplParser.pow_return pow() throws RecognitionException {
        TmplParser.pow_return retval = new TmplParser.pow_return();
        retval.start = input.LT(1);
        int pow_StartIndex = input.index();
        CommonTree root_0 = null;

        Token HAT80=null;
        TmplParser.atom_return atom79 = null;

        TmplParser.pow_return pow81 = null;


        CommonTree HAT80_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:168:3: ( atom ( HAT pow )? )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:169:3: atom ( HAT pow )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_pow949);
            atom79=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom79.getTree());
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:169:8: ( HAT pow )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==HAT) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:169:9: HAT pow
                    {
                    HAT80=(Token)match(input,HAT,FOLLOW_HAT_in_pow952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HAT80_tree = (CommonTree)adaptor.create(HAT80);
                    root_0 = (CommonTree)adaptor.becomeRoot(HAT80_tree, root_0);
                    }
                    pushFollow(FOLLOW_pow_in_pow955);
                    pow81=pow();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow81.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 16, pow_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pow"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:172:1: atom : ( ( PLUS | MINUS )? INT | LITERAL | readable | ( LPARAN expr RPARAN ) );
    public final TmplParser.atom_return atom() throws RecognitionException {
        TmplParser.atom_return retval = new TmplParser.atom_return();
        retval.start = input.LT(1);
        int atom_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set82=null;
        Token INT83=null;
        Token LITERAL84=null;
        Token LPARAN86=null;
        Token RPARAN88=null;
        TmplParser.readable_return readable85 = null;

        TmplParser.expr_return expr87 = null;


        CommonTree set82_tree=null;
        CommonTree INT83_tree=null;
        CommonTree LITERAL84_tree=null;
        CommonTree LPARAN86_tree=null;
        CommonTree RPARAN88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:173:3: ( ( PLUS | MINUS )? INT | LITERAL | readable | ( LPARAN expr RPARAN ) )
            int alt25=4;
            switch ( input.LA(1) ) {
            case INT:
            case MINUS:
            case PLUS:
                {
                alt25=1;
                }
                break;
            case LITERAL:
                {
                alt25=2;
                }
                break;
            case ALFA:
            case ID:
                {
                alt25=3;
                }
                break;
            case LPARAN:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:174:3: ( PLUS | MINUS )? INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:174:3: ( PLUS | MINUS )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==MINUS||LA24_0==PLUS) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:
                            {
                            set82=(Token)input.LT(1);
                            if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set82));
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

                    INT83=(Token)match(input,INT,FOLLOW_INT_in_atom995); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT83_tree = (CommonTree)adaptor.create(INT83);
                    root_0 = (CommonTree)adaptor.becomeRoot(INT83_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:179:5: LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LITERAL84=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_atom1002); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LITERAL84_tree = (CommonTree)adaptor.create(LITERAL84);
                    adaptor.addChild(root_0, LITERAL84_tree);
                    }

                    }
                    break;
                case 3 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:180:5: readable
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_readable_in_atom1008);
                    readable85=readable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, readable85.getTree());

                    }
                    break;
                case 4 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:181:5: ( LPARAN expr RPARAN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:181:5: ( LPARAN expr RPARAN )
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:181:6: LPARAN expr RPARAN
                    {
                    LPARAN86=(Token)match(input,LPARAN,FOLLOW_LPARAN_in_atom1015); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_atom1018);
                    expr87=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr87.getTree());
                    RPARAN88=(Token)match(input,RPARAN,FOLLOW_RPARAN_in_atom1020); if (state.failed) return retval;

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
            if ( state.backtracking>0 ) { memoize(input, 17, atom_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "atom"

    // $ANTLR start synpred31_TmplParser
    public final void synpred31_TmplParser_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:126:11: ( QUESTION expr COLON expr )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\TmplParser.g:126:11: QUESTION expr COLON expr
        {
        match(input,QUESTION,FOLLOW_QUESTION_in_synpred31_TmplParser752); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred31_TmplParser755);
        expr();

        state._fsp--;
        if (state.failed) return ;
        match(input,COLON,FOLLOW_COLON_in_synpred31_TmplParser757); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred31_TmplParser760);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_TmplParser

    // Delegated rules

    public final boolean synpred31_TmplParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_TmplParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA5_eotS =
        "\4\uffff";
    static final String DFA5_eofS =
        "\4\uffff";
    static final String DFA5_minS =
        "\2\13\2\uffff";
    static final String DFA5_maxS =
        "\1\14\1\40\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA5_specialS =
        "\4\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2\4\uffff\1\3\3\uffff\1\3\1\uffff\3\3\6\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "56:3: ( ( WS )+ filepath )?";
        }
    }
    static final String DFA17_eotS =
        "\4\uffff";
    static final String DFA17_eofS =
        "\1\2\3\uffff";
    static final String DFA17_minS =
        "\2\13\2\uffff";
    static final String DFA17_maxS =
        "\1\66\1\25\2\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA17_specialS =
        "\4\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\1\2\3\uffff\1\2\1\uffff\1\2\6\uffff\1\2\1\uffff\1\2\4"+
            "\uffff\1\2\1\uffff\1\2\4\uffff\6\2\1\uffff\5\2\1\uffff\3\2",
            "\1\1\1\2\10\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "118:6: ( ( WS )+ ID )?";
        }
    }
 

    public static final BitSet FOLLOW_block_in_prog150 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_sections_in_prog152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_section_in_sections187 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_SECTION_in_section222 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_WS_in_section224 = new BitSet(new long[]{0x0000000103A20800L});
    public static final BitSet FOLLOW_filepath_in_section227 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_filepath2_in_section229 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_WS_in_section231 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_NEWLINE_in_section234 = new BitSet(new long[]{0x000000000006C770L});
    public static final BitSet FOLLOW_block_in_section236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_filepath2274 = new BitSet(new long[]{0x0000000103A20800L});
    public static final BitSet FOLLOW_filepath_in_filepath2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUT_in_stat313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEGIN_in_stat319 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_WS_in_stat321 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_NEWLINE_in_stat324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATESECTION_in_stat330 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_WS_in_stat332 = new BitSet(new long[]{0x0000000103A20800L});
    public static final BitSet FOLLOW_filepath_in_stat335 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_filepath2_in_stat337 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_WS_in_stat339 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_NEWLINE_in_stat342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REM_in_stat368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_stat374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF__in_stat380 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_WS_in_stat382 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_BOOL_START_in_stat385 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_expr_in_stat387 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_BOOL_END_in_stat389 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NEWLINE_in_stat391 = new BitSet(new long[]{0x000000000006E770L});
    public static final BitSet FOLLOW_block_in_stat393 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ENDIF_in_stat395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVENT_in_stat421 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_WS_in_stat423 = new BitSet(new long[]{0x000A000206A20800L});
    public static final BitSet FOLLOW_expr_in_stat426 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_WS_in_stat428 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_NEWLINE_in_stat431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_stat455 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_expr_in_stat457 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_DOLLAR_in_stat459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALFA_in_stat483 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_stat485 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ALFA_in_stat487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_START_in_stat511 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_expr_in_stat513 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_BOOL_END_in_stat515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_block549 = new BitSet(new long[]{0x000000000006C772L});
    public static final BitSet FOLLOW_filepart_in_filepath596 = new BitSet(new long[]{0x0000000103A20002L});
    public static final BitSet FOLLOW_ID_in_filepart631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_filepart637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_filepart643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_filepart649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH_in_filepart655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALFA_in_filepart661 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_filepart663 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ALFA_in_filepart665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readable698 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_WS_in_readable701 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_ID_in_readable704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALFA_in_readable712 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_readable714 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ALFA_in_readable716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_expr749 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_QUESTION_in_expr752 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_expr_in_expr755 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_COLON_in_expr757 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_expr_in_expr760 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_mult_in_choice777 = new BitSet(new long[]{0x0003808002000002L});
    public static final BitSet FOLLOW_op1_in_choice780 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_mult_in_choice783 = new BitSet(new long[]{0x0003808002000002L});
    public static final BitSet FOLLOW_set_in_op10 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_in_mult839 = new BitSet(new long[]{0x00145F0100000002L});
    public static final BitSet FOLLOW_op2_in_mult842 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_not_in_mult845 = new BitSet(new long[]{0x00145F0100000002L});
    public static final BitSet FOLLOW_set_in_op20 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_not925 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_pow_in_not928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pow_in_not934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_pow949 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_HAT_in_pow952 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_pow_in_pow955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_atom972 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_INT_in_atom995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_atom1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readable_in_atom1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPARAN_in_atom1015 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_expr_in_atom1018 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_RPARAN_in_atom1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUESTION_in_synpred31_TmplParser752 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_expr_in_synpred31_TmplParser755 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_COLON_in_synpred31_TmplParser757 = new BitSet(new long[]{0x000A000206A20000L});
    public static final BitSet FOLLOW_expr_in_synpred31_TmplParser760 = new BitSet(new long[]{0x0000000000000002L});

}