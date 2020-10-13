package repositories;

import domain.Game;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class GameJPARepository implements JPARepository<Game> {
    @PersistenceContext(unitName = "gamePersistenceUnit")
    EntityManager em;

    @Override
    public Game findById(int id) {
        return em.find(Game.class, id);
    }

    @Override
    public List<Game> findAll() {
        return em.createQuery("select g from Game g", Game.class).getResultList();
    }


}
