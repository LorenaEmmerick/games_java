package br.com.games.usecases.ports;

import br.com.games.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GetGamePort {
    Optional<Game> getGameById(final Integer id);

    List<Game> getGameAll();
}
