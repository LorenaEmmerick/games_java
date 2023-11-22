package com.api.games;

import com.api.games.ForWeb.dao.GameDAO;
import com.api.games.ForWeb.infra.ConnectionFactory;
import com.api.games.ForWeb.model.GameEntity;

import java.sql.Connection;
import java.sql.SQLException;

public class CriarGame {

    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        GameEntity game = new GameEntity("img da Lore", "titulo jdbc", 5,
                "10", 250.3, 200D,
                "compania Lore", "xbox", "ação");

        GameDAO dao = new GameDAO(connection);
        dao.save(game);

        connection.close();
    }

}
