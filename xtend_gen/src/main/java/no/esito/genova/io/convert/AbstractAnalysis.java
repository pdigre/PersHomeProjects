package no.esito.genova.io.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import no.esito.genova.io.ptm.Ptm2Xtend;
import no.esito.genova.model.util.DelimitedList;

public class AbstractAnalysis extends AbstractSupport {

	public Stack<String> iterator_stack = new Stack<String>();
	public ArrayList<EVariable> variables = new ArrayList<EVariable>();
	public ArrayList<EProperty> properties = new ArrayList<EProperty>();

	public TreeMap<String, EIterator> iterators = new TreeMap<String, EIterator>();
	public TreeSet<String> iterations = new TreeSet<String>();

	public ArrayList<ECall> calls = new ArrayList<ECall>();

	public TreeSet<String> contexts = new TreeSet<String>();

	public String root="Object";

	public EStructure structure;

	public String deduceParent(String iterator) {
		if (scanMode)
			return "";
		String parent = "";
		int n = iterator_stack.size();
		if (n > 1) {
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
		properties.add(new EProperty(name,
				new ArrayList<String>(iterator_stack), exprtype, ctx));
		iterator.recordAttribute(name + exprtype.suffix());
	}

	public void recordVariable(String ctx, String name) {
		if (ctx == null)
			ctx = iterator_stack.peek();
		EIterator iterator = iterators.get(ctx);
		if (iterator == null) {
			iterator = new EIterator(ctx);
		}
		variables.add(new EVariable(name,
				new ArrayList<String>(iterator_stack), exprtype, ctx));
		iterator.recordVariable(name + exprtype.suffix());
	}

	public String getRoot() {
		return root == null ? "xx" : root;
	}

	public Collection<String> getDirectIterators() {
		TreeSet<String> direct = new TreeSet<String>();
		for (String text : iterations)
			direct.add(new DelimitedList(",", text).get(0));
		return direct;
	}

	public void printUsage(HashSet<AbstractSupport> set) {
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

		for (AbstractSupport base : set) {
			Ptm2Xtend xtend=(Ptm2Xtend) base;
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
		sb.append("==================================================================================================================\n");
		sb.append("Direct:" + new DelimitedList(",", getDirectIterators())
				+ "\n");
		sb.append("Root:" + root + "\n");

		saveResource("usage", clazzname + ".txt", sb.toString());
	}

	public void collect(HashSet<AbstractSupport> set) {
		Collection<String> direct = getDirectIterators();
		EClass root2 = structure.getRoot(direct);
		if (root2 != null)
			root = root2.getName();
		for (EVariable var : variables) {
			var.setRoot(root);
			structure.recordVariable(var);
		}
		for (EProperty var : properties) {
			var.setRoot(root);
			structure.recordProperty(var);
		}
	}

}
