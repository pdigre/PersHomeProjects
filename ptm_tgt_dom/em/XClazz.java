import java.util.ArrayList;
import java.util.Collection;

public class XClazz extends XDomainObject {
	public Collection<XAttribute> iterateAttribute() {
		return new ArrayList<XAttribute>();
	}

	public Collection<XMethod> iterateMethod() {
		return new ArrayList<XMethod>();
	}

	public Collection<XGeneralization> iterateGeneralization() {
		return new ArrayList<XGeneralization>();
	}

	public Collection<XRealization> iterateRealization() {
		return new ArrayList<XRealization>();
	}

	public Collection<XGroup> iterateGroup() {
		return new ArrayList<XGroup>();
	}

	public Collection<XAssociation> iterateAssociation() {
		return new ArrayList<XAssociation>();
	}

	public XProperty PackageName = new XProperty("PackageName",this);
	public XProperty IsPersistent = new XProperty("IsPersistent",this);
	public XProperty Abstract = new XProperty("Abstract",this);
	public XProperty Name = new XProperty("Name",this);
	public XVariable ImplementSerializable = new XVariable("ImplementSerializable",this);
	public XVariable SuperClassPackage = new XVariable("SuperClassPackage",this);
	public XVariable DefaultDomainKey = new XVariable("DefaultDomainKey",this);
	public XVariable SubImports = new XVariable("SubImports",this);
	public XVariable Methods = new XVariable("Methods",this);
	public XVariable Imports = new XVariable("Imports",this);
	public XVariable SuperClassName = new XVariable("SuperClassName",this);
	public XVariable PrimaryKey = new XVariable("PrimaryKey",this);
	public XVariable MethodVisibility = new XVariable("MethodVisibility",this);
	public XVariable Serializable = new XVariable("Serializable",this);

}
