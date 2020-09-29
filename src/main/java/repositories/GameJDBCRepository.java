package repositories;

import domain.Game;

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
            return new Game.Builder()
                    .withId(resultSet.getInt("id"))
                    .withGameName(resultSet.getString("game_name"))
                    .withEditor(resultSet.getString("editor"))
                    .withAuthor(resultSet.getString("author"))
                    .withYearEdition(resultSet.getInt("year_edition"))
                    .withAge(resultSet.getString("age"))
                    .withMinPlayers(resultSet.getInt("min_players"))
                    .withMaxPlayers(resultSet.getInt("max_players"))
                    .withCategoryId(resultSet.getInt("category_id"))
                    .withPlayDuration(resultSet.getString("play_duration"))
                    .withDifficultyId(resultSet.getInt("difficulty_id"))
                    .withPrice(resultSet.getBigDecimal("price"))
                    .withImage(resultSet.getString("image"))
                    .build();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
