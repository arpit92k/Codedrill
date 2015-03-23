package exception;

@SuppressWarnings("serial")
public class LanguageNotSupportedException extends Exception{
	String msg;
	public LanguageNotSupportedException(String msg){
		this.msg=msg;
	}
	public String getMessage(){
		return "Unsupported langauage : "+msg;	
	}
}
