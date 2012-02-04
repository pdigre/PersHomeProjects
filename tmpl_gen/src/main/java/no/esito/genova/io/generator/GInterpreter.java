package no.esito.genova.io.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Stack;

import no.esito.genova.io.classmodel.XObject;
import no.esito.genova.io.generator.TMPL_Engine.GTreeUnit;

import org.antlr.runtime.tree.CommonTree;

public abstract class GInterpreter {

    protected boolean hasDebug;

    private String outputdir;

    private Writer out;

    public HashMap<String, Object> global = new HashMap<String, Object>();

    public HashMap<String, HashMap<String, Object>> scoped = new HashMap<String, HashMap<String, Object>>();

    Stack<GTreeUnit> units = new Stack<TMPL_Engine.GTreeUnit>();


    public GInterpreter(GTreeUnit unit, String outputdir) {
        units.push(unit);
        this.outputdir = outputdir;
    }

    public String getCurrent() {
        return "root";
    }

    public void IF(String text) {
        System.out.println("hi");
    }

    Stack<GOutput> filestack = new Stack<GOutput>();

    private boolean indent_mode = false;

    private int indent = 0;

    public boolean newline = true;

    public boolean ignoreFirstNewline = false;

    public static final int FILE_OVERWRITE = 1;

    public static final int FILE_IGNORE = 2;

    public static final int FILE_NEW = 3;

    public Writer startFile(String filename, int mode) throws IOException {
        String filepath = filename;
        boolean b = outputExists(filepath);
        switch (mode) {
            case FILE_OVERWRITE:
                break;
            case FILE_IGNORE:
                if (b)
                    filepath = null;
                break;
            case FILE_NEW:
                if (b)
                    filepath += ".new";
                break;
        }
        return (Writer) pushWriter(filename, filepath == null ? null : getOutputStream(filepath));
    }

    public Writer getOutputStream(String filename) throws IOException {
        return new FileWriter(outputdir + filename);
    }

    public boolean outputExists(String filename) {
        return new File(outputdir + filename).exists();
    }

    public Writer pushWriter(String filename, Writer fw) {
        out = fw;
        filestack.push(new GOutput(filename, fw));
        return out;
    }

    public void out(Object text) {
        if (text == null)
            return;
        try {
            if (out != null) {
                if (text instanceof String) {
                    String txt = text.toString();
                    for (GFunctions func : str_stack)
                        txt = (String) func.run(txt);
//                    if (filestack.peek().filename.endsWith("Answer.java"))
//                        System.out.println("hi");
                    if (line_mode) {
                        txt = txt.replaceAll("\\r\\n", "");
                    } else {
                        if ("\r\n".equals(txt))
                            return;
                        if ("\r".equals(txt)){
                            newline=true;
                            return;
                        }
                        if (ignoreFirstNewline) {
                            if (txt.startsWith("\r\n")) {
                                txt = txt.substring(2);
                                ignoreFirstNewline = false;
                                newline = true;
                            }
                        }
                        txt = indented(txt);
                        // String trim = txt.trim();
                        // if("".equals(trim))
                        // return;
                    }
                    out.write(txt);
                } else if (text instanceof Boolean) {
                    out.write((Boolean) text ? "True" : "False");
                } else if (text instanceof Integer) {
                    out.write(String.valueOf(text));
                }

            }
            // else
            // System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String indented(String txt) {
        if (indent_mode)
            return txt;
        StringBuilder sb = new StringBuilder();
        int n = txt.length();
        for (int i = 0; i < n; i++) {
            char c = txt.charAt(i);
            switch (c) {
                case ' ':
                case '\t':
                    if (!newline)
                        sb.append(c);
                    break;
                case '\r':
                    break;
                case '\n':
                    newline = true;
                    sb.append("\r\n");
                    break;
                default:
                    if (newline)
                        for (int j = 0; j < indent; j++)
                            sb.append(' ');
                    sb.append(c);
                    newline = false;
                    break;
            }
        }
        return sb.toString();
    }

    public void indentBegin() {
        indent_mode = true;
    }

    public void indentEnd() {
        indent_mode = false;
    }

    public void indent(int num) {
        indent += num;
    }

    public void error(String string) {
    }

    public Integer getInt(String number) {
        return Integer.parseInt(number);
    }

    public String literal(String literal) {
        return literal.replace("\"", "");
    }

    public Object divide(Object a, Object b) {
        return (Integer) a / (Integer) b;
    }

    public Object multiply(Object a, Object b) {
        return (Integer) a * (Integer) b;
    }

    public Object minus(Object a, Object b) {
        return (Integer) a - (Integer) b;
    }

    public Object plus(Object a, Object b) {
        return (Integer) a + (Integer) b;
    }

    public Object append(Object a, Object b) {
        return (String) a + (String) b;
    }

    public Object equal(Object a, Object b) {
        return !a.equals(b);
    }

    public Object ge(Object a, Object b) {
        return (Integer) a >= (Integer) b;
    }

    public Object gt(Object a, Object b) {
        return (Integer) a > (Integer) b;
    }

    public Object le(Object a, Object b) {
        return (Integer) a <= (Integer) b;
    }

    public Object lt(Object a, Object b) {
        return (Integer) a < (Integer) b;
    }

    public Object ne(Object a, Object b) {
        return !a.equals(b);
    }

    public Object not(Object a) {
        if (a == null) {
            System.out.println("NULL");
            return false;
        }
        return !bool(a);
    }

    public Boolean bool(Object a) {
        if (a instanceof String) {
            return "true".equalsIgnoreCase((String) a);
        }
        return (Boolean) a;
    }

    public Object and(Object a, Object b) {
        return bool(a) && bool(b);
    }

    public Object or(Object a, Object b) {
        return bool(a) || bool(b);
    }

    public void cmd_if(Object e) {
        out("<IF" + e + ">");
    }

    public void cmd_copy(String a, String b) {
        out(" COPY " + a + "=>" + b);
    }

    public void debug(String value) {
        System.out.println(value);
    }

    HashMap<String, CommonTree> subs = new HashMap<String, CommonTree>();

    public boolean on() {
        return false;
    }

    private boolean line_mode;

    public void registerSub(String name, CommonTree tree) {
        name = name.replaceAll(";", "");
        subs.put(name, tree);
    }

    public CommonTree getSub(String name) {
        return subs.get(name);
    }

    public void close() {
        for (GOutput gout : filestack) {
            try {
                gout.writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLine(boolean line_mode) {
        this.line_mode = line_mode;
    }

    public GTreeUnit getTreeUnit(String string) {
        return null;
    }

    public void popWriter() {
        GOutput gout = filestack.pop();
        if (gout.writer != null) {
            try {
                gout.writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        resetOutput();
    }

    public void pushFile(String filename) {
        GOutput find = null;
        for (GOutput out : filestack) {
            if (out.filename.equals(filename)) {
                find = out;
            }
        }
        ;
        filestack.remove(find);
        filestack.push(find);
        resetOutput();
    }

    public void popFile() {
        GOutput find = filestack.pop();
        filestack.add(0, find);
        resetOutput();
    }

    private void resetOutput() {
        out = filestack.empty() ? null : filestack.peek().writer;
    }

    public Stack<GCTX> ctxstack = new Stack<GCTX>();

    public Stack<XObject> scopes = new Stack<XObject>();

    public Stack<GFunctions> str_stack = new Stack<GFunctions>();

    public boolean isDebug;

    public boolean ifcontext(String name) {
        for (GCTX ctx : ctxstack) {
            if (ctx.name.equals(name))
                return true;
        }
        return false;
    }

    public class GCTX {

        public XObject x;

        public String name;

        public GCTX(String name, XObject x) {
            this.name = name;
            this.x = x;
        }

    }

    public void setContext(String name, XObject x) {
        ctxstack.push(new GCTX(name, x));
    }

    public void endContext() {
        ctxstack.pop();
    }

    public Object getTargetGlobal(String name) {
        return null;
    }

    public XObject getScope(String name) {
        for (GCTX ctx : ctxstack) {
            if (ctx.name.equals(name))
                return ctx.x;
        }
        return null;
    }

    public Object defined(Object val) {
        if (val instanceof String) {
            String s = (String) val;
            if (s.startsWith("<???:"))
                return false;
            return !s.isEmpty() && !"false".equalsIgnoreCase(s);
        }
        return val != null;
    }

}
