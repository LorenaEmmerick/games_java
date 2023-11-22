package br.com.usecases.exceptions;

import br.com.interfaces.adapter.controller.exceptions.enums.ErrorType;

public class FindGameException extends BaseBusinessException {

    public FindGameException() {
        super(ErrorType.VS001, ErrorType.VS001.getMessage());
    }
}
