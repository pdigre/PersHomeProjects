import java.util.ArrayList;
import java.util.Collection;

public class XGroup extends XMember {
	public Collection<XMember> iterateMember() {
		return new ArrayList<XMember>();
	}
	public XProperty Name = new XProperty("Name",this);
	public XProperty IsPrimaryKey = new XProperty("IsPrimaryKey",this);
	public XProperty IsDefaultDomainKey = new XProperty("IsDefaultDomainKey",this);

}
