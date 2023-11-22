package br.com.games.usecases.provider;

import br.com.games.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GameProvider {
    void save(final Game game);

    Optional<Game> getGameById(final Integer id);

    List<Game> findAllGames();
}
