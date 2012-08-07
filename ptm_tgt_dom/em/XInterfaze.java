import java.util.ArrayList;
import java.util.Collection;

public class XInterfaze extends XMember {
	public Collection<XAttribute> iterateAttribute() {
		return new ArrayList<XAttribute>();
	}

	public Collection<XMethod> iterateMethod() {
		return new ArrayList<XMethod>();
	}

	public Collection<XGeneralization> iterateGeneralization() {
		return new ArrayList<XGeneralization>();
	}
	public XProperty PackageName = new XProperty("PackageName",this);
	public XProperty Name = new XProperty("Name",this);
	public XVariable Generalization = new XVariable("Generalization",this);
	public XVariable Imports = new XVariable("Imports",this);

}
