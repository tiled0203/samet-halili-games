package restservices;

import domain.Difficulty;
import dto.DifficultyDto;
import service.GamesAppFacade;

import javax.inject.Inject;
import javax.ws.rs.*;
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

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public int createDifficulty(DifficultyDto d) {
        Difficulty difficulty = new Difficulty.Builder().withDifficultyName(d.getDifficultyName()).build();
        return facade.addDifficulty(difficulty);
    }
}
