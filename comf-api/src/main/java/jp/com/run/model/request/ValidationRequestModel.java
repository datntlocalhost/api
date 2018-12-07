package jp.com.run.model.request;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * The Class RequestModel.
 */
public class ValidationRequestModel {

	/** The class name. */
	@NotNull
	private String className;
	
	/** The method's id. */
	@NotNull
	private String methodId;
	
	/** The parameters. */
	@NotNull
	private List<Object> parameters;

	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets the class name.
	 *
	 * @param className the new class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Gets the method id.
	 *
	 * @return the method id
	 */
	public String getMethodId() {
		return methodId;
	}

	/**
	 * Sets the method id.
	 *
	 * @param methodId the new method id
	 */
	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public List<Object> getParameters() {
		return parameters;
	}

	/**
	 * Sets the parameters.
	 *
	 * @param parameters the new parameters
	 */
	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}

}
