package commands;

import domain.Category;
import service.CategoryService;

public class ShowFirstCat implements Command {
    CategoryService categoryService = new CategoryService();

    @Override
    public void execute() {
        Category category = categoryService.findById(1);
        System.out.println("----------------------------------------");
        System.out.println("Showing first game category");
        System.out.println(category.getId() + ". Category: " + category.getCategoryName());
        System.out.println("----------------------------------------");
    }
}
