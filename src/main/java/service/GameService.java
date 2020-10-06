package service;

import domain.Game;
import repositories.GameJPARepository;
import repositories.JPARepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class GameService implements Service<Game> {
    @Inject
    GameJPARepository gameRepository;

    public Game findById(int id) {
        return gameRepository.findById(id);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
