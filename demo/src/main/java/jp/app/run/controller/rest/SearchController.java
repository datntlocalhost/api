package jp.app.run.controller.rest;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.app.run.business.ClassFactory;
import jp.app.run.model.ClassModel;
import jp.app.run.model.MethodModel;
import jp.app.run.util.JsonUtils;

@RestController
public class SearchController {

	/*
	 * Get class by class's name.
	 * 
	 * @param className
	 *        The name of class want to get.
	 * @return json string
	 */
	@GetMapping(value = "/class")
	public String getListMethod(@RequestParam("class") String className) {
		
		ClassModel classModel = ClassFactory.getInstance().getClassInfoByName(className);
		
		return JsonUtils.ObjectToJson(classModel);
	}
	
	@GetMapping(value = "/method")
	public String getMethod(@RequestParam("class") String className, 
							@RequestParam("method") String method,
							@RequestParam("signature") int signature,
							HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		MethodModel methodModel = ClassFactory.getInstance().getMethodInfoByName(className, method, signature);
		
		session.setAttribute("class", className);
		session.setAttribute("method", methodModel);
		
		return JsonUtils.ObjectToJson(methodModel);
	}
	
	@GetMapping(value = "/search")
	public String searchMethod(@RequestParam("method") String methodName) {
		
		ArrayList<ClassModel> classList = new ArrayList<ClassModel>();
		
		if (methodName != null) {
			
			classList = ClassFactory.getInstance().searchMethodByName(methodName);
			
		}
		
		return JsonUtils.ObjectToJson(classList);
	}
}
