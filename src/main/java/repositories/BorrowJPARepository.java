package repositories;

import domain.Borrow;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class BorrowJPARepository implements JPARepository<Borrow> {
    @PersistenceContext(unitName = "gamePersistenceUnit")
    EntityManager em;

    @Override
    public Borrow findById(int id) {
        return em.find(Borrow.class, id);
    }

    @Override
    public List<Borrow> findAll() {
        return em.createQuery("SELECT bo FROM Borrow bo", Borrow.class).getResultList();
    }


}
