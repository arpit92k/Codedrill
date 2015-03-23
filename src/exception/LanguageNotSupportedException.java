package exception;

@SuppressWarnings("serial")
public class LanguageNotSupportedException extends Exception{
	public LanguageNotSupportedException(String msg){
		super("Unsupported langauage : "+msg);
	}
}
