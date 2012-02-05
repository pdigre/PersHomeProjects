package no.esito.genova.io.convert;

import java.util.ArrayList;
import java.util.TreeSet;

import no.esito.genova.model.util.DelimitedList;


public class ELink {
    public String name;
	public EClass ecl;

    public ELink(String name, EClass ecl) {
        super();
        this.name=firstLower(name.substring(3));
        this.ecl=ecl;
    }

    @Override
    public String toString() {
        return name+"->"+ecl.getName();
    }

    public String firstLower(String t) {
		return t.substring(0,1).toLowerCase()+t.substring(1);
	}

}
