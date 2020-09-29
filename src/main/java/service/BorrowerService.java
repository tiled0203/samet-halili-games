package service;

import domain.Borrower;
import repositories.BorrowerJDBCRepository;

import java.util.List;

public class BorrowerService {
    BorrowerJDBCRepository borrowerJDBCRepository = BorrowerJDBCRepository.getInstance();

    public List<Borrower> findAll() {
        return borrowerJDBCRepository.findAll();
    }
    public Borrower findById(int id) {
        return borrowerJDBCRepository.findById(id);
    }
}
