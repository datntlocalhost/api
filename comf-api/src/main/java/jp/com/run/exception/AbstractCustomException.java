package jp.com.run.exception;

import org.springframework.http.HttpStatus;

/**
 * The Class AbstractCustomException.
 */
public class AbstractCustomException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The http status. */
	protected HttpStatus httpStatus;

	/**
	 * Instantiates a new abstract custom exception.
	 *
	 * @param message the message
	 */
	public AbstractCustomException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new abstract custom exception.
	 *
	 * @param message the message
	 * @param httpStatus the http status
	 */
	public AbstractCustomException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	/**
	 * Gets the http status.
	 *
	 * @return the http status
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * Sets the http status.
	 *
	 * @param httpStatus the new http status
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
