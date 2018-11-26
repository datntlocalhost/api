package jp.co.run.exception;

import org.springframework.http.HttpStatus;

/**
 * The Class ClassNotFoundException.
 */
public class ClassNotFoundException extends AbstractCustomException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new class not found exception.
	 */
	public ClassNotFoundException() {
		super("Class not found exception.", HttpStatus.SERVICE_UNAVAILABLE);
	}
}
