package restservices;

import domain.Borrower;
import service.GamesAppFacade;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("borrower")
public class BorrowerREST {
    @Inject
    GamesAppFacade facade;

    @GET
    @Produces("application/json")
    public List<Borrower> getAllBorrowers() {
        return facade.findAllBorrowers();
    }
}
