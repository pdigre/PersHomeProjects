package no.esito.genova.io.antlr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import no.esito.genova.io.util.FileUtils;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;

public class TmplLexerSub extends TmplLexer {

	// private String templatedir;

	public boolean isFile = false;

	public boolean isTypes = false;

	public TmplLexerSub(CharStream is) {
		super(is);
		// this.templatedir = templatedir;
		this.l = this;
	}

	Stack<Integer> modestack = new Stack<Integer>();

	public void reserved() {

	}

	public void tag() {
		mode = MODE_TAG;
	}

	public void out() {
		mode = MODE_OUT;
	}

	public void cmt() {
		mode = MODE_CMT;
	}

	public void expr() {
		mode = MODE_EXPR;
	}

	public void file() {
		mode = MODE_FILE;
		isFile = true;
	}

	public void alfa() {
		if (mode != MODE_ALFA) {
			modestack.push(mode);
			mode = MODE_ALFA;
		} else {
			mode = modestack.pop();
		}
	}

	public void dollar() {
		if (mode != MODE_DOLLAR) {
			modestack.push(mode);
			mode = MODE_DOLLAR;
		} else {
			mode = modestack.pop();
		}
	}

	public void boolStart() {
		modestack.push(mode);
		mode = MODE_BOOL;
	}

	public void boolEnd() {
		mode = modestack.pop();
	}

	public boolean isTag() {
		return mode == MODE_TAG;
	}

	public void newline() {
		if (isFile) {
			out();
			isFile = false;
		}
	}

	public void println(String text) {

	}

	public static final int MODE_OUT = 0;

	public static final int MODE_TAG = 1;

	public static final int MODE_BOOL = 2;

	public static final int MODE_FILE = 3;

	public static final int MODE_EXPR = 4;

	public static final int MODE_ALFA = 5;

	public static final int MODE_CMT = 6;

	public static final int MODE_DOLLAR = 7;

	public int mode = MODE_OUT; // OUT

	boolean templateStarted = false;

	boolean isInside = false;

	// We should override this method for handling EOF of included file
	@Override
	public Token nextToken() {
		if (mode == MODE_CMT) {
			int begin = input.index();
			int l = seekCMT();
			int end = begin + l;
			input.seek(end);
			mode = MODE_OUT;
			CommonToken t = new CommonToken((CharStream) input, TmplLexer.REM,
					Token.DEFAULT_CHANNEL, begin, end - 1);
			t.setLine(input.getLine());
			t.setText(null);
			t.setCharPositionInLine(input.getCharPositionInLine());
			input.seek(end);
			return t;
		}
		if (mode == MODE_OUT) {
			int begin = input.index();
			int l = seekOUT();
			int end = begin + l - 1;
			if (end > begin) {
				CommonToken t = new CommonToken((CharStream) input,
						TmplLexer.OUT, Token.DEFAULT_CHANNEL, begin, end - 1);
				t.setLine(input.getLine());
				t.setText(null);
				t.setCharPositionInLine(input.getCharPositionInLine());
				input.seek(end);
				return t;
			}
		}
		Token token = super.nextToken();
//		System.out.println("->" + token.getText());
		return nextToken(token, input);

	}

	private int seekOUT() {
		for (int i = 1;; i++) {
			int c = input.LA(i);
			switch (c) {
			case '@':
				return i;
			case '$':
				return i;
			case '\n':
				isFile = false;
				continue;
			case CharStream.EOF:
				return i;
			}
		}
	}

	private int seekCMT() {
		for (int i = 1;; i++) {
			int c = input.LA(i);
			switch (c) {
			case '\n':
				return i;
			case CharStream.EOF:
				return i;
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void lexPrint(CommonTokenStream tokens, FileWriter lexstream) {
		// tokens.fill();
		List list = tokens.getTokens();
		String[] names = getTokenNames();
		for (CommonToken token : (CommonToken[]) list
				.toArray(new CommonToken[list.size()])) {
			if (token.getChannel() == CommonToken.HIDDEN_CHANNEL)
				continue;
			int charPositionInLine = token.getCharPositionInLine();
			int type = token.getType();
			if (charPositionInLine >= 0) {
				try {
					String text = token.getText().replace('\n', ' ')
							.replace('\r', ' ');
					if (text.length() > 80)
						text = text.substring(0, 80);
					String typetext = type < 0 || type >= names.length ? "NULL"
							: names[type];
					lexstream.write(typetext + " " + text + "\r\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String[] tokennames = null;

	@Override
	public String[] getTokenNames() {
		if (tokennames == null) {
			try {
				String fname = "C:/git/PersHomeProjects/xtend_gen/src/main/grammar/TmplLexer.tokens";
				String text = FileUtils
						.stream2String(new FileInputStream(fname));
				String[] split = text.split("\r\n");
				tokennames = new String[split.length + 4];
				for (String string : split) {
					String[] split2 = string.split("=");
					if (split2.length == 2 && !split2[1].isEmpty()) {
						int integer = Integer.parseInt(split2[1]);
						tokennames[integer] = split2[0];
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return tokennames;
	}

	/**
	 * Reads a stream into a string
	 * 
	 * @param is
	 * @return
	 * @throws java.io.IOException
	 */
	static String stream2String(InputStream is) throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}

	private class SaveStruct {

		public String filename;

		SaveStruct(CharStream input, String filename) {
			this.input = input;
			this.marker = input.mark();
			this.filename = filename;
		}

		public CharStream input;

		public int marker;
	}

	private Stack<SaveStruct> includes = new Stack<SaveStruct>();

	// public void doInclude(String name, CharStream input) {
	// try {
	// String filename = templatedir + name;
	// boolean exists = new File(filename).exists();
	// if (exists && (includes.isEmpty() ||
	// !filename.equals(includes.peek().filename))) {
	// System.out.println("INCLUDE " + name);
	// // println("INCLUDE " + name);
	// includes.push(new SaveStruct(input, filename));
	// setCharStream(new ANTLRFileStream(filename));
	// reset();
	// } else {
	// println("INCLUDE ERROR " + name);
	// }
	// } catch (Exception fnf) {
	// throw new Error("Cannot open file " + name);
	// }
	// }

	public void doMacro(String name, CharStream input) {
		includes.push(new SaveStruct(input, null));
		String typedef = typedefs.get(name);
		if (typedef == null) {
			typedef = "";
		}
		println(" M  " + name + " = " + typedef);
		setCharStream(new ANTLRStringStream(typedef));
		reset();
	}

	private Token nextToken(Token token, CharStream input) {
		int type = token.getType(); // || type==46
		if ((type == Token.EOF) && !includes.empty()) {
			// We've got EOF and have non empty stack.
			SaveStruct ss = includes.pop();
			setCharStream(ss.input);
			ss.input.rewind(ss.marker);
			// this should be used instead of super [like below] to handle exits
			// from nested includes
			// it matters, when the 'include' token is the last in previous
			// stream (using super, lexer 'crashes' returning EOF token)
			token = nextToken();
			String text = "BACK TO "
					+ (includes.empty() ? "MAIN" : includes.peek().filename);
			System.out.println(text);
			println(text);
		}
		// Skip first token after switching on another input.
		// You need to use this rather than super as there may be nested include
		// files
		if (((CommonToken) token).getStartIndex() < 0)
			token = nextToken();
		return token;
	}

	private HashMap<String, String> typedefs = new HashMap<String, String>();

	private HashSet<String> reserved = new HashSet<String>();

	public void addTypdef(String type) {
		println(" T " + type + " = ");
		out();
		// typedefs.put(type, def);
	}

	public void addReserved(String name) {
		// println(" R " + name);
		reserved.add(name);
	}

	public HashMap<String, String> getTypedefs() {
		return typedefs;
	}

	public FileWriter output(String filename) {
		File outfile = new File(filename);
		try {
			if (!outfile.exists())
				outfile.createNewFile();
			return new FileWriter(outfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void lexerPrint(String filename, CommonTokenStream tokens) {
		try {
			FileWriter lexstream = output(filename);
			lexPrint(tokens, lexstream);
			lexstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isReserved(String text) {
		return reserved.contains(text);
	}

}
