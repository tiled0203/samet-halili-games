package restservices;

import domain.Difficulty;
import service.GamesAppFacade;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("difficulty")
public class DifficultyREST {
    @Inject
    GamesAppFacade facade;

    @GET
    @Produces("application/json")
    public List<Difficulty> getDifficulties() {
        return facade.findAllDifficulties();
    }
}
