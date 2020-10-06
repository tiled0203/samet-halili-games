package restservices;

import domain.Game;
import service.GamesAppFacade;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
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

    @Path("{gameId}")
    @Produces("application/json") @GET
    public Game findGameById(@NotNull @PathParam("gameId") int id) {
        return facade.findByIdGame(id);
    }
}
