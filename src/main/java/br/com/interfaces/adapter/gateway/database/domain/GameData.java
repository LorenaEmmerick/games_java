package br.com.interfaces.adapter.gateway.database.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 1000)
    private String img;
    @Column(length = 1000)
    private String title;
    @Column(length = 1000)
    private Integer star;
    @Column(length = 1000)
    private String reviews;
    @Column(length = 1000)
    private Double prevPrice;
    @Column(length = 1000)
    private Double newPrice;
    @Column(length = 1000)
    private String company;
    @Column(length = 1000)
    private String consoleType;
    @Column(length = 1000)
    private String category;
}
