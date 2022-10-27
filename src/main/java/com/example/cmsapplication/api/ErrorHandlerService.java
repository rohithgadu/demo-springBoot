package com.example.cmsapplication.api;

import com.example.cmsapplication.exception.ApplicatonError;
import com.example.cmsapplication.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandlerService extends ResponseEntityExceptionHandler {

    @Value("${api_url}")
    private String details;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicatonError> handleCustomerNotFoundException(CustomerNotFoundException exception, WebRequest webRequest){

        ApplicatonError error= new ApplicatonError();
        error.setCode(101);
        error.setMessage(exception.getMessage());
        error.setDetails(details);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
