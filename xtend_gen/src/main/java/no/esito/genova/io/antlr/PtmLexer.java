// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g 2012-02-04 23:44:58

package no.esito.genova.io.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class PtmLexer extends Lexer {
    public static final int TYPED=42;
    public static final int APPEND=73;
    public static final int IGNOREFILE=45;
    public static final int LT=74;
    public static final int LBRACK=69;
    public static final int LSQUARE=71;
    public static final int LETTER=10;
    public static final int PUSHFILE=46;
    public static final int RESERVED_ID=9;
    public static final int NOT=85;
    public static final int ELSE_=52;
    public static final int AND=81;
    public static final int ID=57;
    public static final int EOF=-1;
    public static final int BREAK=19;
    public static final int INDENT=25;
    public static final int CONTEXT=31;
    public static final int TYPE=17;
    public static final int DEBUG=39;
    public static final int HAT=87;
    public static final int COPYFILE=47;
    public static final int STR=54;
    public static final int ENDCONTEXT=28;
    public static final int UNDER=11;
    public static final int SLASH=66;
    public static final int RESERVED=41;
    public static final int INDENT2=26;
    public static final int MULTIPLY=84;
    public static final int CONTINUE=20;
    public static final int COMMA=64;
    public static final int RESERVATION=7;
    public static final int IFCONTEXT=32;
    public static final int EQUAL=78;
    public static final int INCLUDE=48;
    public static final int ENDINDENT=27;
    public static final int LOOP=30;
    public static final int TILDE=86;
    public static final int RPARAN=68;
    public static final int ENDIF=51;
    public static final int PLUS=83;
    public static final int DIGIT=58;
    public static final int DOT=13;
    public static final int RESERVED_MODE=8;
    public static final int NE=80;
    public static final int RBRACK=70;
    public static final int GE=77;
    public static final int NEWFILE=44;
    public static final int ENDFILE=21;
    public static final int TYPES_MODE=14;
    public static final int POPFILE=22;
    public static final int DLM=56;
    public static final int TYPEDEF=18;
    public static final int ENDSTR=55;
    public static final int HASH=63;
    public static final int LITERAL=60;
    public static final int SET=35;
    public static final int SEMICOLON=62;
    public static final int INT=59;
    public static final int RSQUARE=72;
    public static final int SQUOTE=65;
    public static final int REM=49;
    public static final int MINUS=12;
    public static final int ERROR=38;
    public static final int FILE=43;
    public static final int LINE=23;
    public static final int ENDITERATE=53;
    public static final int INFO=36;
    public static final int COLON=61;
    public static final int ITERATE=29;
    public static final int LPARAN=67;
    public static final int WS=5;
    public static final int QUESTION=88;
    public static final int TEMPLATE_MODE=15;
    public static final int NEWLINE=6;
    public static final int OUT=4;
    public static final int IF_=33;
    public static final int ELSEIF_=34;
    public static final int OR=82;
    public static final int ASSIGN=79;
    public static final int GT=75;
    public static final int ENDLINE=24;
    public static final int TYPE_ID=16;
    public static final int WARNING=37;
    public static final int MACRO=40;
    public static final int LE=76;
    public static final int ENDLOOP=50;

    public PtmLexerSub l;


    // delegates
    // delegators

    public PtmLexer() {;} 
    public PtmLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PtmLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g"; }

    public Token nextToken() {
        while (true) {
            if ( input.LA(1)==CharStream.EOF ) {
                return Token.EOF_TOKEN;
            }
            state.token = null;
    	state.channel = Token.DEFAULT_CHANNEL;
            state.tokenStartCharIndex = input.index();
            state.tokenStartCharPositionInLine = input.getCharPositionInLine();
            state.tokenStartLine = input.getLine();
    	state.text = null;
            try {
                int m = input.mark();
                state.backtracking=1; 
                state.failed=false;
                mTokens();
                state.backtracking=0;

                if ( state.failed ) {
                    input.rewind(m);
                    input.consume(); 
                }
                else {
                    emit();
                    return state.token;
                }
            }
            catch (RecognitionException re) {
                // shouldn't happen in backtracking mode, but...
                reportError(re);
                recover(re);
            }
        }
    }

    public void memoize(IntStream input,
    		int ruleIndex,
    		int ruleStartIndex)
    {
    if ( state.backtracking>1 ) super.memoize(input, ruleIndex, ruleStartIndex);
    }

    public boolean alreadyParsedRule(IntStream input, int ruleIndex) {
    if ( state.backtracking>1 ) return super.alreadyParsedRule(input, ruleIndex);
    return false;
    }// $ANTLR start "RESERVED_MODE"
    public final void mRESERVED_MODE() throws RecognitionException {
        try {
            int _type = RESERVED_MODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:25:15: ({...}? => '@reserved' ( WS )? NEWLINE ( ( RESERVATION )? NEWLINE )+ )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:26:3: {...}? => '@reserved' ( WS )? NEWLINE ( ( RESERVATION )? NEWLINE )+
            {
            if ( !((l.isTag())) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "RESERVED_MODE", "l.isTag()");
            }
            match("@reserved"); if (state.failed) return ;

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:26:30: ( WS )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\t'||LA1_0==' ') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:26:30: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            mNEWLINE(); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                                                        _channel = HIDDEN;
                                                        l.reserved();
                                                       
            }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:31:3: ( ( RESERVATION )? NEWLINE )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\n'||LA3_0=='\r'||(LA3_0>='-' && LA3_0<='.')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:31:4: ( RESERVATION )? NEWLINE
            	    {
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:31:4: ( RESERVATION )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( ((LA2_0>='-' && LA2_0<='.')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:31:4: RESERVATION
            	            {
            	            mRESERVATION(); if (state.failed) return ;

            	            }
            	            break;

            	    }

            	    mNEWLINE(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RESERVED_MODE"

    // $ANTLR start "RESERVATION"
    public final void mRESERVATION() throws RecognitionException {
        try {
            CommonToken RESERVED_ID1=null;

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:33:22: ( RESERVED_ID ( WS )? )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:34:3: RESERVED_ID ( WS )?
            {
            int RESERVED_ID1Start138 = getCharIndex();
            mRESERVED_ID(); if (state.failed) return ;
            RESERVED_ID1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, RESERVED_ID1Start138, getCharIndex()-1);
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:34:15: ( WS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\t'||LA4_0==' ') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:34:15: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==1 ) {

                                 l.addReserved((RESERVED_ID1!=null?RESERVED_ID1.getText():null));
                                
            }

            }

        }
        finally {
        }
    }
    // $ANTLR end "RESERVATION"

    // $ANTLR start "RESERVED_ID"
    public final void mRESERVED_ID() throws RecognitionException {
        try {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:39:22: ( ( LETTER | UNDER | MINUS | DOT )+ )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:40:3: ( LETTER | UNDER | MINUS | DOT )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:40:3: ( LETTER | UNDER | MINUS | DOT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='-' && LA5_0<='.')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RESERVED_ID"

    // $ANTLR start "TYPES_MODE"
    public final void mTYPES_MODE() throws RecognitionException {
        try {
            int _type = TYPES_MODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:47:12: ( '@types' ( WS )? NEWLINE )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:48:3: '@types' ( WS )? NEWLINE
            {
            match("@types"); if (state.failed) return ;

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:48:12: ( WS )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\t'||LA6_0==' ') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:48:12: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            mNEWLINE(); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                                      l.types();
                                     
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPES_MODE"

    // $ANTLR start "TEMPLATE_MODE"
    public final void mTEMPLATE_MODE() throws RecognitionException {
        try {
            int _type = TEMPLATE_MODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:53:15: ( '@template' ( WS )? NEWLINE )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:54:3: '@template' ( WS )? NEWLINE
            {
            match("@template"); if (state.failed) return ;

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:54:15: ( WS )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\t'||LA7_0==' ') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:54:15: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            mNEWLINE(); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                                         l.template();
                                         l.out();
                                        
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEMPLATE_MODE"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken TYPE_ID2=null;

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:60:6: ({...}? => ( TYPE_ID ';' ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:61:3: {...}? => ( TYPE_ID ';' )
            {
            if ( !((l.isTypes())) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "TYPE", "l.isTypes()");
            }
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:61:20: ( TYPE_ID ';' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:61:21: TYPE_ID ';'
            {
            int TYPE_ID2Start300 = getCharIndex();
            mTYPE_ID(); if (state.failed) return ;
            TYPE_ID2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, TYPE_ID2Start300, getCharIndex()-1);
            match(';'); if (state.failed) return ;

            }

            if ( state.backtracking==1 ) {

                                                l.addTypdef((TYPE_ID2!=null?TYPE_ID2.getText():null));
                                               
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "TYPE_ID"
    public final void mTYPE_ID() throws RecognitionException {
        try {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:66:18: ( ( LETTER | UNDER | DOT )+ )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:67:3: ( LETTER | UNDER | DOT )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:67:3: ( LETTER | UNDER | DOT )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='.'||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "TYPE_ID"

    // $ANTLR start "TYPEDEF"
    public final void mTYPEDEF() throws RecognitionException {
        try {
            int _type = TYPEDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:73:9: ( '%TYPEDEF%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:74:3: '%TYPEDEF%'
            {
            match("%TYPEDEF%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                             l.typedef();
                            
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPEDEF"

    // $ANTLR start "BREAK"
    public final void mBREAK() throws RecognitionException {
        try {
            int _type = BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:81:7: ( '%BREAK%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:82:3: '%BREAK%'
            {
            match("%BREAK%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                           l.out();
                          
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BREAK"

    // $ANTLR start "CONTINUE"
    public final void mCONTINUE() throws RecognitionException {
        try {
            int _type = CONTINUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:87:10: ( '%CONTINUE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:88:3: '%CONTINUE%'
            {
            match("%CONTINUE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                              l.out();
                             
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTINUE"

    // $ANTLR start "ENDFILE"
    public final void mENDFILE() throws RecognitionException {
        try {
            int _type = ENDFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:93:9: ( '%ENDFILE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:94:3: '%ENDFILE%'
            {
            match("%ENDFILE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                             l.out();
                            
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDFILE"

    // $ANTLR start "POPFILE"
    public final void mPOPFILE() throws RecognitionException {
        try {
            int _type = POPFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:99:9: ( '%POPFILE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:100:3: '%POPFILE%'
            {
            match("%POPFILE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                             l.out();
                            
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POPFILE"

    // $ANTLR start "LINE"
    public final void mLINE() throws RecognitionException {
        try {
            int _type = LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:105:6: ( '%LINE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:106:3: '%LINE%'
            {
            match("%LINE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                          l.out();
                         
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE"

    // $ANTLR start "ENDLINE"
    public final void mENDLINE() throws RecognitionException {
        try {
            int _type = ENDLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:111:9: ( '%ENDLINE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:112:3: '%ENDLINE%'
            {
            match("%ENDLINE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                             l.out();
                            
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDLINE"

    // $ANTLR start "INDENT"
    public final void mINDENT() throws RecognitionException {
        try {
            int _type = INDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:117:8: ( '%INDENT%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:118:3: '%INDENT%'
            {
            match("%INDENT%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                            l.out();
                           
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INDENT"

    // $ANTLR start "INDENT2"
    public final void mINDENT2() throws RecognitionException {
        try {
            int _type = INDENT2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:123:9: ( '%INDENT:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:124:3: '%INDENT:'
            {
            match("%INDENT:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                            l.expr();
                           
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INDENT2"

    // $ANTLR start "ENDINDENT"
    public final void mENDINDENT() throws RecognitionException {
        try {
            int _type = ENDINDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:129:11: ( '%ENDINDENT%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:130:3: '%ENDINDENT%'
            {
            match("%ENDINDENT%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                               l.out();
                              
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDINDENT"

    // $ANTLR start "ENDCONTEXT"
    public final void mENDCONTEXT() throws RecognitionException {
        try {
            int _type = ENDCONTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:135:12: ( '%ENDCONTEXT%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:136:3: '%ENDCONTEXT%'
            {
            match("%ENDCONTEXT%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                                l.out();
                               
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDCONTEXT"

    // $ANTLR start "ITERATE"
    public final void mITERATE() throws RecognitionException {
        try {
            int _type = ITERATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:143:9: ( '%ITERATE:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:144:3: '%ITERATE:'
            {
            match("%ITERATE:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                             l.expr();
                            
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ITERATE"

    // $ANTLR start "LOOP"
    public final void mLOOP() throws RecognitionException {
        try {
            int _type = LOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:149:6: ( '%LOOP:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:150:3: '%LOOP:'
            {
            match("%LOOP:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                          l.expr();
                         
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOOP"

    // $ANTLR start "CONTEXT"
    public final void mCONTEXT() throws RecognitionException {
        try {
            int _type = CONTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:155:9: ( '%CONTEXT:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:156:3: '%CONTEXT:'
            {
            match("%CONTEXT:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                             l.expr();
                            
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTEXT"

    // $ANTLR start "IFCONTEXT"
    public final void mIFCONTEXT() throws RecognitionException {
        try {
            int _type = IFCONTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:161:11: ( '%IFCONTEXT:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:162:3: '%IFCONTEXT:'
            {
            match("%IFCONTEXT:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                               l.expr();
                              
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IFCONTEXT"

    // $ANTLR start "IF_"
    public final void mIF_() throws RecognitionException {
        try {
            int _type = IF_;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:167:5: ( '%IF:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:168:3: '%IF:'
            {
            match("%IF:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                        l.expr();
                       
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF_"

    // $ANTLR start "ELSEIF_"
    public final void mELSEIF_() throws RecognitionException {
        try {
            int _type = ELSEIF_;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:173:9: ( '%ELSEIF:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:174:3: '%ELSEIF:'
            {
            match("%ELSEIF:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                            l.expr();
                           
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSEIF_"

    // $ANTLR start "SET"
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:179:5: ( '%SET:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:180:3: '%SET:'
            {
            match("%SET:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                         l.expr();
                        
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET"

    // $ANTLR start "INFO"
    public final void mINFO() throws RecognitionException {
        try {
            int _type = INFO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:185:6: ( '%INFO:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:186:3: '%INFO:'
            {
            match("%INFO:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                          l.expr();
                         
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INFO"

    // $ANTLR start "WARNING"
    public final void mWARNING() throws RecognitionException {
        try {
            int _type = WARNING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:191:9: ( '%WARNING:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:192:3: '%WARNING:'
            {
            match("%WARNING:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                             l.expr();
                            
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WARNING"

    // $ANTLR start "ERROR"
    public final void mERROR() throws RecognitionException {
        try {
            int _type = ERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:197:7: ( '%ERROR:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:198:3: '%ERROR:'
            {
            match("%ERROR:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                           l.expr();
                          
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ERROR"

    // $ANTLR start "DEBUG"
    public final void mDEBUG() throws RecognitionException {
        try {
            int _type = DEBUG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:203:7: ( '%DEBUG:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:204:3: '%DEBUG:'
            {
            match("%DEBUG:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                           l.expr();
                          
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUG"

    // $ANTLR start "MACRO"
    public final void mMACRO() throws RecognitionException {
        try {
            int _type = MACRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:209:7: ( '%MACRO:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:210:3: '%MACRO:'
            {
            match("%MACRO:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                           l.id();
                          
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MACRO"

    // $ANTLR start "RESERVED"
    public final void mRESERVED() throws RecognitionException {
        try {
            int _type = RESERVED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:215:10: ( '%ID:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:216:3: '%ID:'
            {
            match("%ID:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                        l.id();
                       
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RESERVED"

    // $ANTLR start "TYPED"
    public final void mTYPED() throws RecognitionException {
        try {
            int _type = TYPED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:221:7: ( '%TYPE:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:222:3: '%TYPE:'
            {
            match("%TYPE:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                          l.id();
                         
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPED"

    // $ANTLR start "FILE"
    public final void mFILE() throws RecognitionException {
        try {
            int _type = FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:227:6: ( '%FILE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:228:3: '%FILE%'
            {
            match("%FILE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                          l.file();
                         
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FILE"

    // $ANTLR start "NEWFILE"
    public final void mNEWFILE() throws RecognitionException {
        try {
            int _type = NEWFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:233:9: ( '%NEWFILE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:234:3: '%NEWFILE%'
            {
            match("%NEWFILE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                             l.file();
                            
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWFILE"

    // $ANTLR start "IGNOREFILE"
    public final void mIGNOREFILE() throws RecognitionException {
        try {
            int _type = IGNOREFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:239:12: ( '%IGNOREFILE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:240:3: '%IGNOREFILE%'
            {
            match("%IGNOREFILE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                                l.file();
                               
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IGNOREFILE"

    // $ANTLR start "PUSHFILE"
    public final void mPUSHFILE() throws RecognitionException {
        try {
            int _type = PUSHFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:245:10: ( '%PUSHFILE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:246:3: '%PUSHFILE%'
            {
            match("%PUSHFILE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                              l.file();
                             
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PUSHFILE"

    // $ANTLR start "COPYFILE"
    public final void mCOPYFILE() throws RecognitionException {
        try {
            int _type = COPYFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:251:10: ( '%COPYFILE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:252:3: '%COPYFILE%'
            {
            match("%COPYFILE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                              l.file();
                             
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COPYFILE"

    // $ANTLR start "INCLUDE"
    public final void mINCLUDE() throws RecognitionException {
        try {
            int _type = INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:257:9: ( '%INCLUDE%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:258:3: '%INCLUDE%'
            {
            match("%INCLUDE%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                             l.file();
                            
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDE"

    // $ANTLR start "REM"
    public final void mREM() throws RecognitionException {
        try {
            int _type = REM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:264:5: ( '%REM' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:265:3: '%REM'
            {
            match("%REM"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                        l.cmt();
                       
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REM"

    // $ANTLR start "ENDLOOP"
    public final void mENDLOOP() throws RecognitionException {
        try {
            int _type = ENDLOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:270:9: ( '%ENDLOOP' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:271:3: '%ENDLOOP'
            {
            match("%ENDLOOP"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                            l.cmt();
                           
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDLOOP"

    // $ANTLR start "ENDIF"
    public final void mENDIF() throws RecognitionException {
        try {
            int _type = ENDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:276:7: ( '%ENDIF' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:277:3: '%ENDIF'
            {
            match("%ENDIF"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                          l.cmt();
                         
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDIF"

    // $ANTLR start "ELSE_"
    public final void mELSE_() throws RecognitionException {
        try {
            int _type = ELSE_;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:282:7: ( '%ELSE' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:283:3: '%ELSE'
            {
            match("%ELSE"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                         l.cmt();
                        
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE_"

    // $ANTLR start "ENDITERATE"
    public final void mENDITERATE() throws RecognitionException {
        try {
            int _type = ENDITERATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:288:12: ( '%ENDITERATE' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:289:3: '%ENDITERATE'
            {
            match("%ENDITERATE"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                               l.cmt();
                              
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDITERATE"

    // $ANTLR start "STR"
    public final void mSTR() throws RecognitionException {
        try {
            int _type = STR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:294:5: ( '%STR:' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:295:3: '%STR:'
            {
            match("%STR:"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                         l.expr();
                        
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STR"

    // $ANTLR start "ENDSTR"
    public final void mENDSTR() throws RecognitionException {
        try {
            int _type = ENDSTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:300:8: ( '%ENDSTR%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:301:3: '%ENDSTR%'
            {
            match("%ENDSTR%"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                            l.out();
                           
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDSTR"

    // $ANTLR start "DLM"
    public final void mDLM() throws RecognitionException {
        try {
            int _type = DLM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:306:5: ( '%' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:307:3: '%'
            {
            match('%'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DLM"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:309:9: ( ( ( '\\r' )? '\\n' ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:310:3: ( ( '\\r' )? '\\n' )
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:310:3: ( ( '\\r' )? '\\n' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:310:4: ( '\\r' )? '\\n'
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:310:4: ( '\\r' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:310:4: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;

            }

            match('\n'); if (state.failed) return ;

            }

            if ( state.backtracking==1 ) {

                              l.newline();
                             
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:315:4: ( ( ' ' | '\\t' )+ )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:316:3: ( ' ' | '\\t' )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:316:3: ( ' ' | '\\t' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            if ( state.backtracking==1 ) {

                  _channel = HIDDEN;
                 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:325:4: ( ( LETTER | UNDER )+ )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:326:3: ( LETTER | UNDER )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:326:3: ( LETTER | UNDER )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:331:5: ( ( DIGIT )+ )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:332:3: ( DIGIT )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:332:3: ( DIGIT )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:332:3: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:334:17: ( 'A' .. 'Z' | 'a' .. 'z' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "UNDER"
    public final void mUNDER() throws RecognitionException {
        try {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:338:16: ( '_' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:339:3: '_'
            {
            match('_'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "UNDER"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:341:5: ( '.' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:342:3: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:344:7: ( '-' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:345:3: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:347:16: ( '0' .. '9' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:348:3: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LITERAL"
    public final void mLITERAL() throws RecognitionException {
        try {
            int _type = LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:350:9: ( '\"' (~ ( '\"' ) )* '\"' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:351:3: '\"' (~ ( '\"' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:351:7: (~ ( '\"' ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:351:7: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match('\"'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LITERAL"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:353:7: ( ':' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:354:3: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:356:11: ( ';' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:357:3: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "HASH"
    public final void mHASH() throws RecognitionException {
        try {
            int _type = HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:359:6: ( '#' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:360:3: '#'
            {
            match('#'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HASH"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:362:7: ( ',' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:363:3: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SQUOTE"
    public final void mSQUOTE() throws RecognitionException {
        try {
            int _type = SQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:365:8: ( '\\'' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:366:3: '\\''
            {
            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQUOTE"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:368:7: ( '/' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:369:3: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "LPARAN"
    public final void mLPARAN() throws RecognitionException {
        try {
            int _type = LPARAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:371:8: ( '(' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:372:3: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPARAN"

    // $ANTLR start "RPARAN"
    public final void mRPARAN() throws RecognitionException {
        try {
            int _type = RPARAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:374:8: ( ')' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:375:3: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPARAN"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:377:8: ( '{' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:378:3: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:380:8: ( '}' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:381:3: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:383:9: ( '[' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:384:3: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LSQUARE"

    // $ANTLR start "RSQUARE"
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:386:9: ( ']' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:387:3: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RSQUARE"

    // $ANTLR start "APPEND"
    public final void mAPPEND() throws RecognitionException {
        try {
            int _type = APPEND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:389:8: ( '++' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:390:3: '++'
            {
            match("++"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "APPEND"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:392:4: ( '<' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:393:3: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:395:4: ( '>' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:396:3: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:398:4: ( '<' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:399:3: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:401:4: ( '>=' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:402:3: '>='
            {
            match(">="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:404:7: ( '==' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:405:3: '=='
            {
            match("=="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:407:8: ( '=' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:408:3: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:410:4: ( '!=' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:411:3: '!='
            {
            match("!="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NE"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:413:5: ( '&' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:414:3: '&'
            {
            match('&'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:416:4: ( '|' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:417:3: '|'
            {
            match('|'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:419:6: ( '+' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:420:3: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MULTIPLY"
    public final void mMULTIPLY() throws RecognitionException {
        try {
            int _type = MULTIPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:422:10: ( '*' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:423:3: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTIPLY"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:425:5: ( '!' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:426:3: '!'
            {
            match('!'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "TILDE"
    public final void mTILDE() throws RecognitionException {
        try {
            int _type = TILDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:428:7: ( '~' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:429:3: '~'
            {
            match('~'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TILDE"

    // $ANTLR start "HAT"
    public final void mHAT() throws RecognitionException {
        try {
            int _type = HAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:431:5: ( '^' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:432:3: '^'
            {
            match('^'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HAT"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:434:10: ( '?' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:435:3: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUESTION"

    public void mTokens() throws RecognitionException {
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:39: ( RESERVED_MODE | TYPES_MODE | TEMPLATE_MODE | TYPE | TYPEDEF | BREAK | CONTINUE | ENDFILE | POPFILE | LINE | ENDLINE | INDENT | INDENT2 | ENDINDENT | ENDCONTEXT | ITERATE | LOOP | CONTEXT | IFCONTEXT | IF_ | ELSEIF_ | SET | INFO | WARNING | ERROR | DEBUG | MACRO | RESERVED | TYPED | FILE | NEWFILE | IGNOREFILE | PUSHFILE | COPYFILE | INCLUDE | REM | ENDLOOP | ENDIF | ELSE_ | ENDITERATE | STR | ENDSTR | DLM | NEWLINE | WS | ID | INT | DOT | MINUS | LITERAL | COLON | SEMICOLON | HASH | COMMA | SQUOTE | SLASH | LPARAN | RPARAN | LBRACK | RBRACK | LSQUARE | RSQUARE | APPEND | LT | GT | LE | GE | EQUAL | ASSIGN | NE | AND | OR | PLUS | MULTIPLY | NOT | TILDE | HAT | QUESTION )
        int alt14=78;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:41: RESERVED_MODE
                {
                mRESERVED_MODE(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:55: TYPES_MODE
                {
                mTYPES_MODE(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:66: TEMPLATE_MODE
                {
                mTEMPLATE_MODE(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:80: TYPE
                {
                mTYPE(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:85: TYPEDEF
                {
                mTYPEDEF(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:93: BREAK
                {
                mBREAK(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:99: CONTINUE
                {
                mCONTINUE(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:108: ENDFILE
                {
                mENDFILE(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:116: POPFILE
                {
                mPOPFILE(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:124: LINE
                {
                mLINE(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:129: ENDLINE
                {
                mENDLINE(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:137: INDENT
                {
                mINDENT(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:144: INDENT2
                {
                mINDENT2(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:152: ENDINDENT
                {
                mENDINDENT(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:162: ENDCONTEXT
                {
                mENDCONTEXT(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:173: ITERATE
                {
                mITERATE(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:181: LOOP
                {
                mLOOP(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:186: CONTEXT
                {
                mCONTEXT(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:194: IFCONTEXT
                {
                mIFCONTEXT(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:204: IF_
                {
                mIF_(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:208: ELSEIF_
                {
                mELSEIF_(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:216: SET
                {
                mSET(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:220: INFO
                {
                mINFO(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:225: WARNING
                {
                mWARNING(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:233: ERROR
                {
                mERROR(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:239: DEBUG
                {
                mDEBUG(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:245: MACRO
                {
                mMACRO(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:251: RESERVED
                {
                mRESERVED(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:260: TYPED
                {
                mTYPED(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:266: FILE
                {
                mFILE(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:271: NEWFILE
                {
                mNEWFILE(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:279: IGNOREFILE
                {
                mIGNOREFILE(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:290: PUSHFILE
                {
                mPUSHFILE(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:299: COPYFILE
                {
                mCOPYFILE(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:308: INCLUDE
                {
                mINCLUDE(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:316: REM
                {
                mREM(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:320: ENDLOOP
                {
                mENDLOOP(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:328: ENDIF
                {
                mENDIF(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:334: ELSE_
                {
                mELSE_(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:340: ENDITERATE
                {
                mENDITERATE(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:351: STR
                {
                mSTR(); if (state.failed) return ;

                }
                break;
            case 42 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:355: ENDSTR
                {
                mENDSTR(); if (state.failed) return ;

                }
                break;
            case 43 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:362: DLM
                {
                mDLM(); if (state.failed) return ;

                }
                break;
            case 44 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:366: NEWLINE
                {
                mNEWLINE(); if (state.failed) return ;

                }
                break;
            case 45 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:374: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 46 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:377: ID
                {
                mID(); if (state.failed) return ;

                }
                break;
            case 47 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:380: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 48 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:384: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 49 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:388: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 50 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:394: LITERAL
                {
                mLITERAL(); if (state.failed) return ;

                }
                break;
            case 51 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:402: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 52 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:408: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 53 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:418: HASH
                {
                mHASH(); if (state.failed) return ;

                }
                break;
            case 54 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:423: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 55 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:429: SQUOTE
                {
                mSQUOTE(); if (state.failed) return ;

                }
                break;
            case 56 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:436: SLASH
                {
                mSLASH(); if (state.failed) return ;

                }
                break;
            case 57 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:442: LPARAN
                {
                mLPARAN(); if (state.failed) return ;

                }
                break;
            case 58 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:449: RPARAN
                {
                mRPARAN(); if (state.failed) return ;

                }
                break;
            case 59 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:456: LBRACK
                {
                mLBRACK(); if (state.failed) return ;

                }
                break;
            case 60 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:463: RBRACK
                {
                mRBRACK(); if (state.failed) return ;

                }
                break;
            case 61 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:470: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 62 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:478: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 63 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:486: APPEND
                {
                mAPPEND(); if (state.failed) return ;

                }
                break;
            case 64 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:493: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 65 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:496: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 66 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:499: LE
                {
                mLE(); if (state.failed) return ;

                }
                break;
            case 67 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:502: GE
                {
                mGE(); if (state.failed) return ;

                }
                break;
            case 68 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:505: EQUAL
                {
                mEQUAL(); if (state.failed) return ;

                }
                break;
            case 69 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:511: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 70 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:518: NE
                {
                mNE(); if (state.failed) return ;

                }
                break;
            case 71 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:521: AND
                {
                mAND(); if (state.failed) return ;

                }
                break;
            case 72 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:525: OR
                {
                mOR(); if (state.failed) return ;

                }
                break;
            case 73 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:528: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 74 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:533: MULTIPLY
                {
                mMULTIPLY(); if (state.failed) return ;

                }
                break;
            case 75 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:542: NOT
                {
                mNOT(); if (state.failed) return ;

                }
                break;
            case 76 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:546: TILDE
                {
                mTILDE(); if (state.failed) return ;

                }
                break;
            case 77 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:552: HAT
                {
                mHAT(); if (state.failed) return ;

                }
                break;
            case 78 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:556: QUESTION
                {
                mQUESTION(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_PtmLexer
    public final void synpred1_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:41: ( RESERVED_MODE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:41: RESERVED_MODE
        {
        mRESERVED_MODE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_PtmLexer

    // $ANTLR start synpred2_PtmLexer
    public final void synpred2_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:55: ( TYPES_MODE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:55: TYPES_MODE
        {
        mTYPES_MODE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_PtmLexer

    // $ANTLR start synpred3_PtmLexer
    public final void synpred3_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:66: ( TEMPLATE_MODE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:66: TEMPLATE_MODE
        {
        mTEMPLATE_MODE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_PtmLexer

    // $ANTLR start synpred4_PtmLexer
    public final void synpred4_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:80: ( TYPE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:80: TYPE
        {
        mTYPE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_PtmLexer

    // $ANTLR start synpred5_PtmLexer
    public final void synpred5_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:85: ( TYPEDEF )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:85: TYPEDEF
        {
        mTYPEDEF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_PtmLexer

    // $ANTLR start synpred6_PtmLexer
    public final void synpred6_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:93: ( BREAK )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:93: BREAK
        {
        mBREAK(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_PtmLexer

    // $ANTLR start synpred7_PtmLexer
    public final void synpred7_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:99: ( CONTINUE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:99: CONTINUE
        {
        mCONTINUE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_PtmLexer

    // $ANTLR start synpred8_PtmLexer
    public final void synpred8_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:108: ( ENDFILE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:108: ENDFILE
        {
        mENDFILE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_PtmLexer

    // $ANTLR start synpred9_PtmLexer
    public final void synpred9_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:116: ( POPFILE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:116: POPFILE
        {
        mPOPFILE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_PtmLexer

    // $ANTLR start synpred10_PtmLexer
    public final void synpred10_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:124: ( LINE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:124: LINE
        {
        mLINE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_PtmLexer

    // $ANTLR start synpred11_PtmLexer
    public final void synpred11_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:129: ( ENDLINE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:129: ENDLINE
        {
        mENDLINE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_PtmLexer

    // $ANTLR start synpred12_PtmLexer
    public final void synpred12_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:137: ( INDENT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:137: INDENT
        {
        mINDENT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_PtmLexer

    // $ANTLR start synpred13_PtmLexer
    public final void synpred13_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:144: ( INDENT2 )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:144: INDENT2
        {
        mINDENT2(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_PtmLexer

    // $ANTLR start synpred14_PtmLexer
    public final void synpred14_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:152: ( ENDINDENT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:152: ENDINDENT
        {
        mENDINDENT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_PtmLexer

    // $ANTLR start synpred15_PtmLexer
    public final void synpred15_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:162: ( ENDCONTEXT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:162: ENDCONTEXT
        {
        mENDCONTEXT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_PtmLexer

    // $ANTLR start synpred16_PtmLexer
    public final void synpred16_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:173: ( ITERATE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:173: ITERATE
        {
        mITERATE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_PtmLexer

    // $ANTLR start synpred17_PtmLexer
    public final void synpred17_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:181: ( LOOP )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:181: LOOP
        {
        mLOOP(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_PtmLexer

    // $ANTLR start synpred18_PtmLexer
    public final void synpred18_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:186: ( CONTEXT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:186: CONTEXT
        {
        mCONTEXT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_PtmLexer

    // $ANTLR start synpred19_PtmLexer
    public final void synpred19_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:194: ( IFCONTEXT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:194: IFCONTEXT
        {
        mIFCONTEXT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_PtmLexer

    // $ANTLR start synpred20_PtmLexer
    public final void synpred20_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:204: ( IF_ )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:204: IF_
        {
        mIF_(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_PtmLexer

    // $ANTLR start synpred21_PtmLexer
    public final void synpred21_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:208: ( ELSEIF_ )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:208: ELSEIF_
        {
        mELSEIF_(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_PtmLexer

    // $ANTLR start synpred22_PtmLexer
    public final void synpred22_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:216: ( SET )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:216: SET
        {
        mSET(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_PtmLexer

    // $ANTLR start synpred23_PtmLexer
    public final void synpred23_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:220: ( INFO )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:220: INFO
        {
        mINFO(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_PtmLexer

    // $ANTLR start synpred24_PtmLexer
    public final void synpred24_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:225: ( WARNING )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:225: WARNING
        {
        mWARNING(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_PtmLexer

    // $ANTLR start synpred25_PtmLexer
    public final void synpred25_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:233: ( ERROR )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:233: ERROR
        {
        mERROR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_PtmLexer

    // $ANTLR start synpred26_PtmLexer
    public final void synpred26_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:239: ( DEBUG )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:239: DEBUG
        {
        mDEBUG(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_PtmLexer

    // $ANTLR start synpred27_PtmLexer
    public final void synpred27_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:245: ( MACRO )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:245: MACRO
        {
        mMACRO(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_PtmLexer

    // $ANTLR start synpred28_PtmLexer
    public final void synpred28_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:251: ( RESERVED )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:251: RESERVED
        {
        mRESERVED(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_PtmLexer

    // $ANTLR start synpred29_PtmLexer
    public final void synpred29_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:260: ( TYPED )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:260: TYPED
        {
        mTYPED(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_PtmLexer

    // $ANTLR start synpred30_PtmLexer
    public final void synpred30_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:266: ( FILE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:266: FILE
        {
        mFILE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_PtmLexer

    // $ANTLR start synpred31_PtmLexer
    public final void synpred31_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:271: ( NEWFILE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:271: NEWFILE
        {
        mNEWFILE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_PtmLexer

    // $ANTLR start synpred32_PtmLexer
    public final void synpred32_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:279: ( IGNOREFILE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:279: IGNOREFILE
        {
        mIGNOREFILE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_PtmLexer

    // $ANTLR start synpred33_PtmLexer
    public final void synpred33_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:290: ( PUSHFILE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:290: PUSHFILE
        {
        mPUSHFILE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_PtmLexer

    // $ANTLR start synpred34_PtmLexer
    public final void synpred34_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:299: ( COPYFILE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:299: COPYFILE
        {
        mCOPYFILE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_PtmLexer

    // $ANTLR start synpred35_PtmLexer
    public final void synpred35_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:308: ( INCLUDE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:308: INCLUDE
        {
        mINCLUDE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_PtmLexer

    // $ANTLR start synpred36_PtmLexer
    public final void synpred36_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:316: ( REM )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:316: REM
        {
        mREM(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_PtmLexer

    // $ANTLR start synpred37_PtmLexer
    public final void synpred37_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:320: ( ENDLOOP )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:320: ENDLOOP
        {
        mENDLOOP(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_PtmLexer

    // $ANTLR start synpred38_PtmLexer
    public final void synpred38_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:328: ( ENDIF )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:328: ENDIF
        {
        mENDIF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_PtmLexer

    // $ANTLR start synpred39_PtmLexer
    public final void synpred39_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:334: ( ELSE_ )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:334: ELSE_
        {
        mELSE_(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_PtmLexer

    // $ANTLR start synpred40_PtmLexer
    public final void synpred40_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:340: ( ENDITERATE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:340: ENDITERATE
        {
        mENDITERATE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_PtmLexer

    // $ANTLR start synpred41_PtmLexer
    public final void synpred41_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:351: ( STR )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:351: STR
        {
        mSTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_PtmLexer

    // $ANTLR start synpred42_PtmLexer
    public final void synpred42_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:355: ( ENDSTR )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:355: ENDSTR
        {
        mENDSTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_PtmLexer

    // $ANTLR start synpred43_PtmLexer
    public final void synpred43_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:362: ( DLM )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:362: DLM
        {
        mDLM(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_PtmLexer

    // $ANTLR start synpred46_PtmLexer
    public final void synpred46_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:377: ( ID )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:377: ID
        {
        mID(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_PtmLexer

    // $ANTLR start synpred48_PtmLexer
    public final void synpred48_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:384: ( DOT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:384: DOT
        {
        mDOT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_PtmLexer

    // $ANTLR start synpred63_PtmLexer
    public final void synpred63_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:486: ( APPEND )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:486: APPEND
        {
        mAPPEND(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred63_PtmLexer

    // $ANTLR start synpred64_PtmLexer
    public final void synpred64_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:493: ( LT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:493: LT
        {
        mLT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_PtmLexer

    // $ANTLR start synpred65_PtmLexer
    public final void synpred65_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:496: ( GT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:496: GT
        {
        mGT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred65_PtmLexer

    // $ANTLR start synpred66_PtmLexer
    public final void synpred66_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:499: ( LE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:499: LE
        {
        mLE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_PtmLexer

    // $ANTLR start synpred67_PtmLexer
    public final void synpred67_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:502: ( GE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:502: GE
        {
        mGE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred67_PtmLexer

    // $ANTLR start synpred68_PtmLexer
    public final void synpred68_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:505: ( EQUAL )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:505: EQUAL
        {
        mEQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred68_PtmLexer

    // $ANTLR start synpred69_PtmLexer
    public final void synpred69_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:511: ( ASSIGN )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:511: ASSIGN
        {
        mASSIGN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred69_PtmLexer

    // $ANTLR start synpred70_PtmLexer
    public final void synpred70_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:518: ( NE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:518: NE
        {
        mNE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred70_PtmLexer

    // $ANTLR start synpred73_PtmLexer
    public final void synpred73_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:528: ( PLUS )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:528: PLUS
        {
        mPLUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred73_PtmLexer

    // $ANTLR start synpred75_PtmLexer
    public final void synpred75_PtmLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:542: ( NOT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\grammar\\PtmLexer.g:1:542: NOT
        {
        mNOT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred75_PtmLexer

    public final boolean synpred13_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred73_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred73_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred75_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_PtmLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_PtmLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\131\uffff";
    static final String DFA14_eofS =
        "\131\uffff";
    static final String DFA14_minS =
        "\1\11\3\0\3\uffff\1\0\17\uffff\5\0\75\uffff";
    static final String DFA14_maxS =
        "\1\176\3\0\3\uffff\1\0\17\uffff\5\0\75\uffff";
    static final String DFA14_acceptS =
        "\4\uffff\1\54\1\uffff\1\55\1\uffff\1\57\1\61\1\62\1\63\1\64\1\65"+
        "\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\5\uffff\1\107\1\110"+
        "\1\112\1\114\1\115\1\116\1\1\1\2\1\3\1\4\1\56\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
        "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\60\1\77\1\111\1"+
        "\100\1\102\1\101\1\103\1\104\1\105\1\106\1\113";
    static final String DFA14_specialS =
        "\1\uffff\1\0\1\1\1\2\3\uffff\1\3\17\uffff\1\4\1\5\1\6\1\7\1\10"+
        "\75\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\6\1\4\2\uffff\1\4\22\uffff\1\6\1\33\1\12\1\15\1\uffff\1"+
            "\3\1\34\1\17\1\21\1\22\1\36\1\27\1\16\1\11\1\7\1\20\12\10\1"+
            "\13\1\14\1\30\1\32\1\31\1\41\1\1\32\2\1\25\1\uffff\1\26\1\40"+
            "\1\2\1\uffff\32\2\1\23\1\35\1\24\1\37",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens options {k=1; backtrack=true; } : ( RESERVED_MODE | TYPES_MODE | TEMPLATE_MODE | TYPE | TYPEDEF | BREAK | CONTINUE | ENDFILE | POPFILE | LINE | ENDLINE | INDENT | INDENT2 | ENDINDENT | ENDCONTEXT | ITERATE | LOOP | CONTEXT | IFCONTEXT | IF_ | ELSEIF_ | SET | INFO | WARNING | ERROR | DEBUG | MACRO | RESERVED | TYPED | FILE | NEWFILE | IGNOREFILE | PUSHFILE | COPYFILE | INCLUDE | REM | ENDLOOP | ENDIF | ELSE_ | ENDITERATE | STR | ENDSTR | DLM | NEWLINE | WS | ID | INT | DOT | MINUS | LITERAL | COLON | SEMICOLON | HASH | COMMA | SQUOTE | SLASH | LPARAN | RPARAN | LBRACK | RBRACK | LSQUARE | RSQUARE | APPEND | LT | GT | LE | GE | EQUAL | ASSIGN | NE | AND | OR | PLUS | MULTIPLY | NOT | TILDE | HAT | QUESTION );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_1 = input.LA(1);

                         
                        int index14_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred1_PtmLexer()&&(l.isTag()))) ) {s = 34;}

                        else if ( (synpred2_PtmLexer()) ) {s = 35;}

                        else if ( (synpred3_PtmLexer()) ) {s = 36;}

                         
                        input.seek(index14_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_2 = input.LA(1);

                         
                        int index14_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred4_PtmLexer()&&(l.isTypes()))) ) {s = 37;}

                        else if ( (synpred46_PtmLexer()) ) {s = 38;}

                         
                        input.seek(index14_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_3 = input.LA(1);

                         
                        int index14_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_PtmLexer()) ) {s = 39;}

                        else if ( (synpred6_PtmLexer()) ) {s = 40;}

                        else if ( (synpred7_PtmLexer()) ) {s = 41;}

                        else if ( (synpred8_PtmLexer()) ) {s = 42;}

                        else if ( (synpred9_PtmLexer()) ) {s = 43;}

                        else if ( (synpred10_PtmLexer()) ) {s = 44;}

                        else if ( (synpred11_PtmLexer()) ) {s = 45;}

                        else if ( (synpred12_PtmLexer()) ) {s = 46;}

                        else if ( (synpred13_PtmLexer()) ) {s = 47;}

                        else if ( (synpred14_PtmLexer()) ) {s = 48;}

                        else if ( (synpred15_PtmLexer()) ) {s = 49;}

                        else if ( (synpred16_PtmLexer()) ) {s = 50;}

                        else if ( (synpred17_PtmLexer()) ) {s = 51;}

                        else if ( (synpred18_PtmLexer()) ) {s = 52;}

                        else if ( (synpred19_PtmLexer()) ) {s = 53;}

                        else if ( (synpred20_PtmLexer()) ) {s = 54;}

                        else if ( (synpred21_PtmLexer()) ) {s = 55;}

                        else if ( (synpred22_PtmLexer()) ) {s = 56;}

                        else if ( (synpred23_PtmLexer()) ) {s = 57;}

                        else if ( (synpred24_PtmLexer()) ) {s = 58;}

                        else if ( (synpred25_PtmLexer()) ) {s = 59;}

                        else if ( (synpred26_PtmLexer()) ) {s = 60;}

                        else if ( (synpred27_PtmLexer()) ) {s = 61;}

                        else if ( (synpred28_PtmLexer()) ) {s = 62;}

                        else if ( (synpred29_PtmLexer()) ) {s = 63;}

                        else if ( (synpred30_PtmLexer()) ) {s = 64;}

                        else if ( (synpred31_PtmLexer()) ) {s = 65;}

                        else if ( (synpred32_PtmLexer()) ) {s = 66;}

                        else if ( (synpred33_PtmLexer()) ) {s = 67;}

                        else if ( (synpred34_PtmLexer()) ) {s = 68;}

                        else if ( (synpred35_PtmLexer()) ) {s = 69;}

                        else if ( (synpred36_PtmLexer()) ) {s = 70;}

                        else if ( (synpred37_PtmLexer()) ) {s = 71;}

                        else if ( (synpred38_PtmLexer()) ) {s = 72;}

                        else if ( (synpred39_PtmLexer()) ) {s = 73;}

                        else if ( (synpred40_PtmLexer()) ) {s = 74;}

                        else if ( (synpred41_PtmLexer()) ) {s = 75;}

                        else if ( (synpred42_PtmLexer()) ) {s = 76;}

                        else if ( (synpred43_PtmLexer()) ) {s = 77;}

                         
                        input.seek(index14_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_7 = input.LA(1);

                         
                        int index14_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred4_PtmLexer()&&(l.isTypes()))) ) {s = 37;}

                        else if ( (synpred48_PtmLexer()) ) {s = 78;}

                         
                        input.seek(index14_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_23 = input.LA(1);

                         
                        int index14_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred63_PtmLexer()) ) {s = 79;}

                        else if ( (synpred73_PtmLexer()) ) {s = 80;}

                         
                        input.seek(index14_23);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA14_24 = input.LA(1);

                         
                        int index14_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred64_PtmLexer()) ) {s = 81;}

                        else if ( (synpred66_PtmLexer()) ) {s = 82;}

                         
                        input.seek(index14_24);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA14_25 = input.LA(1);

                         
                        int index14_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_PtmLexer()) ) {s = 83;}

                        else if ( (synpred67_PtmLexer()) ) {s = 84;}

                         
                        input.seek(index14_25);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA14_26 = input.LA(1);

                         
                        int index14_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_PtmLexer()) ) {s = 85;}

                        else if ( (synpred69_PtmLexer()) ) {s = 86;}

                         
                        input.seek(index14_26);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA14_27 = input.LA(1);

                         
                        int index14_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_PtmLexer()) ) {s = 87;}

                        else if ( (synpred75_PtmLexer()) ) {s = 88;}

                         
                        input.seek(index14_27);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}