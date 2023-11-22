package com.api.games.interfaces.adapter.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class GameResponse {
    private Integer id;
    private String img;
    private String title;
    private Integer star;
    private String reviews;
    private Double prevPrice;
    private Double newPrice;
    private String company;
    private String consoleType;
    private String category;
}
