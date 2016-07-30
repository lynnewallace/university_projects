// $ANTLR 3.4 /Users/kitsune/dev/ct/ct2/smallc.g 2012-02-28 23:23:04

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class smallcLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int ARGS=4;
    public static final int ASSIGN=5;
    public static final int BODY=6;
    public static final int CHARACTER=7;
    public static final int CHR=8;
    public static final int COMMENT=9;
    public static final int DECLARE=10;
    public static final int DIGIT=11;
    public static final int FUNCNAME=12;
    public static final int IDENT=13;
    public static final int LETTER=14;
    public static final int MAIN=15;
    public static final int NEGATE=16;
    public static final int NUMBER=17;
    public static final int PARAMS=18;
    public static final int PROCEDURE=19;
    public static final int PROGRAM=20;
    public static final int STMT=21;
    public static final int STMTLIST=22;
    public static final int STR=23;
    public static final int STRING=24;
    public static final int TIDENT=25;
    public static final int TYPE=26;
    public static final int VAR=27;
    public static final int VARNAME=28;
    public static final int WS=29;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public smallcLexer() {} 
    public smallcLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public smallcLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/kitsune/dev/ct/ct2/smallc.g"; }

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:2:7: ( '!=' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:2:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:3:7: ( '#include' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:3:9: '#include'
            {
            match("#include"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:4:7: ( '%' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:4:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:5:7: ( '(' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:5:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:6:7: ( ')' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:6:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:7:7: ( '*' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:7:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:8:7: ( '+' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:8:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:9:7: ( ',' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:9:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:10:7: ( '-' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:10:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:11:7: ( '/' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:11:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:12:7: ( ';' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:12:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:13:7: ( '<' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:13:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:14:7: ( '<=' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:14:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:15:7: ( '=' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:15:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:16:7: ( '==' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:16:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:17:7: ( '>' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:17:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:18:7: ( '>=' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:18:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:19:7: ( 'char' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:19:9: 'char'
            {
            match("char"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:20:7: ( 'else' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:20:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:21:7: ( 'if' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:21:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:22:7: ( 'int' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:22:9: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:23:7: ( 'main' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:23:9: 'main'
            {
            match("main"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:24:7: ( 'output' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:24:9: 'output'
            {
            match("output"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:25:7: ( 'outputc' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:25:9: 'outputc'
            {
            match("outputc"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:26:7: ( 'print' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:26:9: 'print'
            {
            match("print"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:27:7: ( 'read' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:27:9: 'read'
            {
            match("read"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:28:7: ( 'readc' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:28:9: 'readc'
            {
            match("readc"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:29:7: ( 'return' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:29:9: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:30:7: ( 'while' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:30:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:31:7: ( '{' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:31:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:32:7: ( '}' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:32:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/kitsune/dev/ct/ct2/smallc.g:108:2: ( '0' .. '9' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /Users/kitsune/dev/ct/ct2/smallc.g:113:2: ( 'A' .. 'Z' | 'a' .. 'z' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:117:2: ( ( DIGIT )+ )
            // /Users/kitsune/dev/ct/ct2/smallc.g:117:3: ( DIGIT )+
            {
            // /Users/kitsune/dev/ct/ct2/smallc.g:117:3: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:121:2: ( LETTER ( DIGIT | LETTER | '_' )* )
            // /Users/kitsune/dev/ct/ct2/smallc.g:121:3: LETTER ( DIGIT | LETTER | '_' )*
            {
            mLETTER(); 


            // /Users/kitsune/dev/ct/ct2/smallc.g:121:10: ( DIGIT | LETTER | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "CHARACTER"
    public final void mCHARACTER() throws RecognitionException {
        try {
            int _type = CHARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:125:2: ( '\\'' . '\\'' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:125:5: '\\'' . '\\''
            {
            match('\''); 

            matchAny(); 

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARACTER"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:129:6: ( '\"' (~ ( '\\n' | '\"' ) )* '\"' )
            // /Users/kitsune/dev/ct/ct2/smallc.g:129:9: '\"' (~ ( '\\n' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /Users/kitsune/dev/ct/ct2/smallc.g:129:13: (~ ( '\\n' | '\"' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:133:6: ( '//' ( . )* '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='/') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='/') ) {
                    alt6=1;
                }
                else if ( (LA6_1=='*') ) {
                    alt6=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:133:10: '//' ( . )* '\\n'
                    {
                    match("//"); 



                    // /Users/kitsune/dev/ct/ct2/smallc.g:133:15: ( . )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\n') ) {
                            alt4=2;
                        }
                        else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/kitsune/dev/ct/ct2/smallc.g:133:15: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:134:10: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /Users/kitsune/dev/ct/ct2/smallc.g:134:15: ( options {greedy=false; } : . )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='*') ) {
                            int LA5_1 = input.LA(2);

                            if ( (LA5_1=='/') ) {
                                alt5=2;
                            }
                            else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
                                alt5=1;
                            }


                        }
                        else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/kitsune/dev/ct/ct2/smallc.g:134:43: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/kitsune/dev/ct/ct2/smallc.g:138:6: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /Users/kitsune/dev/ct/ct2/smallc.g:138:7: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /Users/kitsune/dev/ct/ct2/smallc.g:138:7: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/kitsune/dev/ct/ct2/smallc.g:1:8: ( T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | NUMBER | IDENT | CHARACTER | STRING | COMMENT | WS )
        int alt8=37;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:10: T__30
                {
                mT__30(); 


                }
                break;
            case 2 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:16: T__31
                {
                mT__31(); 


                }
                break;
            case 3 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:22: T__32
                {
                mT__32(); 


                }
                break;
            case 4 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:28: T__33
                {
                mT__33(); 


                }
                break;
            case 5 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:34: T__34
                {
                mT__34(); 


                }
                break;
            case 6 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:40: T__35
                {
                mT__35(); 


                }
                break;
            case 7 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:46: T__36
                {
                mT__36(); 


                }
                break;
            case 8 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:52: T__37
                {
                mT__37(); 


                }
                break;
            case 9 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:58: T__38
                {
                mT__38(); 


                }
                break;
            case 10 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:64: T__39
                {
                mT__39(); 


                }
                break;
            case 11 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:70: T__40
                {
                mT__40(); 


                }
                break;
            case 12 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:76: T__41
                {
                mT__41(); 


                }
                break;
            case 13 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:82: T__42
                {
                mT__42(); 


                }
                break;
            case 14 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:88: T__43
                {
                mT__43(); 


                }
                break;
            case 15 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:94: T__44
                {
                mT__44(); 


                }
                break;
            case 16 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:100: T__45
                {
                mT__45(); 


                }
                break;
            case 17 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:106: T__46
                {
                mT__46(); 


                }
                break;
            case 18 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:112: T__47
                {
                mT__47(); 


                }
                break;
            case 19 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:118: T__48
                {
                mT__48(); 


                }
                break;
            case 20 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:124: T__49
                {
                mT__49(); 


                }
                break;
            case 21 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:130: T__50
                {
                mT__50(); 


                }
                break;
            case 22 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:136: T__51
                {
                mT__51(); 


                }
                break;
            case 23 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:142: T__52
                {
                mT__52(); 


                }
                break;
            case 24 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:148: T__53
                {
                mT__53(); 


                }
                break;
            case 25 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:154: T__54
                {
                mT__54(); 


                }
                break;
            case 26 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:160: T__55
                {
                mT__55(); 


                }
                break;
            case 27 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:166: T__56
                {
                mT__56(); 


                }
                break;
            case 28 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:172: T__57
                {
                mT__57(); 


                }
                break;
            case 29 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:178: T__58
                {
                mT__58(); 


                }
                break;
            case 30 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:184: T__59
                {
                mT__59(); 


                }
                break;
            case 31 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:190: T__60
                {
                mT__60(); 


                }
                break;
            case 32 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:196: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 33 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:203: IDENT
                {
                mIDENT(); 


                }
                break;
            case 34 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:209: CHARACTER
                {
                mCHARACTER(); 


                }
                break;
            case 35 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:219: STRING
                {
                mSTRING(); 


                }
                break;
            case 36 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:226: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 37 :
                // /Users/kitsune/dev/ct/ct2/smallc.g:1:234: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\12\uffff\1\37\1\uffff\1\41\1\43\1\45\10\32\17\uffff\2\32\1\61\10"+
        "\32\1\uffff\1\73\6\32\1\102\1\103\1\uffff\1\104\2\32\1\110\2\32"+
        "\3\uffff\1\32\1\114\1\115\1\uffff\1\32\1\117\1\121\2\uffff\1\122"+
        "\1\uffff\1\123\3\uffff";
    static final String DFA8_eofS =
        "\124\uffff";
    static final String DFA8_minS =
        "\1\11\11\uffff\1\52\1\uffff\3\75\1\150\1\154\1\146\1\141\1\165\1"+
        "\162\1\145\1\150\17\uffff\1\141\1\163\1\60\1\164\1\151\1\164\1\151"+
        "\1\141\1\151\1\162\1\145\1\uffff\1\60\1\156\1\160\1\156\1\144\1"+
        "\165\1\154\2\60\1\uffff\1\60\1\165\1\164\1\60\1\162\1\145\3\uffff"+
        "\1\164\2\60\1\uffff\1\156\2\60\2\uffff\1\60\1\uffff\1\60\3\uffff";
    static final String DFA8_maxS =
        "\1\175\11\uffff\1\57\1\uffff\3\75\1\150\1\154\1\156\1\141\1\165"+
        "\1\162\1\145\1\150\17\uffff\1\141\1\163\1\172\1\164\1\151\1\164"+
        "\1\151\1\164\1\151\1\162\1\145\1\uffff\1\172\1\156\1\160\1\156\1"+
        "\144\1\165\1\154\2\172\1\uffff\1\172\1\165\1\164\1\172\1\162\1\145"+
        "\3\uffff\1\164\2\172\1\uffff\1\156\2\172\2\uffff\1\172\1\uffff\1"+
        "\172\3\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\13\13\uffff"+
        "\1\36\1\37\1\40\1\41\1\42\1\43\1\45\1\44\1\12\1\15\1\14\1\17\1\16"+
        "\1\21\1\20\13\uffff\1\24\11\uffff\1\25\6\uffff\1\22\1\23\1\26\3"+
        "\uffff\1\32\3\uffff\1\31\1\33\1\uffff\1\35\1\uffff\1\27\1\34\1\30";
    static final String DFA8_specialS =
        "\124\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\35\2\uffff\1\35\22\uffff\1\35\1\1\1\34\1\2\1\uffff\1\3\1"+
            "\uffff\1\33\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\12\12\31\1\uffff"+
            "\1\13\1\14\1\15\1\16\2\uffff\32\32\6\uffff\2\32\1\17\1\32\1"+
            "\20\3\32\1\21\3\32\1\22\1\32\1\23\1\24\1\32\1\25\4\32\1\26\3"+
            "\32\1\27\1\uffff\1\30",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\4\uffff\1\36",
            "",
            "\1\40",
            "\1\42",
            "\1\44",
            "\1\46",
            "\1\47",
            "\1\50\7\uffff\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
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
            "\1\57",
            "\1\60",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66\22\uffff\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\105",
            "\1\106",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\2\32\1\107\27\32",
            "\1\111",
            "\1\112",
            "",
            "",
            "",
            "\1\113",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\116",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\2\32\1\120\27\32",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
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
            return "1:1: Tokens : ( T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | NUMBER | IDENT | CHARACTER | STRING | COMMENT | WS );";
        }
    }
 

}