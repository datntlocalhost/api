package jp.app.run.model.response;

public class ResponseModel {
	
	private String  result;
	private boolean error;
	private String  errorMsg;
	
	public ResponseModel() {}
	
	public ResponseModel(String result, boolean error, String errorMsg) {
		super();
		this.result = result;
		this.error = error;
		this.errorMsg = errorMsg;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
