package com.api.games.usecases;

import com.api.games.entity.Game;
import com.api.games.usecases.exceptions.FindGameException;
import com.api.games.usecases.ports.GetGamePort;
import com.api.games.usecases.provider.GameProvider;
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
