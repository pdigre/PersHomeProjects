package no.esito.genova.io.ptm;

import java.util.ArrayList;
import java.util.TreeSet;

import no.esito.genova.model.util.DelimitedList;

public class EIterator {

	public String ctx;
    public TreeSet<String> atts=new TreeSet<String>();
    public TreeSet<String> vars=new TreeSet<String>();

	public EIterator(String ctx) {
		this.ctx=ctx;
	}

	public void recordAttribute(String name) {
	    atts.add(name);
	}
	public void recordVariable(String name) {
        vars.add(name);
	}

	@Override
	public String toString() {
	    String prefix = (ctx+"                                       ").substring(0,20);
        return prefix+"1:"+new DelimitedList(",",atts)+"\n"+prefix+"2:"+new DelimitedList(",",vars);
	}
}
