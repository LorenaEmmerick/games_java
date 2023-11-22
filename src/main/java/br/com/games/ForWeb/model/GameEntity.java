package br.com.games.ForWeb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameEntity {
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

    public GameEntity(String img, String title, Integer star, String reviews,
                      Double prevPrice, Double newPrice, String company,
                      String consoleType, String category) {
        this.img = img;
        this.title = title;
        this.star = star;
        this.reviews = reviews;
        this.prevPrice = prevPrice;
        this.newPrice = newPrice;
        this.company = company;
        this.consoleType = consoleType;
        this.category = category;
    }
}
