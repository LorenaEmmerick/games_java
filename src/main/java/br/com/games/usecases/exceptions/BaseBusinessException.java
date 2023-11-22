package br.com.games.usecases.exceptions;

import br.com.games.interfaces.adapter.controller.exceptions.enums.ErrorType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public abstract class BaseBusinessException extends RuntimeException {

    private final HttpStatus status;
    private final boolean printStack;
    private final List<Error> errors;
    private final ErrorType code;
    private final String message;

    protected BaseBusinessException(
            ErrorType code, String message) {
        this.code = code;
        this.message = message;
        this.status = null;
        this.printStack = false;
        this.errors = new ArrayList<>();
        log.error("Code: {}; Message: {}", code, message);
    }
}
