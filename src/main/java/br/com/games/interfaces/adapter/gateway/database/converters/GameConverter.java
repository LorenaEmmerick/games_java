package br.com.games.interfaces.adapter.gateway.database.converters;

import br.com.games.entity.Game;
import br.com.games.interfaces.adapter.gateway.database.domain.GameData;

public class GameConverter {

    private GameConverter() {
    }

    public static GameData toDatabase(final Game game) {
        return GameData.builder()
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

    public static Game toEntity(final GameData gameData) {
        return Game.builder()
                .id(gameData.getId())
                .img(gameData.getImg())
                .title(gameData.getTitle())
                .star(gameData.getStar())
                .reviews(gameData.getReviews())
                .prevPrice(gameData.getPrevPrice())
                .newPrice(gameData.getNewPrice())
                .company(gameData.getCompany())
                .consoleType(gameData.getConsoleType())
                .category(gameData.getCategory())
                .build();
    }
}
