package br.com.usecases.ports;

import br.com.entity.Game;

import java.util.List;

public interface SaveGamePort {

    void saveGameFromJson(final Game game);

    void saveGameFromJsonList(final List<Game> games);
}
