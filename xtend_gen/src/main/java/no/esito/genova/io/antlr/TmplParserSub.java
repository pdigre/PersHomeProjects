package no.esito.genova.io.antlr;


import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class TmplParserSub extends TmplParser {

    public int count = 0; 

    public TmplParserSub(TokenStream input) {
        super(input);
    }

    public String getName(CommonToken token) {
        return getName(token.getType());
    }

    public String getName(int type) {
        return getTokenNames()[type];
    }

    public String toString(int a, int b) {
        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            Token token = getTokenStream().get(i);
            sb.append(token.getText());
        }
        return sb.toString();

    }
}
