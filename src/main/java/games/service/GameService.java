package games.service;

import games.domain.Game;
import games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    public Game findById(int id) {
        return gameRepository.findById(id).get();
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
