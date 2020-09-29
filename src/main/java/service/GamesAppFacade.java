package service;

import domain.Borrower;
import domain.Category;
import domain.Game;

import java.util.List;

public class GamesAppFacade {
    CategoryService categoryService = new CategoryService();
    GameService gameService = new GameService();
    BorrowerService borrowerService = new BorrowerService();

    public Category findByIdCat(int id) {
        return categoryService.findById(id);
    }

    public Game findByIdGame(int id) {
        return gameService.findById(id);
    }

    public List<Category> findAllCat() {
        return categoryService.findAll();
    }

    public List<Game> findAllGame() {
        return gameService.findAll();
    }

    public List<Borrower> findAllBorrowers() {
        return borrowerService.findAll();
    }

    public Borrower findByIdBorrow(int id) {
        return borrowerService.findById(id);
    }
}
