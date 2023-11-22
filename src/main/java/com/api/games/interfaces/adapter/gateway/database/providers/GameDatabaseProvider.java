package com.api.games.interfaces.adapter.gateway.database.providers;

import com.api.games.entity.Game;
import com.api.games.interfaces.adapter.gateway.database.converters.GameConverter;
import com.api.games.interfaces.adapter.gateway.database.repositories.GameRepository;
import com.api.games.usecases.provider.GameProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Service
public class GameDatabaseProvider implements GameProvider {
    @Autowired
    private GameRepository gameRepository;

    public void save(final Game game) {
        gameRepository.save(GameConverter.toDatabase(game));
    }

    public Optional<Game> getGameById(final Integer id) {
        return gameRepository.findById(id).map(GameConverter::toEntity);
    }

    public List<Game> findAllGames() {
        return gameRepository.findAll().stream().map(GameConverter::toEntity).toList();
    }
}