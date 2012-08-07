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
			case 'à':
				sb.append("&agrave;");
				break;
			case 'À':
				sb.append("&Agrave;");
				break;
			case 'â':
				sb.append("&acirc;");
				break;
			case 'Â':
				sb.append("&Acirc;");
				break;
			case 'ä':
				sb.append("&auml;");
				break;
			case 'Ä':
				sb.append("&Auml;");
				break;
			case 'å':
				sb.append("&aring;");
				break;
			case 'Å':
				sb.append("&Aring;");
				break;
			case 'æ':
				sb.append("&aelig;");
				break;
			case 'Æ':
				sb.append("&AElig;");
				break;
			case 'ç':
				sb.append("&ccedil;");
				break;
			case 'Ç':
				sb.append("&Ccedil;");
				break;
			case 'é':
				sb.append("&eacute;");
				break;
			case 'É':
				sb.append("&Eacute;");
				break;
			case 'è':
				sb.append("&egrave;");
				break;
			case 'È':
				sb.append("&Egrave;");
				break;
			case 'ê':
				sb.append("&ecirc;");
				break;
			case 'Ê':
				sb.append("&Ecirc;");
				break;
			case 'ë':
				sb.append("&euml;");
				break;
			case 'Ë':
				sb.append("&Euml;");
				break;
			case 'ï':
				sb.append("&iuml;");
				break;
			case 'Ï':
				sb.append("&Iuml;");
				break;
			case 'ô':
				sb.append("&ocirc;");
				break;
			case 'Ô':
				sb.append("&Ocirc;");
				break;
			case 'ö':
				sb.append("&ouml;");
				break;
			case 'Ö':
				sb.append("&Ouml;");
				break;
			case 'ø':
				sb.append("&oslash;");
				break;
			case 'Ø':
				sb.append("&Oslash;");
				break;
			case 'ß':
				sb.append("&szlig;");
				break;
			case 'ù':
				sb.append("&ugrave;");
				break;
			case 'Ù':
				sb.append("&Ugrave;");
				break;
			case 'û':
				sb.append("&ucirc;");
				break;
			case 'Û':
				sb.append("&Ucirc;");
				break;
			case 'ü':
				sb.append("&uuml;");
				break;
			case 'Ü':
				sb.append("&Uuml;");
				break;
			case '®':
				sb.append("&reg;");
				break;
			case '©':
				sb.append("&copy;");
				break;
			case '€':
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
