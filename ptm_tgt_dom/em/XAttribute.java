public class XAttribute extends XMember {
	public XConverter getConverter() {
		return new XConverter();
	}
	public XProperty HasDescription = new XProperty("HasDescription",this);
	public XProperty InitialValue = new XProperty("InitialValue",this);
	public XProperty Visibility = new XProperty("Visibility",this);
	public XProperty IsDefaultDomainKey = new XProperty("IsDefaultDomainKey",this);
	public XProperty HasInitialValue = new XProperty("HasInitialValue",this);
	public XProperty Name = new XProperty("Name",this);
	public XProperty IsPrimaryKey = new XProperty("IsPrimaryKey",this);
	public XProperty IsStatic = new XProperty("IsStatic",this);
	public XVariable pVisibility = new XVariable("pVisibility",this);
	public XVariable javaType = new XVariable("javaType",this);
	public XVariable pTypeStripGen = new XVariable("pTypeStripGen",this);
	public XVariable pType = new XVariable("pType",this);
	public XVariable pName = new XVariable("pName",this);
	public XVariable KeyFound = new XVariable("KeyFound",this);
}
