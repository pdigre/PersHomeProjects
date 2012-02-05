package no.esito.genova.io.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

import no.esito.genova.model.util.DelimitedList;

public class EClass {

	public Class<?> clazz;

	ArrayList<ELink> links = new ArrayList<ELink>();
	HashSet<EClass> subclasses = new HashSet<EClass>();
	HashSet<EClass> iterators = new HashSet<EClass>();
	HashSet<EProperty> properties = new HashSet<EProperty>();
	HashSet<EVariable> variables = new HashSet<EVariable>();

	public EClass(Class<?> clazz) {
		this.clazz = clazz;
	}

	public void addSubclass(EClass eclass) {
		subclasses.add(eclass);
	}

	public void addLinks(String name,EClass eclass) {
		links.add(new ELink(name,eclass));
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

	public void addVariable(EVariable variable) {
		for (EVariable var : variables) {
			if(var.name.equals(variable.name))
				return;
		}
		variables.add(variable);
	}
	public void addProperty(EProperty property) {
		for (EProperty var : properties) {
			if(var.name.equals(property.name))
				return;
		}
		properties.add(property);
	}

	public String print() {
		StringBuilder sb=new StringBuilder();
		sb.append("Iterators="+new DelimitedList(",",iterators).toString()+"\n");
		sb.append("SubClasses="+new DelimitedList(",",subclasses).toString()+"\n");
		sb.append("Links="+new DelimitedList(",",links).toString()+"\n");
		for (EProperty var : properties) {
			sb.append("public XProperty "+var.name+" = new XProperty(\""+var.name+"\",this);\n");
		}
		for (EVariable var : variables) {
			sb.append("public XVariable "+var.name+" = new XVariable(\""+var.name+"\",this);\n");
		}
		return sb.toString();
	}


}
