package br.com.games.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Game {
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
