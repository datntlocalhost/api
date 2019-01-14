package jp.com.run.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.com.run.exception.AbstractCustomException;
import jp.com.run.model.request.ValidationRequestModel;
import jp.com.run.model.TestModel;
import jp.com.run.model.request.SearchZipcodeRequestModel;
import jp.com.run.service.ValidationService;
import jp.com.run.service.ZipcodeService;

/**
 * The Class ValidatorController.
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ValidatorController {

    /** The validation service. */
    private final ValidationService validationService;
    
    private final ZipcodeService zipcodeService;

    /**
     * Instantiates a new validator controller.
     *
     * @param validationService the validation service
     */
    public ValidatorController(ValidationService validationService, ZipcodeService zipcodeService) {
        this.validationService = validationService;
        this.zipcodeService = zipcodeService;
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
    public ResponseEntity<?> executeValidation(@Valid @RequestBody ValidationRequestModel request)
        throws AbstractCustomException {
        SearchZipcodeRequestModel model = new SearchZipcodeRequestModel();
        if (request.getClassName().equals("jp.co.run.util.StringUtil")) {
            if (request.getMethodId().equals("FV7") || request.getMethodId().equals("FV8")) {
                String zipcode = (String) request.getParameters().get(0);
                boolean isEN   = request.getMethodId().equals("FV7") ? (boolean) request.getParameters().get(1) : true;
                model.setSearchKey(zipcode);
                model.setEnglish(isEN);
                model.setZipcode(request.getMethodId().equals("FV7"));
                return zipcodeService.searchZipcodeAddress(model);
            }
        }
        return validationService.executeMethod(request);
    }
}
