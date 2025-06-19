package org.example.springsec.ecomm.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(RecordNotFoundException e) {
        ErrorResponse res = new ErrorResponse(e.getMessage(), Collections.singletonList(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(res);
    }
    @ExceptionHandler(DuplicatedRecordException.class)
    public ResponseEntity<?> handleDuplicatedRecordExcitpion(DuplicatedRecordException e) {
        ErrorResponse res = new ErrorResponse(e.getMessage(), Collections.singletonList(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(res);
    } @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<?> handleInvalidValueException(InvalidValueException e) {
        ErrorResponse res = new ErrorResponse(e.getMessage(), Collections.singletonList(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(res);
    }





}
