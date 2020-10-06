package restservices;

import domain.Game;
import service.GameService;
import service.GamesAppFacade;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/game")
public class GameREST {
    @Inject
    GamesAppFacade facade;

    @GET
    @Produces("application/json")
    public List<Game> findGames() {
        return facade.findAllGame();
    }
}
