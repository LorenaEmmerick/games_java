package com.api.games.usecases;

import com.api.games.entity.Game;
import com.api.games.usecases.exceptions.SaveGameException;
import com.api.games.usecases.ports.SaveGamePort;
import com.api.games.usecases.provider.GameProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SaveGame implements SaveGamePort {
    private GameProvider gameProvider;

    @Override
    public void saveGameFromJson(final Game game) {
        try {
            gameProvider.save(game);
        } catch (RuntimeException ex) {
            log.error(ex.getMessage());
            throw new SaveGameException();
        }
    }

    @Override
    public void saveGameFromJsonList(final List<Game> games) {
        try {
            for (Game game : games) {
                gameProvider.save(game);
            }
        } catch (RuntimeException ex) {
            log.error(ex.getMessage());
            throw new SaveGameException();
        }
    }
}
