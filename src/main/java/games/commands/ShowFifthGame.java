package games.commands;

import games.domain.Game;
import games.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowFifthGame implements Command {
    @Autowired
    GameService service;

    @Override
    public void execute() {
        Game game = service.findById(5);
        System.out.println("----------------------------------------");
        System.out.println("Showing the fifth game");
        System.out.println(game.toString());
        System.out.println("----------------------------------------");
    }
}
