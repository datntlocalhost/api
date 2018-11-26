package jp.app.run.model;

import java.util.ArrayList;
import java.util.List;

public class MethodModel {
	
	private int    signature;
	private String methodName;
	private String description;
	private int    numParameter;
	private List<ParameterModel> parameterModels = new ArrayList<ParameterModel>();
	private String returns;
	
	public MethodModel() {}

	public MethodModel(int signature, String methodName, String description, int numParameter, List<ParameterModel> parameterModels, String returns) {
		super();
		this.signature  = signature;
		this.methodName = methodName;
		this.description = description;
		this.numParameter = numParameter;
		this.parameterModels = parameterModels;
		this.returns = returns;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public int getNumParameter() {
		return numParameter;
	}

	public void setNumParameter(int numParameter) {
		this.numParameter = numParameter;
	}

	public List<ParameterModel> getParameterModels() {
		return parameterModels;
	}

	public void setParameterModels(List<ParameterModel> parameterModels) {
		this.parameterModels = parameterModels;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSignature() {
		return signature;
	}

	public void setSignature(int signature) {
		this.signature = signature;
	}

	public String getReturns() {
		return returns;
	}

	public void setReturns(String returns) {
		this.returns = returns;
	}
	
}
