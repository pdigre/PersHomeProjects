public class XAssociation extends XDomainObject {
	public XClazz getMemberClass() {
		return new XClazz();
	}

	public XClazz getOwnerClass() {
		return new XClazz();
	}
 
	public XProperty Description = new XProperty("Description",this);
	public XProperty IsMemberNavigable = new XProperty("IsMemberNavigable",this);
	public XProperty HasDescription = new XProperty("HasDescription",this);
	public XProperty IsOwnerMany = new XProperty("IsOwnerMany",this);
	public XProperty IsMemberMany = new XProperty("IsMemberMany",this);
	public XProperty MemberClassName = new XProperty("MemberClassName",this);
	public XProperty MemberRoleName = new XProperty("MemberRoleName",this);
	public XProperty OwnerRoleName = new XProperty("OwnerRoleName",this);
	public XProperty OwnerClassName = new XProperty("OwnerClassName",this);
	public XProperty IsOwnerNavigable = new XProperty("IsOwnerNavigable",this);
	public XVariable pName = new XVariable("pName",this);
	public XVariable pVisibility = new XVariable("pVisibility",this);
	public XVariable pTypeStripGen = new XVariable("pTypeStripGen",this);
	public XVariable pType = new XVariable("pType",this);
	public XVariable impSinType = new XVariable("impSinType",this);
	public XVariable impSinPack = new XVariable("impSinPack",this);

}
