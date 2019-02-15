package data;

public class FormData {
	private int baseFrom,baseTo;
	private String number;
	
	public FormData(String number,int baseFrom,int baseTo) {
		this.baseFrom=baseFrom;
		this.baseTo=baseTo;
		this.number=number.toUpperCase();
	}
	
	public int getBaseFrom() {
		return baseFrom;
	}
	public int getBaseTo() {
		return baseTo;
	}
	public String getNumber() {
		return number;
	}
	
	
}
