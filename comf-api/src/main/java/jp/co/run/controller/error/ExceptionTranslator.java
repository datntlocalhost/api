package jp.co.run.controller.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jp.co.run.exception.AbstractCustomException;
import jp.co.run.util.ResponseUtil;

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
}
