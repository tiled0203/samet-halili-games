package service;

import domain.Borrower;
import repositories.JPARepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class BorrowerService implements Service<Borrower> {
    @Inject
    JPARepository<Borrower> borrowerRepository;

    @Override
    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }
    @Override
    public Borrower findById(int id) {
        return borrowerRepository.findById(id);
    }
}
