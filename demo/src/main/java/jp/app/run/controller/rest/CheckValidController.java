package jp.app.run.controller.rest;

import java.lang.reflect.InvocationTargetException;

import javax.el.MethodNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.app.run.business.ExcuteMethod;
import jp.app.run.exception.CastParamException;
import jp.app.run.model.FormModel;
import jp.app.run.model.MethodModel;
import jp.app.run.model.response.ResponseModel;
import jp.app.run.util.JsonUtils;

@RestController
public class CheckValidController {

	@PostMapping(value = "/checkvalid")
	public String doPost(@RequestBody FormModel formModel, HttpServletRequest request) throws MethodNotFoundException, CastParamException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		
		HttpSession session = request.getSession();
		Object obj = null;
		
		for (int i = 0; i < formModel.getParameters().size(); i++) {
			if (formModel.getParameters().get(i).equals("$null")) {
				formModel.getParameters().set(i, null);
			}
		}
		
		String clazz = (String) session.getAttribute("class");
		MethodModel methodModel = (MethodModel) session.getAttribute("method");
		
		if (formModel != null && clazz != null && methodModel != null) {
			obj = ExcuteMethod.excute(formModel, clazz, methodModel);
		}
		
		ResponseModel responseModel = new ResponseModel();
		responseModel.setResult(obj.toString());
		responseModel.setError(false);
		
		return JsonUtils.ObjectToJson(responseModel);
	}
}
