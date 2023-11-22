package br.com.ForWeb.dao;

import br.com.ForWeb.model.GameEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameDAO {

    private final Connection connection;

    public GameDAO(Connection connection) {
        this.connection = connection;
    }

    public GameEntity save(GameEntity game) {
        try {

            // Obtenha o próximo ID
            String getIdSql = "SELECT (MAX(id)+1) as nextId FROM games.game_data;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getIdSql);
            resultSet.next();
            int nextId = resultSet.getInt("nextId");

            // Insira os dados com o ID obtido
            String insertSql = "INSERT INTO game_data (id, category, company, console_type," +
                    " img, new_price, prev_price, reviews, star, title) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, nextId);
            preparedStatement.setString(2, game.getCategory());
            preparedStatement.setString(3, game.getCompany());
            preparedStatement.setString(4, game.getConsoleType());
            preparedStatement.setString(5, game.getImg());
            preparedStatement.setDouble(6, game.getNewPrice());
            preparedStatement.setDouble(7, game.getPrevPrice());
            preparedStatement.setString(8, game.getReviews());
            preparedStatement.setInt(9, game.getStar());
            preparedStatement.setString(10, game.getTitle());

            preparedStatement.executeUpdate();

            // Configure o ID gerado no objeto GameEntity
            game.setId(nextId);

            preparedStatement.close();
            resultSet.close();
            statement.close();
            return game;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
