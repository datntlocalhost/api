package jp.app.run.controller.advice;

import javax.el.MethodNotFoundException;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.ParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.app.run.model.response.ResponseModel;
import jp.app.run.util.JsonUtils;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public @ResponseBody String processExcetion(Exception e) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setError(true);
		
		if (e instanceof ParameterException) {
			responseModel.setErrorMsg("Invalid paramters.");
		} else if (e instanceof MethodNotFoundException) {
			responseModel.setErrorMsg("Method not found.");
		} else {
			responseModel.setErrorMsg(e.toString());
		}
		
		return JsonUtils.ObjectToJson(responseModel);
	}
}
