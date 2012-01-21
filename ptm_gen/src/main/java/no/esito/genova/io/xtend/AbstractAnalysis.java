package no.esito.genova.io.xtend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import no.esito.genova.model.util.DelimitedList;

public class AbstractAnalysis extends AbstractSupport {

	public Stack<String> iterator_stack = new Stack<String>();

	public TreeMap<String, EIterator> iterators = new TreeMap<String, EIterator>();
	public TreeSet<String> iterations = new TreeSet<String>();

	public ArrayList<ECall> calls = new ArrayList<ECall>();

	public TreeSet<String> contexts = new TreeSet<String>();

	public String root;
	public EXPSTATE exprtype = EXPSTATE.Output;

	public boolean scanMode = false;

	public String deduceParent(String iterator) {
		if (scanMode)
			return "";
		String parent="";
		int n = iterator_stack.size();
		if(n>1){
			parent = iterator_stack.get(n - 2);
		}
		if (parent.isEmpty()) {
			parent = getRoot();
		}
		return parent;
	}

	public void recordAttribute(String ctx, String name) {
		if (ctx == null)
			ctx = iterator_stack.peek();
		EIterator iterator = iterators.get(ctx);
		if (iterator == null) {
			iterator = new EIterator(ctx);
			iterators.put(ctx, iterator);
		}
		iterator.recordAttribute(name + exprtype.suffix());
	}

	public void recordVariable(String ctx, String name) {
		if (ctx == null)
			ctx = iterator_stack.peek();
		EIterator iterator = iterators.get(ctx);
		if (iterator == null) {
			iterator = new EIterator(ctx);
		}
		iterator.recordVariable(name + exprtype.suffix());
	}

    public String getRoot() {
        return root==null?"xx":root;
    }

	public Collection<String> getDirectIterators() {
		TreeSet<String> direct = new TreeSet<String>();
		for (String text : iterations) 
			direct.add(new DelimitedList(",", text).get(0));
		return direct;
	}

	public void printUsage(EStructure structure, HashSet<Ptm2Xtend> set) {
		StringBuilder sb = new StringBuilder();
		for (EIterator iterator : iterators.values()) {
			sb.append(iterator.toString());
			sb.append("\n");
		}
		for (String iteration : iterations) {
			sb.append("iterate:");
			sb.append(iteration);
			sb.append("\n");
		}
		for (ECall call : calls) {
			sb.append("-->");
			sb.append(call.toString());
			sb.append("\n");
		}

		for (Ptm2Xtend xtend : set) {
			for (ECall call : xtend.calls) {
				String callname = call.name;
				int i = callname.indexOf(".");
				if (i < 2)
					continue;
				String callto = callname.substring(1, i);
				if (callto.equals(clazzname)) {
					sb.append("<--");
					sb.append(xtend.clazzname);
					sb.append(":");
					sb.append(new DelimitedList(",", call.contexts));
					contexts.addAll(call.contexts);
					sb.append("\n");
				}
			}
		}
		Collection<String> direct = getDirectIterators();
		root = structure.getRoot(direct).getName();
		sb.append("==================================================================================================================\n");
		sb.append("Direct:" + new DelimitedList(",", direct)+"\n");
		sb.append("Root:" + root+"\n");

		saveResource("src", clazzname + ".txt", sb.toString());
	}

}
