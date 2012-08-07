
public class XVariable extends XProperty {

	public XVariable(String name, XObject xobject) {
		super(name, xobject);
	}
	
	@Override
	public String get() {
		return value;
	}
	
	public void set(String value){
		this.value=value;
	}
	
	public boolean hasValue(){
		return true;
	}
	
}
