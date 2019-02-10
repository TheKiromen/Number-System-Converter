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
		char c;
		if(data.getBaseFrom()>10) {
			//Characters acceptable 0-9 and A-Z
			//Where A=11,B=12 and so on
			for(int i=0;i<tmp.length();i++) {
				c=tmp.charAt(i);
				if(!((c>='0'&&c<='9')||
					(c>='A'&&c<=(char)(54+data.getBaseFrom()))
					||c=='.')) {
					return false;
				}
			}
		}else {
			//Characters acceptable 0-9
			for(int i=0;i<tmp.length();i++) {
				c=tmp.charAt(i);
				if(c<'0'||
					c>Integer.toString(data.getBaseFrom()-1).charAt(0)
					||c=='.') {
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
