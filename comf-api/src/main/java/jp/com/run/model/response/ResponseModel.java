package jp.com.run.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The Class ResponseModel.
 */
@JsonSerialize
@JsonInclude(Include.NON_NULL)
public class ResponseModel {

	/** The result. */
	@JsonProperty(value = "result", index = 1)
	private Object result;
	
	/** The message. */
	@JsonProperty(value = "message", index = 2)
	private String message;
	
	/** The errors. */
	@JsonProperty(value = "errors", index = 3)
	private Object errors;

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public Object getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(Object errors) {
		this.errors = errors;
	}	
}
