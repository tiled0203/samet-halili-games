package restservices;

import domain.Category;
import service.CategoryService;
import service.GamesAppFacade;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("category")
public class CategoryREST {
    @Inject
    GamesAppFacade facade;

    @GET
    @Produces("application/json")
    public List<Category> getCategories() {
        return facade.findAllCategories();
    }
}
