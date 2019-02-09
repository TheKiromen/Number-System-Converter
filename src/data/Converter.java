package data;

public class Converter{ 
	
	private Converter() {}
	
	public static String convert(FormData data) throws NumberSystemException {
		String result="";
		
		//---Verification
		if(!verify(data)) {
			throw new NumberSystemException();
		}else {
			//---Conversion
			if(data.getBaseFrom()==data.getBaseTo()) {
				result=data.getNumber();
			}else if(data.getBaseFrom()==10) {
				result=toDecimal(data.getNumber());
			}else {
				//CONVERSION
			}
		}
		
		return result;
	}
	
	
	private static boolean verify(FormData data) {
		String tmp=data.getNumber().toUpperCase();
		if(data.getBaseFrom()>10) {
			//Characters acceptable 0-9 and A-Z
			//Where A=11,B=12 and so on
			for(int i=0;i<tmp.length();i++) {
				if(!((tmp.charAt(i)>='0'&&tmp.charAt(i)<='9')||
					(tmp.charAt(i)>='A'&&tmp.charAt(i)<=(char)(54+data.getBaseFrom())))) {
					return false;
				}
			}
		}else {
			//Characters acceptable 0-9
			for(int i=0;i<tmp.length();i++) {
				if(tmp.charAt(i)<'0'||
					tmp.charAt(i)>Integer.toString(data.getBaseFrom()-1).charAt(0)) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	private static String toDecimal(String number) {
		String result="";
		return result;
	}
	
}
