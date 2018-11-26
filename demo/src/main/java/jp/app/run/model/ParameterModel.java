package jp.app.run.model;

public class ParameterModel {

	private String nameParameter;
	private String typeParameter;
	private String description;
	
	public ParameterModel() {}

	public ParameterModel(String nameParameter, String typeParameter, String description) {
		super();
		this.nameParameter = nameParameter;
		this.typeParameter = typeParameter;
		this.description = description;
	}

	public String getNameParameter() {
		return nameParameter;
	}

	public void setNameParameter(String nameParameter) {
		this.nameParameter = nameParameter;
	}

	public String getTypeParameter() {
		return typeParameter;
	}

	public void setTypeParameter(String typeParameter) {
		this.typeParameter = typeParameter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
