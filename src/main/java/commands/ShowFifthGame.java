package commands;

import domain.Game;
import service.GamesAppFacade;

public class ShowFifthGame implements Command {
    GamesAppFacade gamesAppFacade = new GamesAppFacade();

    @Override
    public void execute() {
        Game game = gamesAppFacade.findByIdGame(5);
        System.out.println("----------------------------------------");
        System.out.println("Showing the fifth game");
        System.out.println(game.toString());
        System.out.println("----------------------------------------");
    }
}
