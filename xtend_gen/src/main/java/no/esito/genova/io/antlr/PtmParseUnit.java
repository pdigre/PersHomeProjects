package no.esito.genova.io.antlr;

import java.io.IOException;
import java.util.Date;


import no.esito.genova.io.antlr.PtmParser.prog_return;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class PtmParseUnit {

    private PtmParserSub parser;

    private CommonTree tree;

    private PtmLexerSub lexer;

    private String templatedir;

    private String templatefile;

	public static void main(String[] prm){
		PtmParseUnit instance = new PtmParseUnit();
		try {
			String dir = "C:/git/PersHomeProjects/xtend_gen/src/test/";
			ANTLRFileStream stream = new ANTLRFileStream(dir+"ApplicationModel.ptm");
			Date start = new Date();
			try {
				instance.lexer = new PtmLexerSub(stream);
			    CommonTokenStream tokens = new CommonTokenStream(instance.lexer);
			    instance.lexer.lexerPrint(dir+"ApplicationModel.lex", tokens);
			    instance.parser = new PtmParserSub(tokens);
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
    
    public PtmParseUnit() {
    }

    public PtmParseUnit(String templatedir, String templatefile) {
        this.templatedir = templatedir;
        this.templatefile = templatefile;
    }

    public PtmParserSub getParser() {
        return parser;
    }

    public CommonTree getTree() throws IOException {
        if (tree == null) {
            System.out.print("Parser:" + templatefile);
			parse(new ANTLRFileStream(templatedir + templatefile));
        }
        return tree;
    }

    public void parse(ANTLRFileStream stream) {
		Date start = new Date();
        try {
			lexer = new PtmLexerSub(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // lexer.lexerPrint(outputdir, templatefile, tokens);
            parser = new PtmParserSub(tokens);
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