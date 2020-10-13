package games.restservices;

import games.domain.Borrow;
import games.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrows")
public class BorrowREST {
    @Autowired
    BorrowService service;

    @GetMapping
    public List<Borrow> getAllBorrowers() {
        return service.findAll();
    }
}
