package no.esito.genova.io.tmpl;

import static no.esito.genova.io.antlr.TmplParser.ATTRIBUTE;
import static no.esito.genova.io.antlr.TmplParser.ATTRIBUTE2;
import static no.esito.genova.io.antlr.TmplParser.CONTEXT;
import static no.esito.genova.io.antlr.TmplParser.ENDCONTEXT;
import static no.esito.genova.io.antlr.TmplParser.IFCONTEXT;
import static no.esito.genova.io.antlr.TmplParser.INCLUDE;
import static no.esito.genova.io.antlr.TmplParser.ITERATE;
import static no.esito.genova.io.antlr.TmplParser.MACRO;
import static no.esito.genova.io.antlr.TmplParser.OUT;
import static no.esito.genova.io.antlr.TmplParser.SUB;
import static no.esito.genova.io.antlr.TmplParser.TYPE;
import static no.esito.genova.io.antlr.TmplParser.TYPED;
import static no.esito.genova.io.antlr.TmplParser.TYPEDEF;
import static no.esito.genova.io.antlr.TmplParser.VARIABLE;
import static no.esito.genova.io.antlr.TmplParser.VARIABLE2;

import java.util.ArrayList;
import java.util.List;

import no.esito.genova.model.util.DelimitedList;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public abstract class AbstractTmpl2Xtend extends AbstractSupport {

	public CommonTree node;

	public boolean fileQuoteState;

	public boolean isClosed = true;

	// public Stack<CommonTree> stack=new Stack<CommonTree>();

	@SuppressWarnings("rawtypes")
	private CharSequence walk_(CommonTree parent) {
		CharSequence out = "";
		if (parent == null)
			return out;
		List children = parent.getChildren();
		if (children == null)
			return out;
		for (Object n : children) {
			if (n instanceof CommonTree) {
				node = (CommonTree) n;
				if (node.token != null) {
					scan1();
					out = out + out2() + _stat().toString();
					scan2();
				}
			}
		}
		return out;
	}

	public CharSequence walk() {
		CommonTree parent = node;
		CharSequence out = walk_(node);
		node = parent;
		return out;
	}

	public CharSequence walk2(int start) {
		CharSequence out = "";
		CommonTree parent = node;
		List children = parent.getChildren();
		if (children == null)
			return out;
		for (int i = start - 1; i < children.size(); i++) {
			Object n = (CommonTree) children.get(i);
			if (n instanceof CommonTree) {
				node = (CommonTree) n;
				if (node.token != null) {
					scan1();
					out = out + _stat().toString();
					scan2();
				}
			}
		}
		node = parent;
		return out;
	}

	public CharSequence walk(int i) {
		CommonTree parent = node;
		CharSequence walk = walk_((CommonTree) node.getChild(i - 1));
		node = parent;
		return walk;
	}

	@SuppressWarnings("rawtypes")
	private CharSequence file_(CommonTree parent) {
		CharSequence out = "";
		if (parent == null)
			return out;
		List children = parent.getChildren();
		if (children == null)
			return out;
		boolean first = true;
		for (Object n : children) {
			if (n instanceof CommonTree) {
				node = (CommonTree) n;
				if (node.token != null) {
					if (first)
						first = false;
					else
						out = out + (" + ");
					scan1();
					out = out + _file().toString();
					scan2();
				}
			}
		}
		return out;
	}

	public CharSequence file(int i) {
		fileQuoteState = false;
		CommonTree parent = node;
		CharSequence walk = file_((CommonTree) node.getChild(i - 1));
		node = parent;
		return walk;
	}

	@SuppressWarnings("rawtypes")
	private CharSequence fileliteral_(CommonTree parent) {
		CharSequence out = "";
		if (parent == null)
			return out;
		List children = parent.getChildren();
		if (children == null)
			return out;
		for (Object n : children) {
			if (n instanceof CommonTree) {
				node = (CommonTree) n;
				if (node.token != null) {
					scan1();
					out = out + _file().toString();
					scan2();
				}
			}
		}
		return out;
	}

	public CharSequence fileliteral() {
		fileQuoteState = false;
		CommonTree parent = node;
		CharSequence walk = fileliteral_((CommonTree) node);
		node = parent;
		return walk;
	}

	public abstract CharSequence _stat();

	public abstract CharSequence _expr();

	public abstract CharSequence _file();

	public CharSequence cmt() {
		CharSequence out = "";
		String text = node.getText();
		if ("%REM".equals(text)) {
			// out.append("\n");
		} else {
			String txt = text.substring(1).replace("%", "\n");
			if (hasText(txt)) {
				out = out + "//";
				out = out + (txt);
				// out.append("\n");
			}
		}
		return out;
	}

	public CharSequence txt() {
		CharSequence out = "";
		out = out + node.getText();
		return out;
	}

	public CharSequence txt(int i) {
		CharSequence out = "";
		Tree child = node.getChild(i - 1);
		if (child != null)
			out = out + child.getText();
		return out;
	}

	public CharSequence typedef1() {
		CharSequence out = "";
		out = out + node.getText().replace(";", "");
		return out;
	}

	public CharSequence typedef2() {
		CharSequence out = "";
		Tree child = node.getChild(0);
		if (child != null)
			out = out + (child.getText().replace(";", ""));
		return out;
	}

	public CharSequence expr() {
		CommonTree parent = node;
		scan1();
		CharSequence out = _expr();
		scan2();
		node = parent;
		return out;
	}

	public CharSequence expr(EXPSTATE exptype, int i) {
		EXPSTATE newtype = exprtype;
		CommonTree parent = node;
		node = (CommonTree) parent.getChild(i - 1);
		if (node == null)
			return "";
		exprtype = exptype;
		scan1();
		CharSequence out = _expr();
		scan2();
		node = parent;
		exprtype = newtype;
		return out;
	}

	@SuppressWarnings("rawtypes")
	public CharSequence expr2(int start) {
		CharSequence out = "";
		CommonTree parent = node;
		List children = parent.getChildren();
		if (children == null)
			return out;
		for (int i = start - 1; i < children.size(); i++) {
			Object n = (CommonTree) children.get(i);
			if (n instanceof CommonTree) {
				node = (CommonTree) n;
				if (node.token != null) {
					scan1();
					out = out + _expr().toString();
					scan2();
				}
			}
		}
		node = parent;
		return out;
	}

	public CharSequence out() {
		CharSequence out = "";
		String text = node.getText();
		if (!hasText(text))
			return out;
		if (text.endsWith("\n"))
			text = text.substring(0, text.length() - 1);
		if (text.endsWith("\r"))
			text = text.substring(0, text.length() - 1);
		if (text.length() > 0) {
			if (isClosed)
				out = out + ("'''");
			out = out + (text);
			isClosed = false;
			// out = out + ("'''");
		}
		return out;
	}

	public String out2() {
		String out = "";
		switch (node.token.getType()) {
		case SUB:
		case MACRO:
		case TYPED:
			if (isClosed) {
				out = out + ("'''");
				isClosed = false;
			}
			break;
		case OUT:
			break;
		default:
			return close();
		}
		return out;
	}

	public String close() {
		String out = "";
		if (!isClosed) {
			out = out + ("'''\n");
			isClosed = true;
		}
		return out;
	}

	public CharSequence none() {
		return "";
	}

	public boolean hasText(String text) {
		boolean hasTxt = false;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			switch (c) {
			case '\n':
			case '\r':
			case '\t':
			case ' ':
				continue;
			}
			hasTxt = true;
			break;
		}
		return hasTxt;
	}

	public CharSequence bp() {
		System.out.println("break");
		return "";
	}

	public void scan1() {
		switch (node.token.getType()) {
		default:
		}

	}

	public void scan2() {
		if (!scanMode)
			return;
		switch (node.token.getType()) {
		case ITERATE:
			break;
		case INCLUDE:
			break;
		case IFCONTEXT:
			break;
		case CONTEXT:
			break;
		case ENDCONTEXT:
			break;
		default:
		}
	}

	public String firstLower(String t) {
		return t.substring(0, 1).toLowerCase() + t.substring(1);
	}

	public String fixName(String text) {
		if (text.equals("class"))
			return "clazz";
		if (text.equals("interface"))
			return "interfaze";
		return text;
	}

}
