package no.esito.genova.io.convert;

import java.util.ArrayList;


public class EProperty {

	public String name;
	public ArrayList<String> stack;
	public EXPSTATE exprtype;
	public String ctx;

	public EProperty(String name, ArrayList<String> stack, EXPSTATE exprtype,String ctx) {
		this.name=name;
		this.stack=stack;
		this.exprtype=exprtype;
		this.ctx=ctx;
	}

	public void setRoot(String root) {
		if(!stack.isEmpty() && stack.get(0).isEmpty())
			stack.set(0, root);
	}

}
