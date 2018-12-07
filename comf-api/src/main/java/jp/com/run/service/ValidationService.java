package jp.com.run.service;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jp.com.run.exception.AbstractCustomException;
import jp.com.run.exception.MethodNotFoundException;
import jp.com.run.exception.ParameterNotMatchException;
import jp.com.run.model.ClassModel;
import jp.com.run.model.request.ValidationRequestModel;
import jp.com.run.util.ResponseUtil;

/**
 * The Class ValidationService.
 */
@Service
public class ValidationService {

	/**
	 * Load class list.
	 *
	 * @return the response entity
	 */
	public ResponseEntity<?> loadClassList() {
		
		List<ClassModel> allClass = MethodManager.getInstance().getAllClass();
		
		if (allClass == null || allClass.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(ResponseUtil.createResult(allClass), HttpStatus.OK);
	}
	
	/**
	 * Execute method.
	 *
	 * @param request the request
	 * @return the response entity
	 * @throws AbstractCustomException the abstract custom exception
	 */
	public ResponseEntity<?> executeMethod(ValidationRequestModel request) throws AbstractCustomException {
		
		Object   result = null;
		Class<?> clazz  = MethodManager.getInstance().getClassz(request.getClassName());
		Method   method = MethodManager.getInstance().getMethod(clazz, request.getMethodId());
		
		if (clazz == null) {
			throw new jp.com.run.exception.ClassNotFoundException();
		}
		
		if (method == null) {
			throw new MethodNotFoundException();
		}
		
		try {
			result = method.invoke(clazz, request.getParameters().toArray());
		} catch (Exception e) {
			throw new ParameterNotMatchException();
		}
		
		return new ResponseEntity<>(ResponseUtil.createResult(result), HttpStatus.OK);
	}
}
