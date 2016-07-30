// $ANTLR 3.4 /Users/kitsune/dev/ct/ct2/smallc.g 2012-02-28 23:23:04

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class smallcParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARGS", "ASSIGN", "BODY", "CHARACTER", "CHR", "COMMENT", "DECLARE", "DIGIT", "FUNCNAME", "IDENT", "LETTER", "MAIN", "NEGATE", "NUMBER", "PARAMS", "PROCEDURE", "PROGRAM", "STMT", "STMTLIST", "STR", "STRING", "TIDENT", "TYPE", "VAR", "VARNAME", "WS", "'!='", "'#include'", "'%'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'char'", "'else'", "'if'", "'int'", "'main'", "'output'", "'outputc'", "'print'", "'read'", "'readc'", "'return'", "'while'", "'{'", "'}'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public smallcParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public smallcParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[56+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return smallcParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/kitsune/dev/ct/ct2/smallc.g"; }


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "program"
    // /Users/kitsune/dev/ct/ct2/smallc.g:32:1: program : includes decls ( procedure )* main -> ^( PROGRAM decls ( procedure )* main ) ;
    public final smallcParser.program_return program() throws RecognitionException {
        smallcParser.program_return retval = new smallcParser.program_return();
        retval.start = input.LT(1);

        int program_StartIndex = input.index();

        Object root_0 = null;

        smallcParser.includes_return includes1 =null;

        smallcParser.decls_return decls2 =null;

        smallcParser.procedure_return procedure3 =null;

        smallcParser.main_return main4 =null;


        RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");
        RewriteRuleSubtreeStream stream_includes=new RewriteRuleSubtreeStream(adaptor,"rule includes");
        RewriteRuleSubtreeStream stream_procedure=new RewriteRuleSubtreeStream(adaptor,"rule procedure");
        RewriteRuleSubtreeStream stream_main=new RewriteRuleSubtreeStream(adaptor,"rule main");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:33:2: ( includes decls ( procedure )* main -> ^( PROGRAM decls ( procedure )* main ) )
            // /Users/kitsune/dev/ct/ct2/smallc.g:33:3: includes decls ( procedure )* main
            {
            pushFollow(FOLLOW_includes_in_program122);
            includes1=includes();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_includes.add(includes1.getTree());

            pushFollow(FOLLOW_decls_in_program124);
            decls2=decls();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_decls.add(decls2.getTree());

            // /Users/kitsune/dev/ct/ct2/smallc.g:33:18: ( procedure )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENT||LA1_0==47||LA1_0==50) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:33:18: procedure
            	    {
            	    pushFollow(FOLLOW_procedure_in_program126);
            	    procedure3=procedure();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_procedure.add(procedure3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            pushFollow(FOLLOW_main_in_program129);
            main4=main();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_main.add(main4.getTree());

            // AST REWRITE
            // elements: procedure, main, decls
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 33:34: -> ^( PROGRAM decls ( procedure )* main )
            {
                // /Users/kitsune/dev/ct/ct2/smallc.g:33:37: ^( PROGRAM decls ( procedure )* main )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROGRAM, "PROGRAM")
                , root_1);

                adaptor.addChild(root_1, stream_decls.nextTree());

                // /Users/kitsune/dev/ct/ct2/smallc.g:33:53: ( procedure )*
                while ( stream_procedure.hasNext() ) {
                    adaptor.addChild(root_1, stream_procedure.nextTree());

                }
                stream_procedure.reset();

                adaptor.addChild(root_1, stream_main.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, program_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "program"


    public static class includes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "includes"
    // /Users/kitsune/dev/ct/ct2/smallc.g:36:1: includes : ( '#include' STRING )* ;
    public final smallcParser.includes_return includes() throws RecognitionException {
        smallcParser.includes_return retval = new smallcParser.includes_return();
        retval.start = input.LT(1);

        int includes_StartIndex = input.index();

        Object root_0 = null;

        Token string_literal5=null;
        Token STRING6=null;

        Object string_literal5_tree=null;
        Object STRING6_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:37:2: ( ( '#include' STRING )* )
            // /Users/kitsune/dev/ct/ct2/smallc.g:37:3: ( '#include' STRING )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/kitsune/dev/ct/ct2/smallc.g:37:3: ( '#include' STRING )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==31) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:37:4: '#include' STRING
            	    {
            	    string_literal5=(Token)match(input,31,FOLLOW_31_in_includes154); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal5_tree = 
            	    (Object)adaptor.create(string_literal5)
            	    ;
            	    adaptor.addChild(root_0, string_literal5_tree);
            	    }

            	    STRING6=(Token)match(input,STRING,FOLLOW_STRING_in_includes156); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    STRING6_tree = 
            	    (Object)adaptor.create(STRING6)
            	    ;
            	    adaptor.addChild(root_0, STRING6_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, includes_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "includes"


    public static class decls_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "decls"
    // /Users/kitsune/dev/ct/ct2/smallc.g:40:1: decls : ( typedident ';' )* -> ^( DECLARE ( typedident )* ) ;
    public final smallcParser.decls_return decls() throws RecognitionException {
        smallcParser.decls_return retval = new smallcParser.decls_return();
        retval.start = input.LT(1);

        int decls_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal8=null;
        smallcParser.typedident_return typedident7 =null;


        Object char_literal8_tree=null;
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_typedident=new RewriteRuleSubtreeStream(adaptor,"rule typedident");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:41:2: ( ( typedident ';' )* -> ^( DECLARE ( typedident )* ) )
            // /Users/kitsune/dev/ct/ct2/smallc.g:41:3: ( typedident ';' )*
            {
            // /Users/kitsune/dev/ct/ct2/smallc.g:41:3: ( typedident ';' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==50) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==IDENT) ) {
                        int LA3_4 = input.LA(3);

                        if ( (LA3_4==40) ) {
                            alt3=1;
                        }


                    }


                }
                else if ( (LA3_0==47) ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==IDENT) ) {
                        int LA3_4 = input.LA(3);

                        if ( (LA3_4==40) ) {
                            alt3=1;
                        }


                    }


                }


                switch (alt3) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:41:4: typedident ';'
            	    {
            	    pushFollow(FOLLOW_typedident_in_decls170);
            	    typedident7=typedident();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_typedident.add(typedident7.getTree());

            	    char_literal8=(Token)match(input,40,FOLLOW_40_in_decls172); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_40.add(char_literal8);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // AST REWRITE
            // elements: typedident
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 41:21: -> ^( DECLARE ( typedident )* )
            {
                // /Users/kitsune/dev/ct/ct2/smallc.g:41:24: ^( DECLARE ( typedident )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(DECLARE, "DECLARE")
                , root_1);

                // /Users/kitsune/dev/ct/ct2/smallc.g:41:34: ( typedident )*
                while ( stream_typedident.hasNext() ) {
                    adaptor.addChild(root_1, stream_typedident.nextTree());

                }
                stream_typedident.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, decls_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "decls"


    public static class typedident_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typedident"
    // /Users/kitsune/dev/ct/ct2/smallc.g:44:1: typedident : (type= 'int' |type= 'char' ) IDENT -> ^( TIDENT ^( TYPE $type) ^( VARNAME IDENT ) ) ;
    public final smallcParser.typedident_return typedident() throws RecognitionException {
        smallcParser.typedident_return retval = new smallcParser.typedident_return();
        retval.start = input.LT(1);

        int typedident_StartIndex = input.index();

        Object root_0 = null;

        Token type=null;
        Token IDENT9=null;

        Object type_tree=null;
        Object IDENT9_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:45:2: ( (type= 'int' |type= 'char' ) IDENT -> ^( TIDENT ^( TYPE $type) ^( VARNAME IDENT ) ) )
            // /Users/kitsune/dev/ct/ct2/smallc.g:45:3: (type= 'int' |type= 'char' ) IDENT
            {
            // /Users/kitsune/dev/ct/ct2/smallc.g:45:3: (type= 'int' |type= 'char' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==50) ) {
                alt4=1;
            }
            else if ( (LA4_0==47) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:45:4: type= 'int'
                    {
                    type=(Token)match(input,50,FOLLOW_50_in_typedident199); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(type);


                    }
                    break;
                case 2 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:45:15: type= 'char'
                    {
                    type=(Token)match(input,47,FOLLOW_47_in_typedident203); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(type);


                    }
                    break;

            }


            IDENT9=(Token)match(input,IDENT,FOLLOW_IDENT_in_typedident206); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT9);


            // AST REWRITE
            // elements: IDENT, type
            // token labels: type
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 45:34: -> ^( TIDENT ^( TYPE $type) ^( VARNAME IDENT ) )
            {
                // /Users/kitsune/dev/ct/ct2/smallc.g:45:37: ^( TIDENT ^( TYPE $type) ^( VARNAME IDENT ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(TIDENT, "TIDENT")
                , root_1);

                // /Users/kitsune/dev/ct/ct2/smallc.g:45:46: ^( TYPE $type)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(TYPE, "TYPE")
                , root_2);

                adaptor.addChild(root_2, stream_type.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                // /Users/kitsune/dev/ct/ct2/smallc.g:45:60: ^( VARNAME IDENT )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(VARNAME, "VARNAME")
                , root_2);

                adaptor.addChild(root_2, 
                stream_IDENT.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, typedident_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "typedident"


    public static class stmtlist_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stmtlist"
    // /Users/kitsune/dev/ct/ct2/smallc.g:48:1: stmtlist : ( stmt )* -> ^( STMTLIST ( stmt )* ) ;
    public final smallcParser.stmtlist_return stmtlist() throws RecognitionException {
        smallcParser.stmtlist_return retval = new smallcParser.stmtlist_return();
        retval.start = input.LT(1);

        int stmtlist_StartIndex = input.index();

        Object root_0 = null;

        smallcParser.stmt_return stmt10 =null;


        RewriteRuleSubtreeStream stream_stmt=new RewriteRuleSubtreeStream(adaptor,"rule stmt");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:49:2: ( ( stmt )* -> ^( STMTLIST ( stmt )* ) )
            // /Users/kitsune/dev/ct/ct2/smallc.g:49:3: ( stmt )*
            {
            // /Users/kitsune/dev/ct/ct2/smallc.g:49:3: ( stmt )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT||LA5_0==49||(LA5_0 >= 52 && LA5_0 <= 59)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:49:3: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_stmtlist236);
            	    stmt10=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stmt.add(stmt10.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            // AST REWRITE
            // elements: stmt
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 49:9: -> ^( STMTLIST ( stmt )* )
            {
                // /Users/kitsune/dev/ct/ct2/smallc.g:49:12: ^( STMTLIST ( stmt )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(STMTLIST, "STMTLIST")
                , root_1);

                // /Users/kitsune/dev/ct/ct2/smallc.g:49:23: ( stmt )*
                while ( stream_stmt.hasNext() ) {
                    adaptor.addChild(root_1, stream_stmt.nextTree());

                }
                stream_stmt.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, stmtlist_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "stmtlist"


    public static class main_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "main"
    // /Users/kitsune/dev/ct/ct2/smallc.g:52:1: main : 'main' '(' ')' body -> ^( MAIN body ) ;
    public final smallcParser.main_return main() throws RecognitionException {
        smallcParser.main_return retval = new smallcParser.main_return();
        retval.start = input.LT(1);

        int main_StartIndex = input.index();

        Object root_0 = null;

        Token string_literal11=null;
        Token char_literal12=null;
        Token char_literal13=null;
        smallcParser.body_return body14 =null;


        Object string_literal11_tree=null;
        Object char_literal12_tree=null;
        Object char_literal13_tree=null;
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleSubtreeStream stream_body=new RewriteRuleSubtreeStream(adaptor,"rule body");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:53:2: ( 'main' '(' ')' body -> ^( MAIN body ) )
            // /Users/kitsune/dev/ct/ct2/smallc.g:53:3: 'main' '(' ')' body
            {
            string_literal11=(Token)match(input,51,FOLLOW_51_in_main257); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_51.add(string_literal11);


            char_literal12=(Token)match(input,33,FOLLOW_33_in_main259); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_33.add(char_literal12);


            char_literal13=(Token)match(input,34,FOLLOW_34_in_main261); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_34.add(char_literal13);


            pushFollow(FOLLOW_body_in_main263);
            body14=body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_body.add(body14.getTree());

            // AST REWRITE
            // elements: body
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 53:23: -> ^( MAIN body )
            {
                // /Users/kitsune/dev/ct/ct2/smallc.g:53:26: ^( MAIN body )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(MAIN, "MAIN")
                , root_1);

                adaptor.addChild(root_1, stream_body.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, main_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "main"


    public static class procedure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "procedure"
    // /Users/kitsune/dev/ct/ct2/smallc.g:56:1: procedure : (type= 'int' |type= 'char' )? IDENT '(' args ')' body -> ^( PROCEDURE ( ^( TYPE $type) )? ^( FUNCNAME IDENT ) args body ) ;
    public final smallcParser.procedure_return procedure() throws RecognitionException {
        smallcParser.procedure_return retval = new smallcParser.procedure_return();
        retval.start = input.LT(1);

        int procedure_StartIndex = input.index();

        Object root_0 = null;

        Token type=null;
        Token IDENT15=null;
        Token char_literal16=null;
        Token char_literal18=null;
        smallcParser.args_return args17 =null;

        smallcParser.body_return body19 =null;


        Object type_tree=null;
        Object IDENT15_tree=null;
        Object char_literal16_tree=null;
        Object char_literal18_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_body=new RewriteRuleSubtreeStream(adaptor,"rule body");
        RewriteRuleSubtreeStream stream_args=new RewriteRuleSubtreeStream(adaptor,"rule args");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:57:2: ( (type= 'int' |type= 'char' )? IDENT '(' args ')' body -> ^( PROCEDURE ( ^( TYPE $type) )? ^( FUNCNAME IDENT ) args body ) )
            // /Users/kitsune/dev/ct/ct2/smallc.g:57:3: (type= 'int' |type= 'char' )? IDENT '(' args ')' body
            {
            // /Users/kitsune/dev/ct/ct2/smallc.g:57:3: (type= 'int' |type= 'char' )?
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==50) ) {
                alt6=1;
            }
            else if ( (LA6_0==47) ) {
                alt6=2;
            }
            switch (alt6) {
                case 1 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:57:4: type= 'int'
                    {
                    type=(Token)match(input,50,FOLLOW_50_in_procedure285); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(type);


                    }
                    break;
                case 2 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:57:15: type= 'char'
                    {
                    type=(Token)match(input,47,FOLLOW_47_in_procedure289); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(type);


                    }
                    break;

            }


            IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_procedure293); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT15);


            char_literal16=(Token)match(input,33,FOLLOW_33_in_procedure295); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_33.add(char_literal16);


            pushFollow(FOLLOW_args_in_procedure297);
            args17=args();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_args.add(args17.getTree());

            char_literal18=(Token)match(input,34,FOLLOW_34_in_procedure299); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_34.add(char_literal18);


            pushFollow(FOLLOW_body_in_procedure301);
            body19=body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_body.add(body19.getTree());

            // AST REWRITE
            // elements: IDENT, body, args, type
            // token labels: type
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 57:53: -> ^( PROCEDURE ( ^( TYPE $type) )? ^( FUNCNAME IDENT ) args body )
            {
                // /Users/kitsune/dev/ct/ct2/smallc.g:57:56: ^( PROCEDURE ( ^( TYPE $type) )? ^( FUNCNAME IDENT ) args body )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROCEDURE, "PROCEDURE")
                , root_1);

                // /Users/kitsune/dev/ct/ct2/smallc.g:57:68: ( ^( TYPE $type) )?
                if ( stream_type.hasNext() ) {
                    // /Users/kitsune/dev/ct/ct2/smallc.g:57:68: ^( TYPE $type)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(
                    (Object)adaptor.create(TYPE, "TYPE")
                    , root_2);

                    adaptor.addChild(root_2, stream_type.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_type.reset();

                // /Users/kitsune/dev/ct/ct2/smallc.g:57:83: ^( FUNCNAME IDENT )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(FUNCNAME, "FUNCNAME")
                , root_2);

                adaptor.addChild(root_2, 
                stream_IDENT.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_1, stream_args.nextTree());

                adaptor.addChild(root_1, stream_body.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, procedure_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "procedure"


    public static class body_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "body"
    // /Users/kitsune/dev/ct/ct2/smallc.g:60:1: body : '{' decls stmtlist '}' -> ^( BODY decls stmtlist ) ;
    public final smallcParser.body_return body() throws RecognitionException {
        smallcParser.body_return retval = new smallcParser.body_return();
        retval.start = input.LT(1);

        int body_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal20=null;
        Token char_literal23=null;
        smallcParser.decls_return decls21 =null;

        smallcParser.stmtlist_return stmtlist22 =null;


        Object char_literal20_tree=null;
        Object char_literal23_tree=null;
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleSubtreeStream stream_stmtlist=new RewriteRuleSubtreeStream(adaptor,"rule stmtlist");
        RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:61:2: ( '{' decls stmtlist '}' -> ^( BODY decls stmtlist ) )
            // /Users/kitsune/dev/ct/ct2/smallc.g:61:3: '{' decls stmtlist '}'
            {
            char_literal20=(Token)match(input,59,FOLLOW_59_in_body336); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_59.add(char_literal20);


            pushFollow(FOLLOW_decls_in_body338);
            decls21=decls();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_decls.add(decls21.getTree());

            pushFollow(FOLLOW_stmtlist_in_body340);
            stmtlist22=stmtlist();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_stmtlist.add(stmtlist22.getTree());

            char_literal23=(Token)match(input,60,FOLLOW_60_in_body342); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_60.add(char_literal23);


            // AST REWRITE
            // elements: decls, stmtlist
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 61:26: -> ^( BODY decls stmtlist )
            {
                // /Users/kitsune/dev/ct/ct2/smallc.g:61:29: ^( BODY decls stmtlist )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(BODY, "BODY")
                , root_1);

                adaptor.addChild(root_1, stream_decls.nextTree());

                adaptor.addChild(root_1, stream_stmtlist.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, body_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "body"


    public static class args_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "args"
    // /Users/kitsune/dev/ct/ct2/smallc.g:64:1: args : ( typedident ( ',' typedident )* )? -> ^( ARGS ( typedident )* ) ;
    public final smallcParser.args_return args() throws RecognitionException {
        smallcParser.args_return retval = new smallcParser.args_return();
        retval.start = input.LT(1);

        int args_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal25=null;
        smallcParser.typedident_return typedident24 =null;

        smallcParser.typedident_return typedident26 =null;


        Object char_literal25_tree=null;
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleSubtreeStream stream_typedident=new RewriteRuleSubtreeStream(adaptor,"rule typedident");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:65:2: ( ( typedident ( ',' typedident )* )? -> ^( ARGS ( typedident )* ) )
            // /Users/kitsune/dev/ct/ct2/smallc.g:65:3: ( typedident ( ',' typedident )* )?
            {
            // /Users/kitsune/dev/ct/ct2/smallc.g:65:3: ( typedident ( ',' typedident )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==47||LA8_0==50) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:65:4: typedident ( ',' typedident )*
                    {
                    pushFollow(FOLLOW_typedident_in_args364);
                    typedident24=typedident();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typedident.add(typedident24.getTree());

                    // /Users/kitsune/dev/ct/ct2/smallc.g:65:15: ( ',' typedident )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==37) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/kitsune/dev/ct/ct2/smallc.g:65:16: ',' typedident
                    	    {
                    	    char_literal25=(Token)match(input,37,FOLLOW_37_in_args367); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_37.add(char_literal25);


                    	    pushFollow(FOLLOW_typedident_in_args369);
                    	    typedident26=typedident();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_typedident.add(typedident26.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }


            // AST REWRITE
            // elements: typedident
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 65:35: -> ^( ARGS ( typedident )* )
            {
                // /Users/kitsune/dev/ct/ct2/smallc.g:65:38: ^( ARGS ( typedident )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ARGS, "ARGS")
                , root_1);

                // /Users/kitsune/dev/ct/ct2/smallc.g:65:45: ( typedident )*
                while ( stream_typedident.hasNext() ) {
                    adaptor.addChild(root_1, stream_typedident.nextTree());

                }
                stream_typedident.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, args_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "args"


    public static class exp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "exp"
    // /Users/kitsune/dev/ct/ct2/smallc.g:68:1: exp : lexp ( ( '<' ^| '>' ^| '<=' ^| '>=' ^| '!=' ^| '==' ^) lexp )? ;
    public final smallcParser.exp_return exp() throws RecognitionException {
        smallcParser.exp_return retval = new smallcParser.exp_return();
        retval.start = input.LT(1);

        int exp_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal28=null;
        Token char_literal29=null;
        Token string_literal30=null;
        Token string_literal31=null;
        Token string_literal32=null;
        Token string_literal33=null;
        smallcParser.lexp_return lexp27 =null;

        smallcParser.lexp_return lexp34 =null;


        Object char_literal28_tree=null;
        Object char_literal29_tree=null;
        Object string_literal30_tree=null;
        Object string_literal31_tree=null;
        Object string_literal32_tree=null;
        Object string_literal33_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:69:2: ( lexp ( ( '<' ^| '>' ^| '<=' ^| '>=' ^| '!=' ^| '==' ^) lexp )? )
            // /Users/kitsune/dev/ct/ct2/smallc.g:69:3: lexp ( ( '<' ^| '>' ^| '<=' ^| '>=' ^| '!=' ^| '==' ^) lexp )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_lexp_in_exp393);
            lexp27=lexp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, lexp27.getTree());

            // /Users/kitsune/dev/ct/ct2/smallc.g:69:7: ( ( '<' ^| '>' ^| '<=' ^| '>=' ^| '!=' ^| '==' ^) lexp )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==30||(LA10_0 >= 41 && LA10_0 <= 42)||(LA10_0 >= 44 && LA10_0 <= 46)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:69:8: ( '<' ^| '>' ^| '<=' ^| '>=' ^| '!=' ^| '==' ^) lexp
                    {
                    // /Users/kitsune/dev/ct/ct2/smallc.g:69:8: ( '<' ^| '>' ^| '<=' ^| '>=' ^| '!=' ^| '==' ^)
                    int alt9=6;
                    switch ( input.LA(1) ) {
                    case 41:
                        {
                        alt9=1;
                        }
                        break;
                    case 45:
                        {
                        alt9=2;
                        }
                        break;
                    case 42:
                        {
                        alt9=3;
                        }
                        break;
                    case 46:
                        {
                        alt9=4;
                        }
                        break;
                    case 30:
                        {
                        alt9=5;
                        }
                        break;
                    case 44:
                        {
                        alt9=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;

                    }

                    switch (alt9) {
                        case 1 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:69:9: '<' ^
                            {
                            char_literal28=(Token)match(input,41,FOLLOW_41_in_exp396); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal28_tree = 
                            (Object)adaptor.create(char_literal28)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(char_literal28_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:69:14: '>' ^
                            {
                            char_literal29=(Token)match(input,45,FOLLOW_45_in_exp399); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal29_tree = 
                            (Object)adaptor.create(char_literal29)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(char_literal29_tree, root_0);
                            }

                            }
                            break;
                        case 3 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:69:19: '<=' ^
                            {
                            string_literal30=(Token)match(input,42,FOLLOW_42_in_exp402); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal30_tree = 
                            (Object)adaptor.create(string_literal30)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(string_literal30_tree, root_0);
                            }

                            }
                            break;
                        case 4 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:69:25: '>=' ^
                            {
                            string_literal31=(Token)match(input,46,FOLLOW_46_in_exp405); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal31_tree = 
                            (Object)adaptor.create(string_literal31)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(string_literal31_tree, root_0);
                            }

                            }
                            break;
                        case 5 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:69:31: '!=' ^
                            {
                            string_literal32=(Token)match(input,30,FOLLOW_30_in_exp408); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal32_tree = 
                            (Object)adaptor.create(string_literal32)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(string_literal32_tree, root_0);
                            }

                            }
                            break;
                        case 6 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:69:37: '==' ^
                            {
                            string_literal33=(Token)match(input,44,FOLLOW_44_in_exp411); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal33_tree = 
                            (Object)adaptor.create(string_literal33)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(string_literal33_tree, root_0);
                            }

                            }
                            break;

                    }


                    pushFollow(FOLLOW_lexp_in_exp415);
                    lexp34=lexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lexp34.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, exp_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "exp"


    public static class stmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stmt"
    // /Users/kitsune/dev/ct/ct2/smallc.g:72:1: stmt : ( '{' stmtlist '}' -> ^( STMT stmtlist ) | 'while' '(' exp ')' stmt -> ^( STMT 'while' exp stmt ) | 'if' '(' exp ')' stmt ( 'else' stmt )? -> ^( STMT 'if' exp stmt ( 'else' stmt )? ) | IDENT '=' lexp ';' -> ^( STMT ASSIGN ^( VAR IDENT ) lexp ) | 'read' '(' IDENT ')' ';' -> ^( STMT 'read' ^( VAR IDENT ) ) | 'output' '(' IDENT ')' ';' -> ^( STMT 'output' ^( VAR IDENT ) ) | 'print' '(' STRING ')' ';' -> ^( STMT 'print' ^( STR STRING ) ) | 'return' ( lexp )? ';' -> ^( STMT 'return' ( lexp )? ) | 'readc' '(' IDENT ')' ';' -> ^( STMT 'readc' ^( VAR IDENT ) ) | 'outputc' '(' IDENT ')' ';' -> ^( STMT 'outputc' ^( VAR IDENT ) ) | IDENT '(' ( IDENT ( ',' IDENT )* )? ')' ';' -> ^( STMT ^( FUNCNAME IDENT ) ^( PARAMS ( ^( VAR IDENT ) )* ) ) );
    public final smallcParser.stmt_return stmt() throws RecognitionException {
        smallcParser.stmt_return retval = new smallcParser.stmt_return();
        retval.start = input.LT(1);

        int stmt_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal35=null;
        Token char_literal37=null;
        Token string_literal38=null;
        Token char_literal39=null;
        Token char_literal41=null;
        Token string_literal43=null;
        Token char_literal44=null;
        Token char_literal46=null;
        Token string_literal48=null;
        Token IDENT50=null;
        Token char_literal51=null;
        Token char_literal53=null;
        Token string_literal54=null;
        Token char_literal55=null;
        Token IDENT56=null;
        Token char_literal57=null;
        Token char_literal58=null;
        Token string_literal59=null;
        Token char_literal60=null;
        Token IDENT61=null;
        Token char_literal62=null;
        Token char_literal63=null;
        Token string_literal64=null;
        Token char_literal65=null;
        Token STRING66=null;
        Token char_literal67=null;
        Token char_literal68=null;
        Token string_literal69=null;
        Token char_literal71=null;
        Token string_literal72=null;
        Token char_literal73=null;
        Token IDENT74=null;
        Token char_literal75=null;
        Token char_literal76=null;
        Token string_literal77=null;
        Token char_literal78=null;
        Token IDENT79=null;
        Token char_literal80=null;
        Token char_literal81=null;
        Token IDENT82=null;
        Token char_literal83=null;
        Token IDENT84=null;
        Token char_literal85=null;
        Token IDENT86=null;
        Token char_literal87=null;
        Token char_literal88=null;
        smallcParser.stmtlist_return stmtlist36 =null;

        smallcParser.exp_return exp40 =null;

        smallcParser.stmt_return stmt42 =null;

        smallcParser.exp_return exp45 =null;

        smallcParser.stmt_return stmt47 =null;

        smallcParser.stmt_return stmt49 =null;

        smallcParser.lexp_return lexp52 =null;

        smallcParser.lexp_return lexp70 =null;


        Object char_literal35_tree=null;
        Object char_literal37_tree=null;
        Object string_literal38_tree=null;
        Object char_literal39_tree=null;
        Object char_literal41_tree=null;
        Object string_literal43_tree=null;
        Object char_literal44_tree=null;
        Object char_literal46_tree=null;
        Object string_literal48_tree=null;
        Object IDENT50_tree=null;
        Object char_literal51_tree=null;
        Object char_literal53_tree=null;
        Object string_literal54_tree=null;
        Object char_literal55_tree=null;
        Object IDENT56_tree=null;
        Object char_literal57_tree=null;
        Object char_literal58_tree=null;
        Object string_literal59_tree=null;
        Object char_literal60_tree=null;
        Object IDENT61_tree=null;
        Object char_literal62_tree=null;
        Object char_literal63_tree=null;
        Object string_literal64_tree=null;
        Object char_literal65_tree=null;
        Object STRING66_tree=null;
        Object char_literal67_tree=null;
        Object char_literal68_tree=null;
        Object string_literal69_tree=null;
        Object char_literal71_tree=null;
        Object string_literal72_tree=null;
        Object char_literal73_tree=null;
        Object IDENT74_tree=null;
        Object char_literal75_tree=null;
        Object char_literal76_tree=null;
        Object string_literal77_tree=null;
        Object char_literal78_tree=null;
        Object IDENT79_tree=null;
        Object char_literal80_tree=null;
        Object char_literal81_tree=null;
        Object IDENT82_tree=null;
        Object char_literal83_tree=null;
        Object IDENT84_tree=null;
        Object char_literal85_tree=null;
        Object IDENT86_tree=null;
        Object char_literal87_tree=null;
        Object char_literal88_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_stmtlist=new RewriteRuleSubtreeStream(adaptor,"rule stmtlist");
        RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp");
        RewriteRuleSubtreeStream stream_stmt=new RewriteRuleSubtreeStream(adaptor,"rule stmt");
        RewriteRuleSubtreeStream stream_lexp=new RewriteRuleSubtreeStream(adaptor,"rule lexp");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:73:2: ( '{' stmtlist '}' -> ^( STMT stmtlist ) | 'while' '(' exp ')' stmt -> ^( STMT 'while' exp stmt ) | 'if' '(' exp ')' stmt ( 'else' stmt )? -> ^( STMT 'if' exp stmt ( 'else' stmt )? ) | IDENT '=' lexp ';' -> ^( STMT ASSIGN ^( VAR IDENT ) lexp ) | 'read' '(' IDENT ')' ';' -> ^( STMT 'read' ^( VAR IDENT ) ) | 'output' '(' IDENT ')' ';' -> ^( STMT 'output' ^( VAR IDENT ) ) | 'print' '(' STRING ')' ';' -> ^( STMT 'print' ^( STR STRING ) ) | 'return' ( lexp )? ';' -> ^( STMT 'return' ( lexp )? ) | 'readc' '(' IDENT ')' ';' -> ^( STMT 'readc' ^( VAR IDENT ) ) | 'outputc' '(' IDENT ')' ';' -> ^( STMT 'outputc' ^( VAR IDENT ) ) | IDENT '(' ( IDENT ( ',' IDENT )* )? ')' ';' -> ^( STMT ^( FUNCNAME IDENT ) ^( PARAMS ( ^( VAR IDENT ) )* ) ) )
            int alt15=11;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt15=1;
                }
                break;
            case 58:
                {
                alt15=2;
                }
                break;
            case 49:
                {
                alt15=3;
                }
                break;
            case IDENT:
                {
                int LA15_4 = input.LA(2);

                if ( (LA15_4==43) ) {
                    alt15=4;
                }
                else if ( (LA15_4==33) ) {
                    alt15=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 4, input);

                    throw nvae;

                }
                }
                break;
            case 55:
                {
                alt15=5;
                }
                break;
            case 52:
                {
                alt15=6;
                }
                break;
            case 54:
                {
                alt15=7;
                }
                break;
            case 57:
                {
                alt15=8;
                }
                break;
            case 56:
                {
                alt15=9;
                }
                break;
            case 53:
                {
                alt15=10;
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
                    // /Users/kitsune/dev/ct/ct2/smallc.g:73:3: '{' stmtlist '}'
                    {
                    char_literal35=(Token)match(input,59,FOLLOW_59_in_stmt428); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_59.add(char_literal35);


                    pushFollow(FOLLOW_stmtlist_in_stmt430);
                    stmtlist36=stmtlist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stmtlist.add(stmtlist36.getTree());

                    char_literal37=(Token)match(input,60,FOLLOW_60_in_stmt432); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_60.add(char_literal37);


                    // AST REWRITE
                    // elements: stmtlist
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 73:21: -> ^( STMT stmtlist )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:73:24: ^( STMT stmtlist )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, stream_stmtlist.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:74:3: 'while' '(' exp ')' stmt
                    {
                    string_literal38=(Token)match(input,58,FOLLOW_58_in_stmt445); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(string_literal38);


                    char_literal39=(Token)match(input,33,FOLLOW_33_in_stmt447); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal39);


                    pushFollow(FOLLOW_exp_in_stmt449);
                    exp40=exp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_exp.add(exp40.getTree());

                    char_literal41=(Token)match(input,34,FOLLOW_34_in_stmt451); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal41);


                    pushFollow(FOLLOW_stmt_in_stmt453);
                    stmt42=stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stmt.add(stmt42.getTree());

                    // AST REWRITE
                    // elements: stmt, exp, 58
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 74:28: -> ^( STMT 'while' exp stmt )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:74:31: ^( STMT 'while' exp stmt )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_58.nextNode()
                        );

                        adaptor.addChild(root_1, stream_exp.nextTree());

                        adaptor.addChild(root_1, stream_stmt.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:75:3: 'if' '(' exp ')' stmt ( 'else' stmt )?
                    {
                    string_literal43=(Token)match(input,49,FOLLOW_49_in_stmt469); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal43);


                    char_literal44=(Token)match(input,33,FOLLOW_33_in_stmt471); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal44);


                    pushFollow(FOLLOW_exp_in_stmt473);
                    exp45=exp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_exp.add(exp45.getTree());

                    char_literal46=(Token)match(input,34,FOLLOW_34_in_stmt475); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal46);


                    pushFollow(FOLLOW_stmt_in_stmt477);
                    stmt47=stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stmt.add(stmt47.getTree());

                    // /Users/kitsune/dev/ct/ct2/smallc.g:75:25: ( 'else' stmt )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==48) ) {
                        int LA11_1 = input.LA(2);

                        if ( (synpred18_smallc()) ) {
                            alt11=1;
                        }
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:75:26: 'else' stmt
                            {
                            string_literal48=(Token)match(input,48,FOLLOW_48_in_stmt480); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_48.add(string_literal48);


                            pushFollow(FOLLOW_stmt_in_stmt482);
                            stmt49=stmt();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_stmt.add(stmt49.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: 48, stmt, stmt, exp, 49
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 75:40: -> ^( STMT 'if' exp stmt ( 'else' stmt )? )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:75:43: ^( STMT 'if' exp stmt ( 'else' stmt )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_49.nextNode()
                        );

                        adaptor.addChild(root_1, stream_exp.nextTree());

                        adaptor.addChild(root_1, stream_stmt.nextTree());

                        // /Users/kitsune/dev/ct/ct2/smallc.g:75:64: ( 'else' stmt )?
                        if ( stream_48.hasNext()||stream_stmt.hasNext() ) {
                            adaptor.addChild(root_1, 
                            stream_48.nextNode()
                            );

                            adaptor.addChild(root_1, stream_stmt.nextTree());

                        }
                        stream_48.reset();
                        stream_stmt.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:76:3: IDENT '=' lexp ';'
                    {
                    IDENT50=(Token)match(input,IDENT,FOLLOW_IDENT_in_stmt507); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT50);


                    char_literal51=(Token)match(input,43,FOLLOW_43_in_stmt509); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal51);


                    pushFollow(FOLLOW_lexp_in_stmt511);
                    lexp52=lexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lexp.add(lexp52.getTree());

                    char_literal53=(Token)match(input,40,FOLLOW_40_in_stmt513); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal53);


                    // AST REWRITE
                    // elements: IDENT, lexp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 76:22: -> ^( STMT ASSIGN ^( VAR IDENT ) lexp )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:76:25: ^( STMT ASSIGN ^( VAR IDENT ) lexp )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        (Object)adaptor.create(ASSIGN, "ASSIGN")
                        );

                        // /Users/kitsune/dev/ct/ct2/smallc.g:76:39: ^( VAR IDENT )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(VAR, "VAR")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENT.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, stream_lexp.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:77:3: 'read' '(' IDENT ')' ';'
                    {
                    string_literal54=(Token)match(input,55,FOLLOW_55_in_stmt533); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(string_literal54);


                    char_literal55=(Token)match(input,33,FOLLOW_33_in_stmt535); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal55);


                    IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_stmt537); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT56);


                    char_literal57=(Token)match(input,34,FOLLOW_34_in_stmt539); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal57);


                    char_literal58=(Token)match(input,40,FOLLOW_40_in_stmt541); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal58);


                    // AST REWRITE
                    // elements: 55, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 77:28: -> ^( STMT 'read' ^( VAR IDENT ) )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:77:31: ^( STMT 'read' ^( VAR IDENT ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_55.nextNode()
                        );

                        // /Users/kitsune/dev/ct/ct2/smallc.g:77:45: ^( VAR IDENT )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(VAR, "VAR")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENT.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 6 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:78:3: 'output' '(' IDENT ')' ';'
                    {
                    string_literal59=(Token)match(input,52,FOLLOW_52_in_stmt559); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_52.add(string_literal59);


                    char_literal60=(Token)match(input,33,FOLLOW_33_in_stmt561); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal60);


                    IDENT61=(Token)match(input,IDENT,FOLLOW_IDENT_in_stmt563); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT61);


                    char_literal62=(Token)match(input,34,FOLLOW_34_in_stmt565); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal62);


                    char_literal63=(Token)match(input,40,FOLLOW_40_in_stmt567); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal63);


                    // AST REWRITE
                    // elements: 52, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 78:30: -> ^( STMT 'output' ^( VAR IDENT ) )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:78:33: ^( STMT 'output' ^( VAR IDENT ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_52.nextNode()
                        );

                        // /Users/kitsune/dev/ct/ct2/smallc.g:78:49: ^( VAR IDENT )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(VAR, "VAR")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENT.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 7 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:79:3: 'print' '(' STRING ')' ';'
                    {
                    string_literal64=(Token)match(input,54,FOLLOW_54_in_stmt585); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(string_literal64);


                    char_literal65=(Token)match(input,33,FOLLOW_33_in_stmt587); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal65);


                    STRING66=(Token)match(input,STRING,FOLLOW_STRING_in_stmt589); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING66);


                    char_literal67=(Token)match(input,34,FOLLOW_34_in_stmt591); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal67);


                    char_literal68=(Token)match(input,40,FOLLOW_40_in_stmt593); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal68);


                    // AST REWRITE
                    // elements: STRING, 54
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 79:30: -> ^( STMT 'print' ^( STR STRING ) )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:79:33: ^( STMT 'print' ^( STR STRING ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_54.nextNode()
                        );

                        // /Users/kitsune/dev/ct/ct2/smallc.g:79:48: ^( STR STRING )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STR, "STR")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_STRING.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 8 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:80:3: 'return' ( lexp )? ';'
                    {
                    string_literal69=(Token)match(input,57,FOLLOW_57_in_stmt611); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal69);


                    // /Users/kitsune/dev/ct/ct2/smallc.g:80:12: ( lexp )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==CHARACTER||LA12_0==IDENT||LA12_0==NUMBER||LA12_0==33||LA12_0==38) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:80:12: lexp
                            {
                            pushFollow(FOLLOW_lexp_in_stmt613);
                            lexp70=lexp();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_lexp.add(lexp70.getTree());

                            }
                            break;

                    }


                    char_literal71=(Token)match(input,40,FOLLOW_40_in_stmt616); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal71);


                    // AST REWRITE
                    // elements: 57, lexp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 80:22: -> ^( STMT 'return' ( lexp )? )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:80:25: ^( STMT 'return' ( lexp )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_57.nextNode()
                        );

                        // /Users/kitsune/dev/ct/ct2/smallc.g:80:41: ( lexp )?
                        if ( stream_lexp.hasNext() ) {
                            adaptor.addChild(root_1, stream_lexp.nextTree());

                        }
                        stream_lexp.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 9 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:81:3: 'readc' '(' IDENT ')' ';'
                    {
                    string_literal72=(Token)match(input,56,FOLLOW_56_in_stmt631); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(string_literal72);


                    char_literal73=(Token)match(input,33,FOLLOW_33_in_stmt633); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal73);


                    IDENT74=(Token)match(input,IDENT,FOLLOW_IDENT_in_stmt635); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT74);


                    char_literal75=(Token)match(input,34,FOLLOW_34_in_stmt637); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal75);


                    char_literal76=(Token)match(input,40,FOLLOW_40_in_stmt639); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal76);


                    // AST REWRITE
                    // elements: 56, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 81:29: -> ^( STMT 'readc' ^( VAR IDENT ) )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:81:32: ^( STMT 'readc' ^( VAR IDENT ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_56.nextNode()
                        );

                        // /Users/kitsune/dev/ct/ct2/smallc.g:81:47: ^( VAR IDENT )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(VAR, "VAR")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENT.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 10 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:82:3: 'outputc' '(' IDENT ')' ';'
                    {
                    string_literal77=(Token)match(input,53,FOLLOW_53_in_stmt657); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(string_literal77);


                    char_literal78=(Token)match(input,33,FOLLOW_33_in_stmt659); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal78);


                    IDENT79=(Token)match(input,IDENT,FOLLOW_IDENT_in_stmt661); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT79);


                    char_literal80=(Token)match(input,34,FOLLOW_34_in_stmt663); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal80);


                    char_literal81=(Token)match(input,40,FOLLOW_40_in_stmt665); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal81);


                    // AST REWRITE
                    // elements: IDENT, 53
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 82:31: -> ^( STMT 'outputc' ^( VAR IDENT ) )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:82:34: ^( STMT 'outputc' ^( VAR IDENT ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_53.nextNode()
                        );

                        // /Users/kitsune/dev/ct/ct2/smallc.g:82:51: ^( VAR IDENT )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(VAR, "VAR")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENT.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 11 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:83:3: IDENT '(' ( IDENT ( ',' IDENT )* )? ')' ';'
                    {
                    IDENT82=(Token)match(input,IDENT,FOLLOW_IDENT_in_stmt683); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT82);


                    char_literal83=(Token)match(input,33,FOLLOW_33_in_stmt685); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal83);


                    // /Users/kitsune/dev/ct/ct2/smallc.g:83:13: ( IDENT ( ',' IDENT )* )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==IDENT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:83:14: IDENT ( ',' IDENT )*
                            {
                            IDENT84=(Token)match(input,IDENT,FOLLOW_IDENT_in_stmt688); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENT.add(IDENT84);


                            // /Users/kitsune/dev/ct/ct2/smallc.g:83:20: ( ',' IDENT )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==37) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // /Users/kitsune/dev/ct/ct2/smallc.g:83:21: ',' IDENT
                            	    {
                            	    char_literal85=(Token)match(input,37,FOLLOW_37_in_stmt691); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_37.add(char_literal85);


                            	    IDENT86=(Token)match(input,IDENT,FOLLOW_IDENT_in_stmt693); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_IDENT.add(IDENT86);


                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);


                            }
                            break;

                    }


                    char_literal87=(Token)match(input,34,FOLLOW_34_in_stmt699); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal87);


                    char_literal88=(Token)match(input,40,FOLLOW_40_in_stmt701); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal88);


                    // AST REWRITE
                    // elements: IDENT, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 83:43: -> ^( STMT ^( FUNCNAME IDENT ) ^( PARAMS ( ^( VAR IDENT ) )* ) )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:83:46: ^( STMT ^( FUNCNAME IDENT ) ^( PARAMS ( ^( VAR IDENT ) )* ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        // /Users/kitsune/dev/ct/ct2/smallc.g:83:53: ^( FUNCNAME IDENT )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(FUNCNAME, "FUNCNAME")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENT.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        // /Users/kitsune/dev/ct/ct2/smallc.g:83:71: ^( PARAMS ( ^( VAR IDENT ) )* )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(PARAMS, "PARAMS")
                        , root_2);

                        // /Users/kitsune/dev/ct/ct2/smallc.g:83:80: ( ^( VAR IDENT ) )*
                        while ( stream_IDENT.hasNext() ) {
                            // /Users/kitsune/dev/ct/ct2/smallc.g:83:80: ^( VAR IDENT )
                            {
                            Object root_3 = (Object)adaptor.nil();
                            root_3 = (Object)adaptor.becomeRoot(
                            (Object)adaptor.create(VAR, "VAR")
                            , root_3);

                            adaptor.addChild(root_3, 
                            stream_IDENT.nextNode()
                            );

                            adaptor.addChild(root_2, root_3);
                            }

                        }
                        stream_IDENT.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, stmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "stmt"


    public static class lexp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexp"
    // /Users/kitsune/dev/ct/ct2/smallc.g:86:1: lexp : term ( ( '+' ^| '-' ^) term )* ;
    public final smallcParser.lexp_return lexp() throws RecognitionException {
        smallcParser.lexp_return retval = new smallcParser.lexp_return();
        retval.start = input.LT(1);

        int lexp_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal90=null;
        Token char_literal91=null;
        smallcParser.term_return term89 =null;

        smallcParser.term_return term92 =null;


        Object char_literal90_tree=null;
        Object char_literal91_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:87:2: ( term ( ( '+' ^| '-' ^) term )* )
            // /Users/kitsune/dev/ct/ct2/smallc.g:87:3: term ( ( '+' ^| '-' ^) term )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_term_in_lexp735);
            term89=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term89.getTree());

            // /Users/kitsune/dev/ct/ct2/smallc.g:87:8: ( ( '+' ^| '-' ^) term )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==36||LA17_0==38) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:87:9: ( '+' ^| '-' ^) term
            	    {
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:87:9: ( '+' ^| '-' ^)
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==36) ) {
            	        alt16=1;
            	    }
            	    else if ( (LA16_0==38) ) {
            	        alt16=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // /Users/kitsune/dev/ct/ct2/smallc.g:87:10: '+' ^
            	            {
            	            char_literal90=(Token)match(input,36,FOLLOW_36_in_lexp739); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal90_tree = 
            	            (Object)adaptor.create(char_literal90)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal90_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/kitsune/dev/ct/ct2/smallc.g:87:15: '-' ^
            	            {
            	            char_literal91=(Token)match(input,38,FOLLOW_38_in_lexp742); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal91_tree = 
            	            (Object)adaptor.create(char_literal91)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal91_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_term_in_lexp746);
            	    term92=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term92.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, lexp_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "lexp"


    public static class term_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // /Users/kitsune/dev/ct/ct2/smallc.g:91:1: term : factor ( ( '/' ^| '*' ^| '%' ^) factor )* ;
    public final smallcParser.term_return term() throws RecognitionException {
        smallcParser.term_return retval = new smallcParser.term_return();
        retval.start = input.LT(1);

        int term_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal94=null;
        Token char_literal95=null;
        Token char_literal96=null;
        smallcParser.factor_return factor93 =null;

        smallcParser.factor_return factor97 =null;


        Object char_literal94_tree=null;
        Object char_literal95_tree=null;
        Object char_literal96_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:92:2: ( factor ( ( '/' ^| '*' ^| '%' ^) factor )* )
            // /Users/kitsune/dev/ct/ct2/smallc.g:92:4: factor ( ( '/' ^| '*' ^| '%' ^) factor )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_factor_in_term761);
            factor93=factor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor93.getTree());

            // /Users/kitsune/dev/ct/ct2/smallc.g:92:11: ( ( '/' ^| '*' ^| '%' ^) factor )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==32||LA19_0==35||LA19_0==39) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:92:12: ( '/' ^| '*' ^| '%' ^) factor
            	    {
            	    // /Users/kitsune/dev/ct/ct2/smallc.g:92:12: ( '/' ^| '*' ^| '%' ^)
            	    int alt18=3;
            	    switch ( input.LA(1) ) {
            	    case 39:
            	        {
            	        alt18=1;
            	        }
            	        break;
            	    case 35:
            	        {
            	        alt18=2;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt18=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt18) {
            	        case 1 :
            	            // /Users/kitsune/dev/ct/ct2/smallc.g:92:13: '/' ^
            	            {
            	            char_literal94=(Token)match(input,39,FOLLOW_39_in_term765); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal94_tree = 
            	            (Object)adaptor.create(char_literal94)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal94_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/kitsune/dev/ct/ct2/smallc.g:92:18: '*' ^
            	            {
            	            char_literal95=(Token)match(input,35,FOLLOW_35_in_term768); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal95_tree = 
            	            (Object)adaptor.create(char_literal95)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal95_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/kitsune/dev/ct/ct2/smallc.g:92:23: '%' ^
            	            {
            	            char_literal96=(Token)match(input,32,FOLLOW_32_in_term771); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal96_tree = 
            	            (Object)adaptor.create(char_literal96)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal96_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_factor_in_term775);
            	    factor97=factor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, factor97.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, term_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "term"


    public static class factor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "factor"
    // /Users/kitsune/dev/ct/ct2/smallc.g:95:1: factor : ( '(' lexp ')' -> lexp | (var= IDENT |var= NUMBER ) -> ^( VAR $var) | '-' (var= IDENT |var= NUMBER ) -> ^( NEGATE ^( VAR $var) ) | CHARACTER -> ^( CHR CHARACTER ) | IDENT '(' ( IDENT ( ',' IDENT )* )? ')' -> ^( STMT ^( FUNCNAME IDENT ) ^( PARAMS ( ^( VAR IDENT ) )* ) ) );
    public final smallcParser.factor_return factor() throws RecognitionException {
        smallcParser.factor_return retval = new smallcParser.factor_return();
        retval.start = input.LT(1);

        int factor_StartIndex = input.index();

        Object root_0 = null;

        Token var=null;
        Token char_literal98=null;
        Token char_literal100=null;
        Token char_literal101=null;
        Token CHARACTER102=null;
        Token IDENT103=null;
        Token char_literal104=null;
        Token IDENT105=null;
        Token char_literal106=null;
        Token IDENT107=null;
        Token char_literal108=null;
        smallcParser.lexp_return lexp99 =null;


        Object var_tree=null;
        Object char_literal98_tree=null;
        Object char_literal100_tree=null;
        Object char_literal101_tree=null;
        Object CHARACTER102_tree=null;
        Object IDENT103_tree=null;
        Object char_literal104_tree=null;
        Object IDENT105_tree=null;
        Object char_literal106_tree=null;
        Object IDENT107_tree=null;
        Object char_literal108_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleTokenStream stream_CHARACTER=new RewriteRuleTokenStream(adaptor,"token CHARACTER");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleSubtreeStream stream_lexp=new RewriteRuleSubtreeStream(adaptor,"rule lexp");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // /Users/kitsune/dev/ct/ct2/smallc.g:96:2: ( '(' lexp ')' -> lexp | (var= IDENT |var= NUMBER ) -> ^( VAR $var) | '-' (var= IDENT |var= NUMBER ) -> ^( NEGATE ^( VAR $var) ) | CHARACTER -> ^( CHR CHARACTER ) | IDENT '(' ( IDENT ( ',' IDENT )* )? ')' -> ^( STMT ^( FUNCNAME IDENT ) ^( PARAMS ( ^( VAR IDENT ) )* ) ) )
            int alt24=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt24=1;
                }
                break;
            case IDENT:
                {
                int LA24_2 = input.LA(2);

                if ( (LA24_2==33) ) {
                    alt24=5;
                }
                else if ( (LA24_2==EOF||LA24_2==30||LA24_2==32||(LA24_2 >= 34 && LA24_2 <= 36)||(LA24_2 >= 38 && LA24_2 <= 42)||(LA24_2 >= 44 && LA24_2 <= 46)) ) {
                    alt24=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 2, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                alt24=2;
                }
                break;
            case 38:
                {
                alt24=3;
                }
                break;
            case CHARACTER:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:96:3: '(' lexp ')'
                    {
                    char_literal98=(Token)match(input,33,FOLLOW_33_in_factor788); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal98);


                    pushFollow(FOLLOW_lexp_in_factor790);
                    lexp99=lexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lexp.add(lexp99.getTree());

                    char_literal100=(Token)match(input,34,FOLLOW_34_in_factor792); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal100);


                    // AST REWRITE
                    // elements: lexp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 96:16: -> lexp
                    {
                        adaptor.addChild(root_0, stream_lexp.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:97:3: (var= IDENT |var= NUMBER )
                    {
                    // /Users/kitsune/dev/ct/ct2/smallc.g:97:3: (var= IDENT |var= NUMBER )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==IDENT) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==NUMBER) ) {
                        alt20=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;

                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:97:4: var= IDENT
                            {
                            var=(Token)match(input,IDENT,FOLLOW_IDENT_in_factor803); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENT.add(var);


                            }
                            break;
                        case 2 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:97:14: var= NUMBER
                            {
                            var=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_factor807); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_NUMBER.add(var);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: var
                    // token labels: var
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_var=new RewriteRuleTokenStream(adaptor,"token var",var);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 97:26: -> ^( VAR $var)
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:97:29: ^( VAR $var)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(VAR, "VAR")
                        , root_1);

                        adaptor.addChild(root_1, stream_var.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:98:3: '-' (var= IDENT |var= NUMBER )
                    {
                    char_literal101=(Token)match(input,38,FOLLOW_38_in_factor821); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal101);


                    // /Users/kitsune/dev/ct/ct2/smallc.g:98:7: (var= IDENT |var= NUMBER )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==IDENT) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==NUMBER) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;

                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:98:8: var= IDENT
                            {
                            var=(Token)match(input,IDENT,FOLLOW_IDENT_in_factor826); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENT.add(var);


                            }
                            break;
                        case 2 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:98:18: var= NUMBER
                            {
                            var=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_factor830); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_NUMBER.add(var);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: var
                    // token labels: var
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_var=new RewriteRuleTokenStream(adaptor,"token var",var);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 98:30: -> ^( NEGATE ^( VAR $var) )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:98:33: ^( NEGATE ^( VAR $var) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(NEGATE, "NEGATE")
                        , root_1);

                        // /Users/kitsune/dev/ct/ct2/smallc.g:98:42: ^( VAR $var)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(VAR, "VAR")
                        , root_2);

                        adaptor.addChild(root_2, stream_var.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:99:3: CHARACTER
                    {
                    CHARACTER102=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_factor848); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHARACTER.add(CHARACTER102);


                    // AST REWRITE
                    // elements: CHARACTER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 99:13: -> ^( CHR CHARACTER )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:99:16: ^( CHR CHARACTER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(CHR, "CHR")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_CHARACTER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // /Users/kitsune/dev/ct/ct2/smallc.g:100:3: IDENT '(' ( IDENT ( ',' IDENT )* )? ')'
                    {
                    IDENT103=(Token)match(input,IDENT,FOLLOW_IDENT_in_factor860); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT103);


                    char_literal104=(Token)match(input,33,FOLLOW_33_in_factor862); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_33.add(char_literal104);


                    // /Users/kitsune/dev/ct/ct2/smallc.g:100:13: ( IDENT ( ',' IDENT )* )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==IDENT) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/kitsune/dev/ct/ct2/smallc.g:100:14: IDENT ( ',' IDENT )*
                            {
                            IDENT105=(Token)match(input,IDENT,FOLLOW_IDENT_in_factor865); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENT.add(IDENT105);


                            // /Users/kitsune/dev/ct/ct2/smallc.g:100:20: ( ',' IDENT )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==37) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // /Users/kitsune/dev/ct/ct2/smallc.g:100:21: ',' IDENT
                            	    {
                            	    char_literal106=(Token)match(input,37,FOLLOW_37_in_factor868); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_37.add(char_literal106);


                            	    IDENT107=(Token)match(input,IDENT,FOLLOW_IDENT_in_factor870); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_IDENT.add(IDENT107);


                            	    }
                            	    break;

                            	default :
                            	    break loop22;
                                }
                            } while (true);


                            }
                            break;

                    }


                    char_literal108=(Token)match(input,34,FOLLOW_34_in_factor876); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal108);


                    // AST REWRITE
                    // elements: IDENT, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 100:39: -> ^( STMT ^( FUNCNAME IDENT ) ^( PARAMS ( ^( VAR IDENT ) )* ) )
                    {
                        // /Users/kitsune/dev/ct/ct2/smallc.g:100:43: ^( STMT ^( FUNCNAME IDENT ) ^( PARAMS ( ^( VAR IDENT ) )* ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STMT, "STMT")
                        , root_1);

                        // /Users/kitsune/dev/ct/ct2/smallc.g:100:50: ^( FUNCNAME IDENT )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(FUNCNAME, "FUNCNAME")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENT.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        // /Users/kitsune/dev/ct/ct2/smallc.g:100:68: ^( PARAMS ( ^( VAR IDENT ) )* )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(PARAMS, "PARAMS")
                        , root_2);

                        // /Users/kitsune/dev/ct/ct2/smallc.g:100:77: ( ^( VAR IDENT ) )*
                        while ( stream_IDENT.hasNext() ) {
                            // /Users/kitsune/dev/ct/ct2/smallc.g:100:77: ^( VAR IDENT )
                            {
                            Object root_3 = (Object)adaptor.nil();
                            root_3 = (Object)adaptor.becomeRoot(
                            (Object)adaptor.create(VAR, "VAR")
                            , root_3);

                            adaptor.addChild(root_3, 
                            stream_IDENT.nextNode()
                            );

                            adaptor.addChild(root_2, root_3);
                            }

                        }
                        stream_IDENT.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, factor_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "factor"

    // $ANTLR start synpred18_smallc
    public final void synpred18_smallc_fragment() throws RecognitionException {
        // /Users/kitsune/dev/ct/ct2/smallc.g:75:26: ( 'else' stmt )
        // /Users/kitsune/dev/ct/ct2/smallc.g:75:26: 'else' stmt
        {
        match(input,48,FOLLOW_48_in_synpred18_smallc480); if (state.failed) return ;

        pushFollow(FOLLOW_stmt_in_synpred18_smallc482);
        stmt();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred18_smallc

    // Delegated rules

    public final boolean synpred18_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_includes_in_program122 = new BitSet(new long[]{0x000C800000002000L});
    public static final BitSet FOLLOW_decls_in_program124 = new BitSet(new long[]{0x000C800000002000L});
    public static final BitSet FOLLOW_procedure_in_program126 = new BitSet(new long[]{0x000C800000002000L});
    public static final BitSet FOLLOW_main_in_program129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_includes154 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_STRING_in_includes156 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_typedident_in_decls170 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_decls172 = new BitSet(new long[]{0x0004800000000002L});
    public static final BitSet FOLLOW_50_in_typedident199 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_47_in_typedident203 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_typedident206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stmt_in_stmtlist236 = new BitSet(new long[]{0x0FF2000000002002L});
    public static final BitSet FOLLOW_51_in_main257 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_main259 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_main261 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_body_in_main263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_procedure285 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_47_in_procedure289 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_procedure293 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_procedure295 = new BitSet(new long[]{0x0004800400000000L});
    public static final BitSet FOLLOW_args_in_procedure297 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_procedure299 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_body_in_procedure301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_body336 = new BitSet(new long[]{0x1FF6800000002000L});
    public static final BitSet FOLLOW_decls_in_body338 = new BitSet(new long[]{0x1FF2000000002000L});
    public static final BitSet FOLLOW_stmtlist_in_body340 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_body342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typedident_in_args364 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_args367 = new BitSet(new long[]{0x0004800000000000L});
    public static final BitSet FOLLOW_typedident_in_args369 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_lexp_in_exp393 = new BitSet(new long[]{0x0000760040000002L});
    public static final BitSet FOLLOW_41_in_exp396 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_45_in_exp399 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_42_in_exp402 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_46_in_exp405 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_30_in_exp408 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_44_in_exp411 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_lexp_in_exp415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_stmt428 = new BitSet(new long[]{0x1FF2000000002000L});
    public static final BitSet FOLLOW_stmtlist_in_stmt430 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_stmt432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_stmt445 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_stmt447 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_exp_in_stmt449 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_stmt451 = new BitSet(new long[]{0x0FF2000000002000L});
    public static final BitSet FOLLOW_stmt_in_stmt453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_stmt469 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_stmt471 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_exp_in_stmt473 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_stmt475 = new BitSet(new long[]{0x0FF2000000002000L});
    public static final BitSet FOLLOW_stmt_in_stmt477 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_stmt480 = new BitSet(new long[]{0x0FF2000000002000L});
    public static final BitSet FOLLOW_stmt_in_stmt482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_stmt507 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_stmt509 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_lexp_in_stmt511 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_stmt513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_stmt533 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_stmt535 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_stmt537 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_stmt539 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_stmt541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_stmt559 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_stmt561 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_stmt563 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_stmt565 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_stmt567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_stmt585 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_stmt587 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_STRING_in_stmt589 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_stmt591 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_stmt593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_stmt611 = new BitSet(new long[]{0x0000014200022080L});
    public static final BitSet FOLLOW_lexp_in_stmt613 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_stmt616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_stmt631 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_stmt633 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_stmt635 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_stmt637 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_stmt639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_stmt657 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_stmt659 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_stmt661 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_stmt663 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_stmt665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_stmt683 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_stmt685 = new BitSet(new long[]{0x0000000400002000L});
    public static final BitSet FOLLOW_IDENT_in_stmt688 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_37_in_stmt691 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_stmt693 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_34_in_stmt699 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_stmt701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_lexp735 = new BitSet(new long[]{0x0000005000000002L});
    public static final BitSet FOLLOW_36_in_lexp739 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_38_in_lexp742 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_term_in_lexp746 = new BitSet(new long[]{0x0000005000000002L});
    public static final BitSet FOLLOW_factor_in_term761 = new BitSet(new long[]{0x0000008900000002L});
    public static final BitSet FOLLOW_39_in_term765 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_35_in_term768 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_32_in_term771 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_factor_in_term775 = new BitSet(new long[]{0x0000008900000002L});
    public static final BitSet FOLLOW_33_in_factor788 = new BitSet(new long[]{0x0000004200022080L});
    public static final BitSet FOLLOW_lexp_in_factor790 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_factor792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_factor803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_factor807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_factor821 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_IDENT_in_factor826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_factor830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_factor848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_factor860 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_factor862 = new BitSet(new long[]{0x0000000400002000L});
    public static final BitSet FOLLOW_IDENT_in_factor865 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_37_in_factor868 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_factor870 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_34_in_factor876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred18_smallc480 = new BitSet(new long[]{0x0FF2000000002000L});
    public static final BitSet FOLLOW_stmt_in_synpred18_smallc482 = new BitSet(new long[]{0x0000000000000002L});

}