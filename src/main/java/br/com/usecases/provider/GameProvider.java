package br.com.usecases.provider;

import br.com.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GameProvider {
    void save(final Game game);

    Optional<Game> getGameById(final Integer id);

    List<Game> findAllGames();
}
