package br.com.games.usecases.exceptions;

import br.com.games.interfaces.adapter.controller.exceptions.enums.ErrorType;

public class SaveGameException extends BaseBusinessException {

    public SaveGameException() {
        super(ErrorType.VS000, ErrorType.VS000.getMessage());
    }
}
