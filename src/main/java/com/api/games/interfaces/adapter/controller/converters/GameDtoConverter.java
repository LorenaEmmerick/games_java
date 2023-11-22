package com.api.games.interfaces.adapter.controller.converters;

import com.api.games.entity.Game;
import com.api.games.interfaces.adapter.controller.dto.GameResponse;


public class GameDtoConverter {

    private GameDtoConverter() {
    }

    public static GameResponse toDto(final Game game) {
        return GameResponse.builder()
                .id(game.getId())
                .img(game.getImg())
                .title(game.getTitle())
                .star(game.getStar())
                .reviews(game.getReviews())
                .prevPrice(game.getPrevPrice())
                .newPrice(game.getNewPrice())
                .company(game.getCompany())
                .consoleType(game.getConsoleType())
                .category(game.getCategory())
                .build();
    }
}
