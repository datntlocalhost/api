package jp.app.run.business;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

import javax.el.MethodNotFoundException;

import jp.app.run.exception.CastParamException;
import jp.app.run.model.FormModel;
import jp.app.run.model.MethodModel;
import jp.app.run.model.ParameterModel;

public class ExcuteMethod {
	
	/*
	 * Excute method and return.
	 * 
	 * @param formModel
	 *        This form contain list of parameters that want to put into method.
	 * @param className
	 *        The name of the class that contain method want to excute.
	 * @paramm methodModel
	 *        The info of method want to excute.
	 * 
	 * @return object.
	 *        That result of the method return.
	 */
	public static Object excute(FormModel formModel, String className, MethodModel methodModel) throws CastParamException, 
																								   MethodNotFoundException,
																								   IllegalAccessException,
																								   IllegalArgumentException,
																								   InvocationTargetException,
																								   ClassNotFoundException {
		
		ArrayList<Object> castedParam = new ArrayList<Object>();
		ArrayList<String> typeParam   = new ArrayList<String>();
		Object   result = null;
		
		if (formModel == null || methodModel == null) {
			return result;
		}
		
		ArrayList<String> formParam = formModel.getParameters();
		
		for (ParameterModel parameterModel : methodModel.getParameterModels()) {
			typeParam.add(parameterModel.getTypeParameter());
		}
		
		Class<?> clazz = ClassFactory
							.getInstance()
								.getClassByName(className);
		
		Method method = ClassFactory
							.getInstance()
								.getMethodToExcute(className, methodModel.getMethodName(), typeParam);
		
		if (clazz == null || method == null) {
			throw new MethodNotFoundException();
		}
		
		Parameter[] parameters = method.getParameters();
		
		int lenParam = parameters.length;
		int lenFormParam = formParam.size();
		
		if (lenParam == lenFormParam) {
			
			for (int i = 0; i < lenParam; i++) {
				String type = parameters[i].getType().toString();
				Object cast = castType(type, formParam.get(i));
				castedParam.add(cast);
			}
			
			result = method.invoke(clazz, castedParam.toArray());
		}

		return result;
	}
	
	/*
	 * Cast value to data type.
	 * 
	 * @param type
	 * @param value
	 * 
	 * @return object
	 * 
	 * @throws CastParamException
	 */
	public static Object castType(String type, String value) throws CastParamException {
		
		Object object = null;
		
		try {
			if (value == null) {
				return object;
			} else if (type.equals("byte")) {
				object = Byte.parseByte(value);
			} else if (type.equals("boolean")) {
				object = Boolean.parseBoolean(value);
			} else if (type.equals("short")) {
				object = Short.parseShort(value);
			} else if (type.equals("char")) {
				if (value.length() == 1) {
					object = value.toCharArray()[0];
				}
			} else if (type.equals("int")) {
				object = Integer.parseInt(value);
			} else if (type.equals("long")) {
				object = Long.parseLong(value);
			} else if (type.equals("float")) {
				object = Float.parseFloat(value);
			} else if (type.equals("double")) {
				object = Double.parseDouble(value);
			} else {
				object = value;
			}
		} catch (Exception e) {}
		
		if (object == null) {
			throw new CastParamException("Cast parameters exception.");
		}
		
		return object;
	}
}
