package com.integratec.controllers;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> methodArgumentNotValidException(@NotNull MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

        /*@ExceptionHandler(value = {MethodArgumentNotValidException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage methodArgumentNotValidException(@NotNull MethodArgumentNotValidException ex, @NotNull WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage(), request.getDescription(true));
        return message;
    }*/

}
