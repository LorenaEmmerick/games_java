package com.api.games.usecases.provider;

import com.api.games.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GameProvider {
    void save(final Game game);

    Optional<Game> getGameById(final Integer id);

    List<Game> findAllGames();
}
