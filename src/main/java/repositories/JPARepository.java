package repositories;

import javax.ejb.Local;
import java.util.List;

@Local
public interface JPARepository<T> {
    T findById(int id);
    List<T> findAll();
}
