package jp.co.run.exception;

import org.springframework.http.HttpStatus;

/**
 * The Class MethodNotFoundException.
 */
public class MethodNotFoundException extends AbstractCustomException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new method not found exception.
	 */
	public MethodNotFoundException() {
		super("Method not found exception.", HttpStatus.SERVICE_UNAVAILABLE);
	}
}
