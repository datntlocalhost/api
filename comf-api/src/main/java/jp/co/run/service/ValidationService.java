package jp.co.run.service;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jp.co.run.exception.AbstractCustomException;
import jp.co.run.exception.ClassNotFoundException;
import jp.co.run.exception.MethodNotFoundException;
import jp.co.run.exception.ParameterNotMatchException;
import jp.co.run.model.ClassModel;
import jp.co.run.model.request.ValidationRequestModel;
import jp.co.run.util.ResponseUtil;

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
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Access-Control-Allow-Origin", "*");
		
		return new ResponseEntity<>(ResponseUtil.createResult(allClass), headers , HttpStatus.OK);
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
			throw new ClassNotFoundException();
		}
		
		if (method == null) {
			throw new MethodNotFoundException();
		}
		
		try {
			result = method.invoke(clazz, request.getParameters().toArray());
		} catch (Exception e) {
			throw new ParameterNotMatchException();
		}
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Access-Control-Allow-Origin", "*");
		
		return new ResponseEntity<>(ResponseUtil.createResult(result), headers, HttpStatus.OK);
	}
}
