package com.api.games.usecases.ports;

import com.api.games.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GetGamePort {
    Optional<Game> getGameById(final Integer id);

    List<Game> getGameAll();
}
