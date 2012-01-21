package no.esito.genova.io.xtend;

import java.util.ArrayList;
import java.util.TreeSet;

import no.esito.genova.model.util.DelimitedList;


public class ECall {

    
    public TreeSet<String> contexts;
    public String name;

    public ECall(String name, ArrayList<String> contexts) {
        super();
        this.name=name;
        this.contexts=new TreeSet<String>(contexts);
    }

    @Override
    public String toString() {
        return name+":"+new DelimitedList(",",contexts);
    }
}
