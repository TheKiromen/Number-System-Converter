package data;

public class FormData {
	private int precision,baseFrom,baseTo;
	private String number;
	
	public FormData(String number,int baseFrom,int baseTo,int precision) {
		this.precision=precision;
		this.baseFrom=baseFrom;
		this.baseTo=baseTo;
		this.number=number;
	}
	
	public int getPrecision() {
		return precision;
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
