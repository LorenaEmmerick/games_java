package br.com.interfaces.adapter.controller.converters;

import br.com.entity.Game;
import br.com.interfaces.adapter.controller.dto.GameResponse;


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
