package repositories;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Local;
import java.util.List;

@Local
//TRAINER: nice using a generic JPARepository
public interface JPARepository<T> {
    T findById(int id);
    List<T> findAll();
    //TRAINER: Since java 8 you can create default methods in interfaces with a default implementation.
    //So you don't need to override it every time in you repositories if you don't need it.
    default int add(T t){
        throw new NotImplementedException();
    }
}
