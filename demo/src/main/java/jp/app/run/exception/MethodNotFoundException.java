package jp.app.run.exception;

public class MethodNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MethodNotFoundException(String msg) {
		super(msg);
	}
}
