package service;

import domain.Game;
import repositories.GameJDBCRepository;

import java.util.List;

public class GameService {
    GameJDBCRepository gameJDBCRepository = GameJDBCRepository.getGetInstance();

    public Game findById(int id) {
        return gameJDBCRepository.findById(id);
    }

    public List<Game> findAll() {
        return gameJDBCRepository.findAll();
    }
}
