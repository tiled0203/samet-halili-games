package restservices;

import domain.Borrow;
import service.GamesAppFacade;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("borrow")
public class BorrowREST {
    @Inject
    GamesAppFacade facade;

    @GET
    @Produces("application/json")
    public List<Borrow> getAllBorrowers() {
        return facade.findAllBorrows();
    }
}
