package data;

public class Converter {
	
	private Converter() {}
	
	public static String convert(FormData data) {
		String result="";
		if(data.getBaseFrom()==data.getBaseTo()) {
			result=data.getNumber();
		}
		return result;
	}
	
	private static String toDecimal() {
		String result="";
		return result;
	}
	
}
