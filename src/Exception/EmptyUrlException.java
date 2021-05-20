package Exception;

public class EmptyUrlException extends Exception {
	
	public EmptyUrlException() {
		super("Your URL is empty");
	}

}
