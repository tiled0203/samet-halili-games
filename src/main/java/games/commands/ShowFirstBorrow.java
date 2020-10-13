package games.commands;

import games.domain.Borrower;
import games.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowFirstBorrow implements Command {
    @Autowired
    BorrowerService service;

    @Override
    public void execute() {
        Borrower borrower = service.findById(1);
        System.out.println("----------------------------------------");
        System.out.println("Showing the first borrower");
        System.out.println("Name: " + borrower.getBorrowerName() + " - City: " + borrower.getCity());
        System.out.println("----------------------------------------");
    }
}
