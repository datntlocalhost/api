package jp.co.run.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.run.exception.AbstractCustomException;
import jp.co.run.model.Test;
import jp.co.run.model.request.ValidationRequestModel;
import jp.co.run.service.ValidationService;

/**
 * The Class ValidatorController.
 */
@RestController
@RequestMapping("/api")
public class ValidatorController {
	
	/** The validation service. */
	private final ValidationService validationService;
	
	/**
	 * Instantiates a new validator controller.
	 *
	 * @param validationService the validation service
	 */
	public ValidatorController(ValidationService validationService) {
		this.validationService = validationService;
	}

	/**
	 * Execute get list method.
	 *
	 * @return the response entity
	 */
	@GetMapping("/validator")
	public ResponseEntity<?> executeGetListMethod() {
		
		return validationService.loadClassList();
	}
	
	/**
	 * Execute validation.
	 *
	 * @param request the request
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PostMapping("/validator")
	public ResponseEntity<?> executeValidation(@Valid @RequestBody ValidationRequestModel request) throws AbstractCustomException {
		System.err.println(request.getClassName());
		return validationService.executeMethod(request);
	}
	
	@PostMapping("/test")
	public ResponseEntity<?> excutee(@RequestBody Test test) {
		System.err.println("sdadsasad");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}