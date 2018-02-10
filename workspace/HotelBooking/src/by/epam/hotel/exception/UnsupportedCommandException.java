package by.epam.hotel.exception;

public class UnsupportedCommandException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsupportedCommandException() {
    }

    public UnsupportedCommandException(String message) {
        super(message);
    }

    public UnsupportedCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedCommandException(Throwable cause) {
        super(cause);
    }
}
