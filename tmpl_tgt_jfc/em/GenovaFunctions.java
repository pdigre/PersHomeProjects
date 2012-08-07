public class GenovaFunctions {
	public boolean _EXISTS(String in) {
		return true;
	}

	public String _NOWS(String in) {
		return (in == null ? "" : (String) in).trim();
	}

	public String _UPPER(String in) {
		return (in == null ? "" : (String) in).toUpperCase();
	}

	public String _LOWER(String in) {
		return (in == null ? "" : (String) in).toLowerCase();
	}

	public String _NOSEP(String in) {
		StringBuilder sb = new StringBuilder();
		for (Character c : ((String) in).toCharArray()) {
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

	public String _NOSEP_CAMEL(String in) {
		StringBuilder sb = new StringBuilder();
		boolean upper = true;
		for (Character c : ((String) in).toCharArray()) {
			switch (c) {
			case '/':
			case '\\':
			case '.':
				upper = true;
				break;
			default:
				sb.append(upper ? Character.toUpperCase(c) : Character
						.toLowerCase(c));
				upper = false;
			}
		}
		return sb.toString();
	}

	public String _UNCAMELIZE(String in) {
		StringBuilder sb = new StringBuilder();
		for (char c : ((String) in).toCharArray()) {
			char l = Character.toLowerCase(c);
			if (l != c && sb.length() > 0)
				sb.append('_');
			sb.append(c);
		}
		return sb.toString();
	}

	public String _SLASH_TO_DOT(String in) {
		StringBuilder sb = new StringBuilder();
		for (Character c : ((String) in).toCharArray()) {
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

	public String _DOT_TO_SLASH(String in) {
		return ((String) in).replace('.', '/');
	}

	public String _DOT_TO_UNDER(String in) {
		return ((String) in).replace('.', '_');
	}

	public String _SPACE_TO_UNDER(String in) {
		return ((String) in).replace(' ', '_');
	}

	public String _BSLASH_TO_SLASH(String in) {
		return ((String) in).replace('\\', '/');
	}

	public String _SHORT(String in) {
		StringBuilder sb = new StringBuilder();
		for (Character c : ((String) in).toCharArray()) {
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

	public String _FIRST_UPPER(String in) {
		return Character.toUpperCase(((String) in).charAt(0))
				+ ((String) in).substring(1);
	}

	public String _FIRST_LOWER(String in) {
		return Character.toLowerCase(((String) in).charAt(0))
				+ ((String) in).substring(1);
	}

	public String _EXPAND_ENV(String in) {
		StringBuilder sb = new StringBuilder();
		String[] split = ((String) in).split("%", -2);
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

	public boolean _ISNUMBER(String in) {
		try {
			Integer.parseInt((String) in);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	public boolean _ISBOOLEAN(String in) {
		String in1 = (String) in;
		if ("true".equalsIgnoreCase(in1) || "false".equalsIgnoreCase(in1))
			return true;
		return false;
	}

	public String _JAVADOC(String in) {
		boolean newline = true;
		StringBuilder sb = new StringBuilder();
		for (Character c : in.toCharArray()) {
			switch (c) {
			case '\n':
				sb.append("\n");
				newline = true;
				break;
			default:
				if (newline) {
					sb.append(" * ");
					newline = false;
				}
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public String _HTML(CharSequence s) {
		StringBuilder sb = new StringBuilder();
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
