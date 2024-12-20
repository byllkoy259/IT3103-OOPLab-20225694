package hust.soict.dsai.aims.exception;

@SuppressWarnings("serial")
public class MediaException extends Exception{
	public MediaException() {
		super();
	}

	public MediaException(String message, Throwable cause) {
		super(message, cause);
	}

	public MediaException(String message) {
		super(message);
	}

	public MediaException(Throwable cause) {
		super(cause);
	}
}
