package com.api.games.usecases.ports;

import com.api.games.entity.Game;

import java.util.List;

public interface SaveGamePort {

    void saveGameFromJson(final Game game);

    void saveGameFromJsonList(final List<Game> games);
}
