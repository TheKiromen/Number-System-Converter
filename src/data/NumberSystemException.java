package data;

@SuppressWarnings("serial")
public class NumberSystemException extends Exception{
	
	@Override
	public String getMessage() {
		return "Invalid Input";
	}
}
