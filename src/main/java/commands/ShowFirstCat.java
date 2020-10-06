package commands;

import domain.Category;
import service.CategoryService;
import service.GamesAppFacade;

public class ShowFirstCat implements Command {
    GamesAppFacade gamesAppFacade = new GamesAppFacade();
    @Override
    public void execute() {
        Category category = gamesAppFacade.findByIdCategory(1);
        System.out.println("----------------------------------------");
        System.out.println("Showing first game category");
        System.out.println(category.getId() + ". Category: " + category.getCategoryName());
        System.out.println("----------------------------------------");
    }
}
