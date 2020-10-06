package repositories;

import domain.Difficulty;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DifficultyJPARepository implements JPARepository<Difficulty> {
    @PersistenceContext(unitName = "gamePersistenceUnit")
    EntityManager em;

    @Override
    public Difficulty findById(int id) {
        return em.find(Difficulty.class, id);
    }

    @Override
    public List<Difficulty> findAll() {
        return em.createQuery("SELECT d FROM Difficulty d", Difficulty.class).getResultList();
    }
}
