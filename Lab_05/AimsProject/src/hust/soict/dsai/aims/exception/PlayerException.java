package hust.soict.dsai.aims.exception;

@SuppressWarnings("serial")
public class PlayerException extends Exception{
	public PlayerException() {
		super();
	}

	public PlayerException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlayerException(String message) {
		super(message);
	}

	public PlayerException(Throwable cause) {
		super(cause);
	}
}