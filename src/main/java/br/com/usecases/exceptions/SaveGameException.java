package br.com.usecases.exceptions;

import br.com.interfaces.adapter.controller.exceptions.enums.ErrorType;

public class SaveGameException extends BaseBusinessException {

    public SaveGameException() {
        super(ErrorType.VS000, ErrorType.VS000.getMessage());
    }
}
