package no.esito.genova.io.generator;

import no.esito.genova.io.antlr.GParser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class GParserSub extends GParser {

    public int count = 0;

    public GParserSub(TokenStream input) {
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
