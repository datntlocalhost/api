package jp.app.run.util;

import java.util.ResourceBundle;

public class PropertiesUtils {

	private ResourceBundle resourceBundle = null;
	
	private static PropertiesUtils instance = null;
	
	private PropertiesUtils() {
		loadResource();
	}
	
	public static PropertiesUtils getInstance() {
		if (instance == null) {
			instance = new PropertiesUtils();
		}
		return instance;
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public String getValue(String key) {
		StringBuilder stringBuilder = new StringBuilder();
		
		if (this.resourceBundle != null) {
			stringBuilder.append(this.resourceBundle.getString(key));
		}
		
		return stringBuilder.toString();
	}
	
	@SuppressWarnings("static-access")
	public void reloadResource() {
		this.resourceBundle.clearCache();
		loadResource();
	}
	
	private void loadResource() {
		this.resourceBundle = ResourceBundle.getBundle("system");
	}
	
}
