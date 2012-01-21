package no.esito.genova.io.generator;

public enum GFunctions {
    UPPER,
    LOWER,
    NOWS,
    NOSEP,
    NOSEP_CAMEL,
    UNCAMELIZE,
    SLASH_TO_DOT,
    DOT_TO_SLASH,
    DOT_TO_UNDER,
    SPACE_TO_UNDER,
    BSLASH_TO_SLASH,
    SHORT,
    FIRST_UPPER,
    FIRST_LOWER,
    HTML,
    JAVADOC,
    EXPAND_ENV,
    EXISTS,
    DEFINED,
    ISNUMBER,
    ISBOOLEAN;

    public Object run(Object in) {
        switch (this) {
            case NOWS:
                return (in == null ? "" : (String) in).trim();
            case UPPER:
                return (in == null ? "" : (String) in).toUpperCase();
            case LOWER:
                return (in == null ? "" : (String) in).toLowerCase();
            case NOSEP:
                return nosep((String) in);
            case NOSEP_CAMEL:
                return nosep_camel((String) in);
            case UNCAMELIZE:
                return uncamelize((String) in);
            case SLASH_TO_DOT:
                return slash_to_dot((String) in);
            case DOT_TO_SLASH:
                return ((String) in).replace('.', '/');
            case DOT_TO_UNDER:
                return ((String) in).replace('.', '_');
            case SPACE_TO_UNDER:
                return ((String) in).replace(' ', '_');
            case BSLASH_TO_SLASH:
                return ((String) in).replace('\\', '/');
            case SHORT:
                return shorter((String) in);
            case FIRST_UPPER:
                return Character.toUpperCase(((String) in).charAt(0)) + ((String) in).substring(1);
            case FIRST_LOWER:
                return Character.toLowerCase(((String) in).charAt(0)) + ((String) in).substring(1);
            case HTML:
                return html((String) in);
            case JAVADOC:
                return javadoc((String) in);
            case EXPAND_ENV:
                return expand_env((String) in);
            case ISNUMBER:
                return isNumber((String) in);
            case ISBOOLEAN:
                return isBoolean((String) in);
            default:
                return null;
        }
    }

    public boolean isNumber(String in) {
        try {
            Integer.parseInt(in);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public boolean isBoolean(String in) {
        if("true".equalsIgnoreCase(in) ||"false".equalsIgnoreCase(in))
            return true;
        return false;
    }

    public String nosep(String in) {
        StringBuilder sb = new StringBuilder();
        for (Character c : in.toCharArray()) {
            switch (c) {
                case '/':
                case '\\':
                case '.':
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public String shorter(String in) {
        StringBuilder sb = new StringBuilder();
        for (Character c : in.toCharArray()) {
            switch (c) {
                case '/':
                case '\\':
                case '.':
                    return sb.toString();
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public String nosep_camel(String in) {
        StringBuilder sb = new StringBuilder();
        boolean upper = true;
        for (Character c : in.toCharArray()) {
            switch (c) {
                case '/':
                case '\\':
                case '.':
                    upper = true;
                    break;
                default:
                    sb.append(upper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                    upper = false;
            }
        }
        return sb.toString();
    }

    public Object uncamelize(String in) {
        StringBuilder sb = new StringBuilder();
        for (char c : in.toCharArray()) {
            char l = Character.toLowerCase(c);
            if (l != c && sb.length() > 0)
                sb.append('_');
            sb.append(c);
        }
        return sb.toString();
    }

    public String slash_to_dot(String in) {
        StringBuilder sb = new StringBuilder();
        for (Character c : in.toCharArray()) {
            switch (c) {
                case '/':
                case '\\':
                    sb.append('.');
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public String javadoc(String in) {
        boolean newline=true;
        StringBuilder sb = new StringBuilder();
        for (Character c : in.toCharArray()) {
            switch (c) {
                case '\n':
                    sb.append("\n");
                    newline=true;
                    break;
                default:
                    if(newline){
                        sb.append(" * ");
                        newline=false;
                    }
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public String expand_env(String in) {
        StringBuilder sb = new StringBuilder();
        String[] split = in.split("%", -2);
        for (int i = 0; i < split.length; i += 2) {
            sb.append(split[i]);
            if (i + 1 < split.length) {
                String env = System.getenv(split[i + 1]);
                if (env != null && !env.isEmpty()) {
                    sb.append(env);
                } else {
                    sb.append("%");
                    sb.append(split[i + 1]);
                    sb.append("%");
                }
            } else {
                sb.append("%");
                sb.append(split[i + 1]);
            }
        }
        return sb.toString();
    }

    public String html(String s) {
        StringBuffer sb = new StringBuffer();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '�':
                    sb.append("&agrave;");
                    break;
                case '�':
                    sb.append("&Agrave;");
                    break;
                case '�':
                    sb.append("&acirc;");
                    break;
                case '�':
                    sb.append("&Acirc;");
                    break;
                case '�':
                    sb.append("&auml;");
                    break;
                case '�':
                    sb.append("&Auml;");
                    break;
                case '�':
                    sb.append("&aring;");
                    break;
                case '�':
                    sb.append("&Aring;");
                    break;
                case '�':
                    sb.append("&aelig;");
                    break;
                case '�':
                    sb.append("&AElig;");
                    break;
                case '�':
                    sb.append("&ccedil;");
                    break;
                case '�':
                    sb.append("&Ccedil;");
                    break;
                case '�':
                    sb.append("&eacute;");
                    break;
                case '�':
                    sb.append("&Eacute;");
                    break;
                case '�':
                    sb.append("&egrave;");
                    break;
                case '�':
                    sb.append("&Egrave;");
                    break;
                case '�':
                    sb.append("&ecirc;");
                    break;
                case '�':
                    sb.append("&Ecirc;");
                    break;
                case '�':
                    sb.append("&euml;");
                    break;
                case '�':
                    sb.append("&Euml;");
                    break;
                case '�':
                    sb.append("&iuml;");
                    break;
                case '�':
                    sb.append("&Iuml;");
                    break;
                case '�':
                    sb.append("&ocirc;");
                    break;
                case '�':
                    sb.append("&Ocirc;");
                    break;
                case '�':
                    sb.append("&ouml;");
                    break;
                case '�':
                    sb.append("&Ouml;");
                    break;
                case '�':
                    sb.append("&oslash;");
                    break;
                case '�':
                    sb.append("&Oslash;");
                    break;
                case '�':
                    sb.append("&szlig;");
                    break;
                case '�':
                    sb.append("&ugrave;");
                    break;
                case '�':
                    sb.append("&Ugrave;");
                    break;
                case '�':
                    sb.append("&ucirc;");
                    break;
                case '�':
                    sb.append("&Ucirc;");
                    break;
                case '�':
                    sb.append("&uuml;");
                    break;
                case '�':
                    sb.append("&Uuml;");
                    break;
                case '�':
                    sb.append("&reg;");
                    break;
                case '�':
                    sb.append("&copy;");
                    break;
                case '�':
                    sb.append("&euro;");
                    break;
                // be carefull with this one (non-breaking whitee space)
                case ' ':
                    sb.append("&nbsp;");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

}