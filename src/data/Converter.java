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
			}else if(data.getBaseTo()==10) {
				result=toDecimal(data.getNumber(),data.getBaseFrom());
			}else {
				result=fromDecimal(toDecimal(data.getNumber(),data.getBaseFrom()),data.getBaseTo());
			}
		}
		
		return result;
	}
	
	
	private static boolean verify(FormData data) {
		String tmp=data.getNumber();
		char c;
		if(data.getBaseFrom()>10) {
			//Characters acceptable 0-9 and A-Z
			//Where A=10,B=11 and so on
			for(int i=0;i<tmp.length();i++) {
				c=tmp.charAt(i);
				if(!((c>='0'&&c<='9')||
					(c>='A'&&c<=(char)(54+data.getBaseFrom()))||c==46)) {
					return false;
				}
			}
		}else {
			//Characters acceptable 0-9
			for(int i=0;i<tmp.length();i++) {
				c=tmp.charAt(i);
				if(c!='.') {
					if(!(c>='0'&&c<=Integer.toString(data.getBaseFrom()-1).charAt(0))) {
						return false;
					}
					
				}
			}
		}
		return true;
	}
	
	
	private static String toDecimal(String number,int base) {
		String significand,floating_point;
		String result="";
		float sum=0f;
		
		//Splitting string
		int tmp = number.indexOf('.');
		if(tmp==-1) {
			significand=number;
			floating_point="0";
		}else if(tmp==0) {
			significand="0";
			floating_point=number.substring(1,number.length());
		}else {
			significand=number.substring(0,tmp);
			floating_point=number.substring(tmp+1,number.length());
		}
		
		//Converting significand
		for(int i=0;i<significand.length();i++) {
			if(base<=10) {
				sum+=(significand.charAt(i)-48)*Math.pow(base, significand.length()-1-i);
			}else {
				if(significand.charAt(i)>='A') {
					sum+=(significand.charAt(i)-55)*Math.pow(base, significand.length()-1-i);
				}else {
					sum+=(significand.charAt(i)-48)*Math.pow(base, significand.length()-1-i);
				}
			}
		}
		
		
		//converting floating point
		for(int i=0;i<floating_point.length();i++) {
			if(base<=10) {
				sum+=(floating_point.charAt(i)-48)*Math.pow(base, -(i+1));
			}else {
				if(floating_point.charAt(i)>='A') {
					sum+=(floating_point.charAt(i)-55)*Math.pow(base, -(i+1));
				}else {
					sum+=(floating_point.charAt(i)-48)*Math.pow(base, -(i+1));
				}
			}
		}
		
		
		result=Float.toString(sum);
		return result;
	}
	
	
	private static String fromDecimal(String number,int base) {
		int significand;
		float floating_point;
		String result="";
		
		//Splitting string
		int tmp = number.indexOf('.');
		if(tmp==-1) {
			significand=Integer.parseInt(number);;
			floating_point=0f;
		}else if(tmp==0) {
			significand=0;
			floating_point=Float.parseFloat("0."+number.substring(1,number.length()));
		}else {
			significand=Integer.parseInt(number.substring(0,tmp));
			floating_point=Float.parseFloat("0."+number.substring(tmp+1,number.length()));
		}
		
		//---TODO--- ISSUE WITH CONVERTING TO FLOAT
		//For example 0.12 gives 0.120001 or 0.123456789 gives 0.123457
		System.out.println(floating_point);

		while(significand!=0) {
			if(significand%base>=10) {
				result=(char)(significand%base+55)+result;
			}else {
				result=Integer.toString(significand%base)+result;
			}
			significand/=base;
		}
		
		if(!result.equals("")) {
			result+=".";
		}
		int limit=0;
		
		
		while(floating_point>0&&limit<100) {
			System.out.println(floating_point);
			floating_point*=base;
			result+=Math.floor(floating_point);
			floating_point-=Math.floor(floating_point);
			limit++;
		}
		
		return result;
	}
	
	
	
}
