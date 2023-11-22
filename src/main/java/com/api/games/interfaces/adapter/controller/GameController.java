package com.api.games.interfaces.adapter.controller;

import com.api.games.entity.Game;
import com.api.games.interfaces.adapter.controller.converters.GameDtoConverter;
import com.api.games.interfaces.adapter.controller.dto.GameResponse;
import com.api.games.usecases.SaveGame;
import com.api.games.usecases.ports.GetGamePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/games")
public class GameController {
    private SaveGame saveGame;
    private GetGamePort getGamePort;

    @Autowired
    public GameController(GetGamePort getGamePort, SaveGame saveGame) {
        this.getGamePort = getGamePort;
        this.saveGame = saveGame;
    }

    @PostMapping("/saveList")
    public ResponseEntity<String> saveGames(@RequestBody List<Game> gameList) {
        saveGame.saveGameFromJsonList(gameList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/saveOne")
    public ResponseEntity<String> saveGame(@RequestBody Game game) {
        saveGame.saveGameFromJson(game);
        return ResponseEntity.ok("Jogo salvo com sucesso.");
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<GameResponse> getGameById(@PathVariable(name = "id") final Integer id) {
        if (getGamePort.getGameById(id).isPresent()) {
            return ResponseEntity.ok(GameDtoConverter.toDto(getGamePort.getGameById(id).get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<List<GameResponse>> getAllGames() {
        return ResponseEntity.ok(getGamePort.getGameAll().stream()
                .map(GameDtoConverter::toDto)
                .collect(Collectors.toList()));
    }

}