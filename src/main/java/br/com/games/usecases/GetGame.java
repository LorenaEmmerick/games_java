package br.com.games.usecases;

import br.com.games.entity.Game;
import br.com.games.usecases.exceptions.FindGameException;
import br.com.games.usecases.ports.GetGamePort;
import br.com.games.usecases.provider.GameProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetGame implements GetGamePort {

    private GameProvider gameProvider;

    @Autowired
    public GetGame(GameProvider gameProvider) {
        this.gameProvider = gameProvider;
    }

    public Optional<Game> getGameById(final Integer id) {
        try {
            return gameProvider.getGameById(id);
        } catch (RuntimeException ex) {
            throw new FindGameException();
        }
    }

    public List<Game> getGameAll() {
        try {
            return gameProvider.findAllGames();
        } catch (RuntimeException ex) {
            throw new FindGameException();
        }
    }
}
