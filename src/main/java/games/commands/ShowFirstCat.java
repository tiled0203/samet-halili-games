package games.commands;

import games.domain.Category;
import games.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowFirstCat implements Command {
    @Autowired
    CategoryService gamesAppFacade;

    @Override
    public void execute() {
        Category category = gamesAppFacade.findById(1);
        System.out.println("----------------------------------------");
        System.out.println("Showing first game category");
        System.out.println(category.getId() + ". Category: " + category.getCategoryName());
        System.out.println("----------------------------------------");
    }
}
