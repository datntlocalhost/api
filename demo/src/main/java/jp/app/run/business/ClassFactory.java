package jp.app.run.business;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.app.run.model.ClassModel;
import jp.app.run.model.MethodModel;
import jp.app.run.util.PropertiesUtils;

public class ClassFactory {
	
	private ArrayList<ClassModel> classInfoList = new ArrayList<ClassModel>();
	private ArrayList<Class<?>> classList = new ArrayList<Class<?>>();
	
	private static ClassFactory instance = null;
	
	private ClassFactory() {
		loadClassFromFile();
		loadClassFromJar();
	}
	
	public static ClassFactory getInstance() {
		if (instance == null) {
			instance = new ClassFactory();
		}
		return instance;
	}

	
	/*
	 * Get class by name.
	 * 
	 * @param className
	 *        The name of class want to get.
	 *        
	 * @return class model if the class is exist, else return null.
	 */
	public ClassModel getClassInfoByName(String className) {
		
		for (ClassModel clazz : this.classInfoList) {
			if (clazz.getClazz().equals(className)) {
				return clazz;
			}
		}
		return null;
	}
	
	/*
	 * Get method by name.
	 * 
	 * @param className
	 *        The name of class that contain the method want to get.
	 * @param methodName
	 *        The name of method want to get.
	 * @param signature
	 *        The signature of the method want to get.
	 * @return method model, return null if className or methodName is not exist.
	 */
	public MethodModel getMethodInfoByName(String className, String methodName, int signature) {
		ClassModel classModel = getClassInfoByName(className);
		
		if (classModel != null) {
			for (MethodModel md : classModel.getMethods()) {
				if (md.getMethodName().equals(methodName) && md.getSignature() == signature) {
					return md;
				}
			}
		}
		return null;
	}
	
	/*
	 * Get class from class list by name.
	 * 
	 * @param className
	 * @return class want to get.
	 */
	public Class<?> getClassByName(String className) {
		
		for (Class<?> clazz : this.classList) {
			if (clazz.getName().equals(className)) {
				return clazz;
			}
		}
		
		return null;
	}
	
	/*
	 * Get method reflecter to process by method name.
	 * 
	 * @param className
	 *        The class that contain method want to call.
	 * @param methodName
	 *        The method's name want to call.
	 * @param params
	 *        The parameters for that method.
	 * @return method reflecter, return null if the method is not exist.
	 */
	public Method getMethodToExcute(String className, String methodName, ArrayList<String> params) {
		
		Method md = null;
		
		Class<?> clazz = getClassByName(className);
		
		if (clazz != null) {
			Method[] methods = clazz.getMethods();
			
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					if (this.matchParameter(params, method.getParameters())) {
						md = method;
					}
				}
			}
		}
		
		return md;
	}
	
	/*
	 * Search all method by name. if the methodName is empty then return all method.
	 * 
	 * @param methodName
	 *        The name of method want to search.
	 * @return classInfoList
	 *         List of class model that contain method.
	 */
	public ArrayList<ClassModel> searchMethodByName(String methodName) {
		ArrayList<ClassModel> classInfoList = new ArrayList<ClassModel>();
		
		for (ClassModel classModel : this.classInfoList) {
			ArrayList<MethodModel> methods = new ArrayList<MethodModel>();
			
			for (MethodModel methodModel : classModel.getMethods()) {
				if (methodName.length() == 0) {
					methods.add(methodModel);
				} else if (methodModel.getMethodName().equals(methodName)) {
					methods.add(methodModel);
				}
			}
			
			if (methods.size() > 0) {
				ClassModel clazz = new ClassModel(classModel.getClazz(), classModel.getDescription(), methods);
				classInfoList.add(clazz);
			}
		}
		
		return classInfoList;
	}
	
	/*
	 * Get size of the class list.
	 * 
	 * @return size of class list.
	 */
	public int getClassInfoSize() {
		return this.classInfoList.size();
	}
	
	public ArrayList<ClassModel> getClassInfoList() {
		return classInfoList;
	}
	
	/*
	 * To match parameter of method and parameter that get from client.
	 * 
	 * @param param1
	 *        The parameters get from client.
	 * @param param2
	 *        The parameters of method.
	 * 
	 * @return true if the param1 is matched param2, else return fasle.
	 */
	private boolean matchParameter(ArrayList<String> param1, Parameter[] param2) {
		
		if (param1 == null || param2 == null) {
			return false;
		}
		
		int lenParam = param2.length;
		
		for (int i = 0; i < lenParam; i++) {
			if (!param2[i].getType().getName().endsWith(param1.get(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Load all class and method info from json file.
	 */
	public void loadClassFromFile() {
		
		String fileName = PropertiesUtils.getInstance().getValue("methods.name");
		
		if (fileName.length() == 0) {
			fileName = "method-description.json";
		}
		
		FileReader fileReader = null;
		
		try {
			String filePath = getClass().getClassLoader().getResource("extends/" + fileName).getFile();
			File file = new File(filePath);
			JSONParser jsonParser = new JSONParser();
			fileReader = new FileReader(file);
			
			Object object = jsonParser.parse(fileReader);
			
			JSONArray jsonArray = (JSONArray) object;
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			for (Object jsonObject : jsonArray) {
				ClassModel classModel = objectMapper.readValue(jsonObject.toString(), ClassModel.class);
				
				if (classModel != null) {
					this.classInfoList.add(classModel);
				}
			}
			
		} catch (Exception e) {
			
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {}
			}
		}
	}
	
	public void loadClassFromJar() {
		
		if (getClassInfoSize() == 0) {
			return;
		}
		
		String jarName = PropertiesUtils.getInstance().getValue("validation.jar.name");
		
		if (jarName.length() == 0) {
			jarName = "ValidationCommon.jar";
		}
		
		URLClassLoader urlClassLoader = null;
		
		try {
			String jarPath = getClass().getClassLoader().getResource("extends/" + jarName).getFile();
			File jarFile = new File(jarPath);
			URL fileUrl = jarFile.toURI().toURL();
			
			String jarUrl = "jar:" + fileUrl + "!/";
			
			URL urls[] = {new URL(jarUrl)};
			
			urlClassLoader = new URLClassLoader(urls);
			
			for (ClassModel classModel : getClassInfoList()) {
				try {
					Class<?> clazz = Class.forName(classModel.getClazz(), true, urlClassLoader);
					this.classList.add(clazz);
				} catch (ClassNotFoundException e) {}
			}
			
		} catch (Exception e) {
			
		} finally {
			if (urlClassLoader != null) {
				try {
					urlClassLoader.close();
				} catch (IOException e) {}
			}
		}
		
	}
	
	public void updateClassFactory() {
		this.classInfoList.clear();
		this.classList.clear();
		
		PropertiesUtils.getInstance().reloadResource();
		
		loadClassFromFile();
		loadClassFromJar();
	}
}
