package jp.co.run.model;

import java.util.List;

/**
 * The Class MethodModel.
 */
public class MethodModel {

	/** The id. */
	private String id;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String desc;
	
	/** The parameters. */
	private List<MethodParamModel> params;
	
	/** The returns. */
	private MethodReturnModel returns;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * Gets the desc.
	 *
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the desc.
	 *
	 * @param desc the new desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Gets the params.
	 *
	 * @return the params
	 */
	public List<MethodParamModel> getParams() {
		return params;
	}

	/**
	 * Sets the params.
	 *
	 * @param params the new params
	 */
	public void setParams(List<MethodParamModel> params) {
		this.params = params;
	}

	/**
	 * Gets the returns.
	 *
	 * @return the returns
	 */
	public MethodReturnModel getReturns() {
		return returns;
	}

	/**
	 * Sets the returns.
	 *
	 * @param returns the new returns
	 */
	public void setReturns(MethodReturnModel returns) {
		this.returns = returns;
	}
	
}
