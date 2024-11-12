package kr.hs.sdh.toast.controller;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class BankRestControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String>  login(MethodArgumentNotValidException exception) {
        final List<FieldError> fieldErrors = exception.getFieldErrors();
        Map<String, String> returnMessages = new HashMap<>();

        for (FieldError fieldError : fieldErrors) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            returnMessages.put(field, field + message);
        }

        return returnMessages;
    }

}
