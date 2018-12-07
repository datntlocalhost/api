package jp.com.run.controller.error;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jp.com.run.exception.AbstractCustomException;
import jp.com.run.util.ResponseUtil;

/**
 * The Class ExceptionTranslator.
 */
@ControllerAdvice
@CrossOrigin
public class ExceptionTranslator {

    /**
     * Process.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(AbstractCustomException.class)
    public ResponseEntity<?> processCustomException(AbstractCustomException exception) {
        return new ResponseEntity<>(ResponseUtil.createError(exception.getMessage()), exception.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> processBadRequest(MethodArgumentNotValidException exception) {

        Map<String, List<String>> body = new LinkedHashMap<>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {

            if (body.get(fieldError.getField()) == null) {
                List<String> list = new ArrayList<>();
                list.add(fieldError.getDefaultMessage());
                body.put(fieldError.getField(), list);
            } else {
                body.get(fieldError.getField()).add(fieldError.getDefaultMessage());
            }
        }

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ResponseEntity<?> processInternalServer(Exception exception) {
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
