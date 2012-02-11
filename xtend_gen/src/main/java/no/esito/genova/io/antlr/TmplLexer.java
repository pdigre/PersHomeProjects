// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g 2012-02-11 20:13:36

package no.esito.genova.io.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class TmplLexer extends Lexer {
    public static final int DOLLAR=18;
    public static final int APPEND=39;
    public static final int LT=40;
    public static final int LBRACK=35;
    public static final int LSQUARE=37;
    public static final int LETTER=19;
    public static final int NOT=51;
    public static final int ALFA=17;
    public static final int AND=47;
    public static final int ID=21;
    public static final int EOF=-1;
    public static final int HAT=53;
    public static final int UNDER=20;
    public static final int SLASH=32;
    public static final int MULTIPLY=50;
    public static final int COMMA=30;
    public static final int EQUAL=44;
    public static final int BEGIN=8;
    public static final int TILDE=52;
    public static final int RPARAN=34;
    public static final int ENDIF=13;
    public static final int PLUS=49;
    public static final int DIGIT=22;
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
    public static final int COLON=27;
    public static final int WS=11;
    public static final int LPARAN=33;
    public static final int QUESTION=54;
    public static final int NEWLINE=12;
    public static final int OUT=4;
    public static final int IF_=10;
    public static final int OR=48;
    public static final int ASSIGN=45;
    public static final int GT=41;
    public static final int BOOL_START=15;
    public static final int LE=42;

    public TmplLexerSub l;


    // delegates
    // delegators

    public TmplLexer() {;} 
    public TmplLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TmplLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g"; }

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
    }// $ANTLR start "REM"
    public final void mREM() throws RecognitionException {
        try {
            int _type = REM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:24:3: ( '@rem' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:25:3: '@rem'
            {
            match("@rem"); if (state.failed) return ;

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

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:32:3: ( '@//' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:33:3: '@//'
            {
            match("@//"); if (state.failed) return ;

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
    // $ANTLR end "COMMENT"

    // $ANTLR start "SECTION"
    public final void mSECTION() throws RecognitionException {
        try {
            int _type = SECTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:40:3: ( '@section' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:41:3: '@section'
            {
            match("@section"); if (state.failed) return ;

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
    // $ANTLR end "SECTION"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:48:3: ( '@begin' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:49:3: '@begin'
            {
            match("@begin"); if (state.failed) return ;

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
    // $ANTLR end "BEGIN"

    // $ANTLR start "CREATESECTION"
    public final void mCREATESECTION() throws RecognitionException {
        try {
            int _type = CREATESECTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:56:3: ( '@createSection' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:57:3: '@createSection'
            {
            match("@createSection"); if (state.failed) return ;

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
    // $ANTLR end "CREATESECTION"

    // $ANTLR start "IF_"
    public final void mIF_() throws RecognitionException {
        try {
            int _type = IF_;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:64:3: ( '@if' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:65:3: '@if'
            {
            match("@if"); if (state.failed) return ;

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
    // $ANTLR end "IF_"

    // $ANTLR start "ENDIF"
    public final void mENDIF() throws RecognitionException {
        try {
            int _type = ENDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:72:3: ( '@endif' ( WS )? NEWLINE )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:73:3: '@endif' ( WS )? NEWLINE
            {
            match("@endif"); if (state.failed) return ;

            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:73:12: ( WS )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\t'||LA1_0==' ') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:73:12: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            mNEWLINE(); if (state.failed) return ;
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
    // $ANTLR end "ENDIF"

    // $ANTLR start "EVENT"
    public final void mEVENT() throws RecognitionException {
        try {
            int _type = EVENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:80:3: ( '@event' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:81:3: '@event'
            {
            match("@event"); if (state.failed) return ;

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
    // $ANTLR end "EVENT"

    // $ANTLR start "BOOL_START"
    public final void mBOOL_START() throws RecognitionException {
        try {
            int _type = BOOL_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:88:3: ( '@(' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:89:3: '@('
            {
            match("@("); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                      l.boolStart();
                     
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOL_START"

    // $ANTLR start "BOOL_END"
    public final void mBOOL_END() throws RecognitionException {
        try {
            int _type = BOOL_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:96:3: ( ')@' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:97:3: ')@'
            {
            match(")@"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                      l.boolEnd();
                     
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOL_END"

    // $ANTLR start "ALFA"
    public final void mALFA() throws RecognitionException {
        try {
            int _type = ALFA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:104:3: ( '@@' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:105:3: '@@'
            {
            match("@@"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                      l.alfa();
                     
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALFA"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:112:3: ( '$$' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:113:3: '$$'
            {
            match("$$"); if (state.failed) return ;

            if ( state.backtracking==1 ) {

                      l.dollar();
                     
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:120:3: ( ( ( '\\r' )? '\\n' ) )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:121:3: ( ( '\\r' )? '\\n' )
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:121:3: ( ( '\\r' )? '\\n' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:121:4: ( '\\r' )? '\\n'
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:121:4: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:121:4: '\\r'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:127:3: ( ( ' ' | '\\t' )+ )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:128:3: ( ' ' | '\\t' )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:128:3: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:
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
    // $ANTLR end "WS"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:135:3: ( ( LETTER | UNDER )+ )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:136:3: ( LETTER | UNDER )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:136:3: ( LETTER | UNDER )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:
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
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:143:3: ( ( DIGIT )+ )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:144:3: ( DIGIT )+
            {
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:144:3: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:144:3: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:149:3: ( 'A' .. 'Z' | 'a' .. 'z' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:156:3: ( '_' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:157:3: '_'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:161:3: ( '.' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:162:3: '.'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:166:3: ( '-' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:167:3: '-'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:172:3: ( '0' .. '9' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:173:3: '0' .. '9'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:177:3: ( '\"' (~ ( '\"' ) )* '\"' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:178:3: '\"' (~ ( '\"' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:178:7: (~ ( '\"' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:178:7: ~ ( '\"' )
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
            	    break loop6;
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:182:3: ( ':' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:183:3: ':'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:187:3: ( ';' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:188:3: ';'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:192:3: ( '#' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:193:3: '#'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:197:3: ( ',' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:198:3: ','
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:202:3: ( '\\'' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:203:3: '\\''
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:207:3: ( '/' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:208:3: '/'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:212:3: ( '(' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:213:3: '('
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:217:3: ( ')' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:218:3: ')'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:222:3: ( '{' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:223:3: '{'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:227:3: ( '}' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:228:3: '}'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:232:3: ( '[' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:233:3: '['
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:237:3: ( ']' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:238:3: ']'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:242:3: ( '++' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:243:3: '++'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:247:3: ( '<' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:248:3: '<'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:252:3: ( '>' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:253:3: '>'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:257:3: ( '<' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:258:3: '<'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:262:3: ( '>=' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:263:3: '>='
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:267:3: ( '==' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:268:3: '=='
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:272:3: ( '=' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:273:3: '='
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:277:3: ( '!=' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:278:3: '!='
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:282:3: ( '&' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:283:3: '&'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:287:3: ( '|' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:288:3: '|'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:292:3: ( '+' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:293:3: '+'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:297:3: ( '*' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:298:3: '*'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:302:3: ( '!' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:303:3: '!'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:307:3: ( '~' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:308:3: '~'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:312:3: ( '^' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:313:3: '^'
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
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:317:3: ( '?' )
            // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:318:3: '?'
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
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:39: ( REM | COMMENT | SECTION | BEGIN | CREATESECTION | IF_ | ENDIF | EVENT | BOOL_START | BOOL_END | ALFA | DOLLAR | NEWLINE | WS | ID | INT | DOT | MINUS | LITERAL | COLON | SEMICOLON | HASH | COMMA | SQUOTE | SLASH | LPARAN | RPARAN | LBRACK | RBRACK | LSQUARE | RSQUARE | APPEND | LT | GT | LE | GE | EQUAL | ASSIGN | NE | AND | OR | PLUS | MULTIPLY | NOT | TILDE | HAT | QUESTION )
        int alt7=47;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:41: REM
                {
                mREM(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:45: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:53: SECTION
                {
                mSECTION(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:61: BEGIN
                {
                mBEGIN(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:67: CREATESECTION
                {
                mCREATESECTION(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:81: IF_
                {
                mIF_(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:85: ENDIF
                {
                mENDIF(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:91: EVENT
                {
                mEVENT(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:97: BOOL_START
                {
                mBOOL_START(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:108: BOOL_END
                {
                mBOOL_END(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:117: ALFA
                {
                mALFA(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:122: DOLLAR
                {
                mDOLLAR(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:129: NEWLINE
                {
                mNEWLINE(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:137: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:140: ID
                {
                mID(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:143: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:147: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:151: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:157: LITERAL
                {
                mLITERAL(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:165: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:171: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:181: HASH
                {
                mHASH(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:186: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:192: SQUOTE
                {
                mSQUOTE(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:199: SLASH
                {
                mSLASH(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:205: LPARAN
                {
                mLPARAN(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:212: RPARAN
                {
                mRPARAN(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:219: LBRACK
                {
                mLBRACK(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:226: RBRACK
                {
                mRBRACK(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:233: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:241: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:249: APPEND
                {
                mAPPEND(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:256: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:259: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:262: LE
                {
                mLE(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:265: GE
                {
                mGE(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:268: EQUAL
                {
                mEQUAL(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:274: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:281: NE
                {
                mNE(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:284: AND
                {
                mAND(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:288: OR
                {
                mOR(); if (state.failed) return ;

                }
                break;
            case 42 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:291: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 43 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:296: MULTIPLY
                {
                mMULTIPLY(); if (state.failed) return ;

                }
                break;
            case 44 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:305: NOT
                {
                mNOT(); if (state.failed) return ;

                }
                break;
            case 45 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:309: TILDE
                {
                mTILDE(); if (state.failed) return ;

                }
                break;
            case 46 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:315: HAT
                {
                mHAT(); if (state.failed) return ;

                }
                break;
            case 47 :
                // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:319: QUESTION
                {
                mQUESTION(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_TmplLexer
    public final void synpred1_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:41: ( REM )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:41: REM
        {
        mREM(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_TmplLexer

    // $ANTLR start synpred2_TmplLexer
    public final void synpred2_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:45: ( COMMENT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:45: COMMENT
        {
        mCOMMENT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_TmplLexer

    // $ANTLR start synpred3_TmplLexer
    public final void synpred3_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:53: ( SECTION )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:53: SECTION
        {
        mSECTION(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_TmplLexer

    // $ANTLR start synpred4_TmplLexer
    public final void synpred4_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:61: ( BEGIN )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:61: BEGIN
        {
        mBEGIN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_TmplLexer

    // $ANTLR start synpred5_TmplLexer
    public final void synpred5_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:67: ( CREATESECTION )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:67: CREATESECTION
        {
        mCREATESECTION(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_TmplLexer

    // $ANTLR start synpred6_TmplLexer
    public final void synpred6_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:81: ( IF_ )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:81: IF_
        {
        mIF_(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_TmplLexer

    // $ANTLR start synpred7_TmplLexer
    public final void synpred7_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:85: ( ENDIF )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:85: ENDIF
        {
        mENDIF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_TmplLexer

    // $ANTLR start synpred8_TmplLexer
    public final void synpred8_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:91: ( EVENT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:91: EVENT
        {
        mEVENT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_TmplLexer

    // $ANTLR start synpred9_TmplLexer
    public final void synpred9_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:97: ( BOOL_START )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:97: BOOL_START
        {
        mBOOL_START(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_TmplLexer

    // $ANTLR start synpred10_TmplLexer
    public final void synpred10_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:108: ( BOOL_END )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:108: BOOL_END
        {
        mBOOL_END(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_TmplLexer

    // $ANTLR start synpred11_TmplLexer
    public final void synpred11_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:117: ( ALFA )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:117: ALFA
        {
        mALFA(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_TmplLexer

    // $ANTLR start synpred27_TmplLexer
    public final void synpred27_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:212: ( RPARAN )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:212: RPARAN
        {
        mRPARAN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_TmplLexer

    // $ANTLR start synpred32_TmplLexer
    public final void synpred32_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:249: ( APPEND )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:249: APPEND
        {
        mAPPEND(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_TmplLexer

    // $ANTLR start synpred33_TmplLexer
    public final void synpred33_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:256: ( LT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:256: LT
        {
        mLT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_TmplLexer

    // $ANTLR start synpred34_TmplLexer
    public final void synpred34_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:259: ( GT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:259: GT
        {
        mGT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_TmplLexer

    // $ANTLR start synpred35_TmplLexer
    public final void synpred35_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:262: ( LE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:262: LE
        {
        mLE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_TmplLexer

    // $ANTLR start synpred36_TmplLexer
    public final void synpred36_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:265: ( GE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:265: GE
        {
        mGE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_TmplLexer

    // $ANTLR start synpred37_TmplLexer
    public final void synpred37_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:268: ( EQUAL )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:268: EQUAL
        {
        mEQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_TmplLexer

    // $ANTLR start synpred38_TmplLexer
    public final void synpred38_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:274: ( ASSIGN )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:274: ASSIGN
        {
        mASSIGN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_TmplLexer

    // $ANTLR start synpred39_TmplLexer
    public final void synpred39_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:281: ( NE )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:281: NE
        {
        mNE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_TmplLexer

    // $ANTLR start synpred42_TmplLexer
    public final void synpred42_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:291: ( PLUS )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:291: PLUS
        {
        mPLUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_TmplLexer

    // $ANTLR start synpred44_TmplLexer
    public final void synpred44_TmplLexer_fragment() throws RecognitionException {   
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:305: ( NOT )
        // C:\\git\\PersHomeProjects\\xtend_gen\\src\\main\\java\\no\\esito\\genova\\io\\antlr\\TmplLexer.g:1:305: NOT
        {
        mNOT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_TmplLexer

    public final boolean synpred6_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_TmplLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_TmplLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\67\uffff";
    static final String DFA7_eofS =
        "\67\uffff";
    static final String DFA7_minS =
        "\1\11\2\uffff\1\0\5\uffff\1\0\3\uffff\1\0\4\uffff\1\0\7\uffff\1"+
        "\0\12\uffff\1\0\2\uffff\1\0\16\uffff";
    static final String DFA7_maxS =
        "\1\176\2\uffff\1\0\5\uffff\1\0\3\uffff\1\0\4\uffff\1\0\7\uffff"+
        "\1\0\12\uffff\1\0\2\uffff\1\0\16\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\51\1\50\1\uffff\1\41\1\43\1\56\1\23\1\35\1\uffff\1\12"+
        "\1\33\1\14\1\uffff\1\42\1\44\1\25\1\20\1\uffff\1\45\1\46\1\15\1"+
        "\21\1\36\1\30\1\16\1\uffff\1\40\1\52\1\26\1\31\1\22\1\32\1\17\1"+
        "\27\1\57\1\55\1\uffff\1\47\1\54\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6"+
        "\1\7\1\10\1\11\1\13\1\53\1\34\1\37\1\24";
    static final String DFA7_specialS =
        "\3\uffff\1\0\5\uffff\1\1\3\uffff\1\2\4\uffff\1\3\7\uffff\1\4\12"+
        "\uffff\1\5\2\uffff\1\6\16\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\31\1\25\2\uffff\1\25\22\uffff\1\31\1\45\1\7\1\35\1\14\1"+
            "\uffff\1\2\1\30\1\40\1\11\1\63\1\32\1\42\1\37\1\26\1\36\12\21"+
            "\1\66\1\20\1\3\1\22\1\15\1\43\1\50\32\41\1\27\1\uffff\1\65\1"+
            "\6\1\41\1\uffff\32\41\1\64\1\1\1\10\1\44",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
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
            "\1\uffff",
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
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens options {k=1; backtrack=true; } : ( REM | COMMENT | SECTION | BEGIN | CREATESECTION | IF_ | ENDIF | EVENT | BOOL_START | BOOL_END | ALFA | DOLLAR | NEWLINE | WS | ID | INT | DOT | MINUS | LITERAL | COLON | SEMICOLON | HASH | COMMA | SQUOTE | SLASH | LPARAN | RPARAN | LBRACK | RBRACK | LSQUARE | RSQUARE | APPEND | LT | GT | LE | GE | EQUAL | ASSIGN | NE | AND | OR | PLUS | MULTIPLY | NOT | TILDE | HAT | QUESTION );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_3 = input.LA(1);

                         
                        int index7_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_TmplLexer()) ) {s = 4;}

                        else if ( (synpred35_TmplLexer()) ) {s = 5;}

                         
                        input.seek(index7_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_9 = input.LA(1);

                         
                        int index7_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_TmplLexer()) ) {s = 10;}

                        else if ( (synpred27_TmplLexer()) ) {s = 11;}

                         
                        input.seek(index7_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_13 = input.LA(1);

                         
                        int index7_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_TmplLexer()) ) {s = 14;}

                        else if ( (synpred36_TmplLexer()) ) {s = 15;}

                         
                        input.seek(index7_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA7_18 = input.LA(1);

                         
                        int index7_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_TmplLexer()) ) {s = 19;}

                        else if ( (synpred38_TmplLexer()) ) {s = 20;}

                         
                        input.seek(index7_18);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA7_26 = input.LA(1);

                         
                        int index7_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_TmplLexer()) ) {s = 27;}

                        else if ( (synpred42_TmplLexer()) ) {s = 28;}

                         
                        input.seek(index7_26);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA7_37 = input.LA(1);

                         
                        int index7_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_TmplLexer()) ) {s = 38;}

                        else if ( (synpred44_TmplLexer()) ) {s = 39;}

                         
                        input.seek(index7_37);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA7_40 = input.LA(1);

                         
                        int index7_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_TmplLexer()) ) {s = 41;}

                        else if ( (synpred2_TmplLexer()) ) {s = 42;}

                        else if ( (synpred3_TmplLexer()) ) {s = 43;}

                        else if ( (synpred4_TmplLexer()) ) {s = 44;}

                        else if ( (synpred5_TmplLexer()) ) {s = 45;}

                        else if ( (synpred6_TmplLexer()) ) {s = 46;}

                        else if ( (synpred7_TmplLexer()) ) {s = 47;}

                        else if ( (synpred8_TmplLexer()) ) {s = 48;}

                        else if ( (synpred9_TmplLexer()) ) {s = 49;}

                        else if ( (synpred11_TmplLexer()) ) {s = 50;}

                         
                        input.seek(index7_40);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}