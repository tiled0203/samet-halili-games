package games.repositories.oldjpa;

import games.domain.Difficulty;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@LocalBean
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

    @Transactional
    public int add(Difficulty difficulty) {
        em.persist(difficulty);
        return difficulty.getId();
    }
}
