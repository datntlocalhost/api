package jp.com.run.exception;

import org.springframework.http.HttpStatus;

/**
 * The Class ParameterNotMatchException.
 */
public class ParameterNotMatchException extends AbstractCustomException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new parameter not match exception.
	 */
	public ParameterNotMatchException() {
		super("Parameters invalid exception.", HttpStatus.BAD_REQUEST);
	}
}
