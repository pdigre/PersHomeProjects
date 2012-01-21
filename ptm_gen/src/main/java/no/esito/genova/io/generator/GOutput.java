package no.esito.genova.io.generator;

import java.io.Writer;

public class GOutput {

    String filename;

    public GOutput(String filename, Writer out) {
        super();
        this.filename = filename;
        this.writer = out;
    }

    Writer writer;
}