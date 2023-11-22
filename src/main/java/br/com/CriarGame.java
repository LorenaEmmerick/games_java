package br.com;

import br.com.ForWeb.model.GameEntity;
import br.com.ForWeb.dao.GameDAO;
import br.com.ForWeb.infra.ConnectionFactory;

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
