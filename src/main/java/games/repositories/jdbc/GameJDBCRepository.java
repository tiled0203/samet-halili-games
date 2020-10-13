package games.repositories.jdbc;

import games.domain.Game;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameJDBCRepository {
    private final static GameJDBCRepository getInstance = new GameJDBCRepository();

    public static GameJDBCRepository getGetInstance() {
        return getInstance;
    }

    public List<Game> findAll() {
        ArrayList<Game> games = new ArrayList<>();
        try(PreparedStatement preparedStatement = DbLogin.createConnection()
                .prepareStatement("SELECT g.id, g.game_name, g.editor, g.author," +
                        "g.year_edition, g.age, g.min_players, g.max_players, g.category_id," +
                        "g.play_duration, g.difficulty_id, g.price, g.image" +
                        "from game as g")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                games.add(buildFromSet(resultSet));
            }
            return games;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Game findById(int id) {
        try(PreparedStatement preparedStatement = DbLogin.createConnection()
                .prepareStatement("SELECT g.id, g.game_name, g.editor, g.author, g.year_edition, g.age, g.min_players, g.max_players, g.category_id, g.play_duration, g.difficulty_id, g.price, g.image from game as g WHERE g.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return buildFromSet(resultSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Game buildFromSet(ResultSet resultSet) {
        try {
            return Game.builder()
                    .id(resultSet.getInt("id"))
                    .gameName(resultSet.getString("game_name"))
                    .editor(resultSet.getString("editor"))
                    .author(resultSet.getString("author"))
                    .yearEdition(resultSet.getInt("year_edition"))
                    .age(resultSet.getString("age"))
                    .minPlayers(resultSet.getInt("min_players"))
                    .maxPlayers(resultSet.getInt("max_players"))
                    .categoryId(resultSet.getInt("category_id"))
                    .playDuration(resultSet.getString("play_duration"))
                    .difficultyId(resultSet.getInt("difficulty_id"))
                    .price(resultSet.getBigDecimal("price"))
                    .image(resultSet.getString("image"))
                    .build();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
