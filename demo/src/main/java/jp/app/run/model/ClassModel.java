package jp.app.run.model;

import java.util.ArrayList;

public class ClassModel {
	
	private String clazz;
	private String description;
	private ArrayList<MethodModel> methods = new ArrayList<MethodModel>();
	
	public ClassModel() {}

	public ClassModel(String clazz, String description, ArrayList<MethodModel> methods) {
		super();
		this.clazz = clazz;
		this.description = description;
		this.methods = methods;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public ArrayList<MethodModel> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<MethodModel> methods) {
		this.methods = methods;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
