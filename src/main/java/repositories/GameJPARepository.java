package repositories;

import domain.Game;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class GameJPARepository {
    @Inject
    EntityManager em;

    public Game findById(int id) {
        return em.find(Game.class, id);
    }

    public List<Game> findAll() {
        return em.createQuery("select g from Game g", Game.class).getResultList();
    }
}
