package jp.app.run.model;

import java.util.ArrayList;

public class FormModel {
	
	private ArrayList<String> parameters = new ArrayList<String>();
	
	public FormModel() {}

	public FormModel(String className, int signature, String methodName, ArrayList<String> parameters) {
		super();
		this.parameters = parameters;
	}


	public ArrayList<String> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}
}
