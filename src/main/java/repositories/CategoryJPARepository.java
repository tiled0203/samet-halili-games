package repositories;

import domain.Category;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class CategoryJPARepository implements JPARepository<Category> {
    @PersistenceContext(unitName = "gamePersistenceUnit")
    EntityManager em;

    @Override
    public Category findById(int id) {
        return em.find(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

    @Override
    public int add(Category category) {
        return 0;
    }
}
