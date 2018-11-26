package jp.co.run.model;

import java.util.List;

/**
 * The Class ClassModel.
 */
public class ClassModel {

	/** The name. */
	private String name;
	
	/** The description. */
	private String desc;
	
	/** The methods. */
	private List<MethodModel> methods;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Gets the methods.
	 *
	 * @return the methods
	 */
	public List<MethodModel> getMethods() {
		return methods;
	}

	/**
	 * Sets the methods.
	 *
	 * @param methods the new methods
	 */
	public void setMethods(List<MethodModel> methods) {
		this.methods = methods;
	}

}
