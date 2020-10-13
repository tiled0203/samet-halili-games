package games.restservices;

import games.domain.Borrower;
import games.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrowers")
public class BorrowerREST {
    @Autowired
    BorrowerService service;

    @GetMapping
    public List<Borrower> getAllBorrowers() {
        return service.findAll();
    }
}
