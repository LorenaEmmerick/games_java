package br.com.games.usecases.ports;

import br.com.games.entity.Game;

import java.util.List;

public interface SaveGamePort {

    void saveGameFromJson(final Game game);

    void saveGameFromJsonList(final List<Game> games);
}
