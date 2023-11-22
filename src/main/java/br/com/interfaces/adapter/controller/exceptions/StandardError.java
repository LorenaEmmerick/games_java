package br.com.interfaces.adapter.controller.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
public class StandardError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", locale = "pt-br", timezone = "Brazil/East")
    private Timestamp timestamp;
    private Integer status;
    private Error error;

    @JsonIgnore
    private String path;

    @JsonIgnore
    private Boolean printStack;
}
