package jp.com.run.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.com.run.model.request.InquiryRequestModel;
import jp.com.run.model.request.RegisterRequestModel;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RegisterController {

    @PostMapping("/register")
    public ResponseEntity<?> regesiter(@Valid @RequestBody RegisterRequestModel request) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/inquiry")
    public ResponseEntity<?> inquiery(@Valid @RequestBody InquiryRequestModel request) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
