package br.com.usecases.ports;

import br.com.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GetGamePort {
    Optional<Game> getGameById(final Integer id);

    List<Game> getGameAll();
}
