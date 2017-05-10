package comp;

//Generic Attribute for all purposes
public class GEN_Attribute {
	
	private String name;
	private String value;
	
	public GEN_Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return name +"='"+ value + "'";
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
