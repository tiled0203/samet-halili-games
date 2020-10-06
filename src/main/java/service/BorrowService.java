package service;

import domain.Borrow;
import repositories.JPARepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class BorrowService implements Service<Borrow> {
    @Inject
    JPARepository<Borrow> borrowRepository;

    @Override
    public Borrow findById(int id) {
        return borrowRepository.findById(id);
    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }
}
