package no.esito.genova.io.antlr;

import java.io.IOException;
import java.util.Date;


import no.esito.genova.io.antlr.TmplParser.prog_return;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class TmplParseUnit {

    private TmplParserSub parser;

    private CommonTree tree;

    private TmplLexerSub lexer;

    private String templatedir;

    private String templatefile;

	public static void main(String[] prm){
		String test = "ComboBox";
		String dir = "C:/git/PersHomeProjects/xtend_gen/src/test/";
		TmplParseUnit instance = new TmplParseUnit();
		try {
			ANTLRFileStream stream = new ANTLRFileStream(dir+test+".tmpl");
			Date start = new Date();
			try {
				instance.lexer = new TmplLexerSub(stream);
			    CommonTokenStream tokens = new CommonTokenStream(instance.lexer);
			    instance.lexer.lexerPrint(dir+test+".lex", tokens);
			    instance.parser = new TmplParserSub(tokens);
			    prog_return r = instance.parser.prog();
			    instance.tree = (CommonTree) r.getTree();
			    instance.tree.toStringTree();
			} catch (RecognitionException re) {
			    instance.parser.reportError(re);
			    instance.parser.recover(instance.parser.input, re);
			}
			Date end = new Date();
			System.out.println(" (" + Math.round(end.getTime() - start.getTime()) + "ms)");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    

    public TmplParseUnit(String templatedir, String templatefile) {
        this.templatedir = templatedir;
        this.templatefile = templatefile;
    }

    public TmplParseUnit() {
		// TODO Auto-generated constructor stub
	}


	public TmplParserSub getParser() {
        return parser;
    }

    public CommonTree getTree() throws IOException {
        if (tree == null) {
            parse();
        }
        return tree;
    }

    private void parse() throws IOException {
        System.out.print("Parser:" + templatefile);
        Date start = new Date();
        try {
            lexer = new TmplLexerSub(new ANTLRFileStream(templatedir + templatefile));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // lexer.lexerPrint(outputdir, templatefile, tokens);
            parser = new TmplParserSub(tokens);
            prog_return r = parser.prog();
            tree = (CommonTree) r.getTree();
            tree.toStringTree();
        } catch (RecognitionException re) {
            parser.reportError(re);
            parser.recover(parser.input, re);
        }
        Date end = new Date();
        System.out.println(" (" + Math.round(end.getTime() - start.getTime()) + "ms)");
    }

    public boolean isReserved(String text) {
        return lexer.isReserved(text);
    }

    @Override
    public String toString() {
        return templatefile;
    }
}