


public class XProperty {

	public String name;
	public String value;
	public XObject owner;

	public XProperty(String name, XObject xobject) {
		this.name=name;
		this.owner=xobject;
	}

	public String get(){
		return value;
	}
	public int toInt(){
		return Integer.parseInt(value) ;
	}
	public boolean toBool(){
		return Boolean.getBoolean(value) ;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
