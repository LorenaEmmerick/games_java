package br.com.games.interfaces.adapter.gateway.database.repositories;

import br.com.games.interfaces.adapter.gateway.database.domain.GameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameData, Integer> {
}
