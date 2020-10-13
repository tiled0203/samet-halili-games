package games.service;

import games.domain.Borrower;
import games.repositories.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService {
    @Autowired
    BorrowerRepository borrowerRepository;

    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }

    public Borrower findById(int id) {
        return borrowerRepository.findById(id).get();
    }
}
