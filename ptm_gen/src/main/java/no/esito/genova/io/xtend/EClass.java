package no.esito.genova.io.xtend;

import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

import no.esito.genova.model.util.DelimitedList;

public class EClass {

	public Class<?> clazz;

	HashSet<EClass> subclasses = new HashSet<EClass>();
	HashSet<EClass> iterators = new HashSet<EClass>();
	HashSet<String> properties = new HashSet<String>();
	HashSet<String> variables = new HashSet<String>();

	public EClass(Class<?> clazz) {
		this.clazz = clazz;
	}

	public void addSubclass(EClass eclass) {
		subclasses.add(eclass);
	}

	public void addIterator(EClass ecl) {
		iterators.add(ecl);
	}

	public boolean isCompatible(Collection<String> collection) {
		compareLoop: for (String name : collection) {
			if (name.isEmpty())
				continue;
			for (EClass ecl : iterators) {
				if (ecl.clazz.getSimpleName().substring(1)
						.equalsIgnoreCase(name))
					continue compareLoop;
			}
			return false;
		}
		return true;
	}

	public String getName() {
		return clazz.getSimpleName().substring(1);
	}

	@Override
	public String toString() {
		return getName();
	}

	public String print() {
		String text = "Iterators="+new DelimitedList(",",iterators).toString()+"\n";
		text+="SubClasses="+new DelimitedList(",",subclasses).toString()+"\n";
		return text;
	}
}
