package service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface Service<T> {
    T findById(int id);
    List<T> findAll();
}
