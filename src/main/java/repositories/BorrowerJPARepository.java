package repositories;

import domain.Borrower;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BorrowerJPARepository implements JPARepository<Borrower> {
    @PersistenceContext(unitName = "gamePersistenceUnit")
    EntityManager em;

    @Override
    public Borrower findById(int id) {
        return em.find(Borrower.class, id);
    }

    @Override
    public List<Borrower> findAll() {
        return em.createQuery("SELECT b FROM Borrower b", Borrower.class).getResultList();
    }
}
