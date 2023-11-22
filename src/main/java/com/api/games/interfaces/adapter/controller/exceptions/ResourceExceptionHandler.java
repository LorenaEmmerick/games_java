package com.api.games.interfaces.adapter.controller.exceptions;

import com.api.games.interfaces.adapter.controller.exceptions.enums.ErrorType;
import com.api.games.usecases.exceptions.BaseBusinessException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Void> handleNullPointerException(final NullPointerException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(final Exception ex) {
        return ResponseEntity.status(BAD_REQUEST).body(StandardError.builder()
                .error(Error.builder().code(ErrorType.VS000.getMessage()).message(ex.getMessage()).build())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(BAD_REQUEST.value()).build());
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<StandardError> handleMissingRequestHeaderException(
            final MissingRequestHeaderException ex) {
        return ResponseEntity.status(BAD_REQUEST).body(StandardError.builder()
                .error(Error.builder().code(ErrorType.VS000.name()).message(ex.getMessage()).build())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleMissingRequestHeaderException(
            final MethodArgumentNotValidException ex) {
        List<ErrorField> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            ErrorField errorField = new ErrorField(error.getField(), error.getDefaultMessage());
            errors.add(errorField);
        }
        return ResponseEntity.status(BAD_REQUEST).body(StandardError.builder().error(
                Error.builder().code(ErrorType.VS000.name()).message(ErrorType.VS000.getMessage())
                        .fields(errors).build()).build());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<StandardError> handleBindException(final BindException ex) {

        List<ErrorField> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            ErrorField errorField = new ErrorField(error.getField(), error.getDefaultMessage());
            errors.add(errorField);
        }

        return ResponseEntity.status(BAD_REQUEST).body(StandardError.builder().error(
                Error.builder().code(ErrorType.VS000.name()).message(ErrorType.VS000.getMessage())
                        .fields(errors).build()).build());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> handleHttpMessageNotReadableException(
            final InvalidFormatException ex) {

        return ResponseEntity.status(BAD_REQUEST).body(StandardError.builder()
                .error(Error.builder().code(ErrorType.VS000.name()).message(ex.getMessage()).build())
                .build());
    }

    @ExceptionHandler(BaseBusinessException.class)
    public ResponseEntity<StandardError> handleBaseBusinessException(
            final BaseBusinessException ex) {

        return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(StandardError.builder()
                .error(Error.builder().code(ex.getCode().name()).message(ex.getMessage()).build())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(UNPROCESSABLE_ENTITY.value()).build());
    }
}
