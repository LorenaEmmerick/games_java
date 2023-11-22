package com.api.games.interfaces.adapter.controller.exceptions.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {
    VS000("Erro ao salvar o jogo no banco de dados."),
    VS001("Erro ao buscar o jogo no banco de dados.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    @JsonValue
    public String getMessage() {
        return this.message;
    }
}
