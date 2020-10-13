package games.service;

import games.domain.Borrow;
import games.repositories.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {
    @Autowired
    BorrowRepository borrowRepository;

    public Borrow findById(int id) {
        return borrowRepository.findById(id).get();
    }

    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }
}
