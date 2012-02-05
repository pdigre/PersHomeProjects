import java.util.ArrayList;
import java.util.Collection;

public class XMethod extends XDomainObject {
	public Collection<XParameter> iterateParameter() {
		return new ArrayList<XParameter>();
	}
	public XProperty Visibility = new XProperty("Visibility",this);
	public XProperty ModelType = new XProperty("ModelType",this);
	public XProperty Abstract = new XProperty("Abstract",this);
	public XProperty Name = new XProperty("Name",this);
	public XProperty HasDescription = new XProperty("HasDescription",this);
	public XVariable parameters = new XVariable("parameters",this);
	public XVariable parameterType = new XVariable("parameterType",this);

}
