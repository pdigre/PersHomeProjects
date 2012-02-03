
public class XRealization extends XDomainObject {
	public XClazz getClazz() {
		return new XClazz();
	}

	public XInterfaze getInterfaze() {
		return new XInterfaze();
	};
	public XProperty IsLast = new XProperty("IsLast",this);
	public XVariable tmp = new XVariable("tmp",this);

}
