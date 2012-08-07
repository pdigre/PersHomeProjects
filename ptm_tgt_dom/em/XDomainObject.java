import java.util.ArrayList;
import java.util.Collection;

public class XDomainObject extends XObject {

	// 1:IsJavaContainer,JavaContainer,MappedJavaContainerType,NodeType,TypePackageName
	public XBoolean IsJavaContainer = new XBoolean("IsJavaContainer", this);
	public XProperty JavaContainer = new XProperty("JavaContainer", this);
	public XProperty MappedJavaContainerType = new XProperty(
			"MappedJavaContainerType", this);
	public XProperty NodeType = new XProperty("NodeType", this);
	public XProperty TypePackageName = new XProperty("TypePackageName", this);

	
	public XProperty Name = new XProperty("Name", this);
	public XProperty CommentFile = new XProperty("CommentFile", this);
	public XProperty GeneratedWith = new XProperty("GeneratedWith", this);
	public XProperty PackageName = new XProperty("PackageName", this);
	public XProperty GenerateJavaStyleEnums = new XProperty("GenerateJavaStyleEnums", this);
	public XBoolean HasDescription = new XBoolean("HasDescription", this);
	
	// 2:appendTransportSuffix,impSinPack,impSinPackOverridden,impSinType,impSinTypeOverridden,javaType,tmpSkip,typePackageName
	public XVariable appendTransportSuffix = new XVariable(
			"appendTransportSuffix", this);
	public XVariable impSinPack = new XVariable("impSinPack", this);
	public XVariable impSinPackOverridden = new XVariable(
			"impSinPackOverridden", this);
	public XVariable impSinType = new XVariable("impSinType", this);
	public XVariable impSinTypeOverridden = new XVariable(
			"impSinTypeOverridden", this);
	public XVariable javaType = new XVariable("javaType", this);
	public XVariable tmpSkip = new XVariable("tmpSkip", this);
	public XVariable typePackageName = new XVariable("typePackageName", this);

	
	
	public Collection<XClazz> iterateClass() {
		return new ArrayList<XClazz>();
	}

	public Collection<XInterfaze> iterateInterface() {
		return new ArrayList<XInterfaze>();
	}

	public Collection<XEnumerator> iterateEnumerator() {
		return new ArrayList<XEnumerator>();
	}

	public Collection<XDomain> iterateDomain() {
		return new ArrayList<XDomain>();
	}

	public Collection<XConverter> iterateConverter() {
		return new ArrayList<XConverter>();
	}

}
