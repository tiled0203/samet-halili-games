package commands;

import domain.Borrower;
import service.GamesAppFacade;

public class ShowFirstBorrow implements Command {
    GamesAppFacade gamesAppFacade = new GamesAppFacade();

    @Override
    public void execute() {
        Borrower borrower = gamesAppFacade.findByIdBorrow(1);
        System.out.println("----------------------------------------");
        System.out.println("Showing the first borrower");
        System.out.println("Name: " + borrower.getBorrowerName() + " - City: " + borrower.getCity());
        System.out.println("----------------------------------------");
    }
}
