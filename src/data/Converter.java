package data;

public class Converter{ 
	
	private Converter() {}
	
	public static String convert(FormData data) throws NumberSystemException {
		String result="";
			//CODE TO VERIFY IF INPUT IS IN RIGHT NUMBER SYSTEM
			//IF NOT
			//throw new NumberSystemException();
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
