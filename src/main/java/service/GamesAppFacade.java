package service;

import domain.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class GamesAppFacade {
    @Inject
    GameService gameService;
    @Inject
    CategoryService categoryService;
    @Inject
    DifficultyService difficultyService;
    @Inject
    BorrowerService borrowerService;
    @Inject
    BorrowService borrowService;

    public Category findByIdCategory(int id) {
        return categoryService.findById(id);
    }

    public Game findByIdGame(int id) {
        return gameService.findById(id);
    }

    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    public List<Game> findAllGame() {
        return gameService.findAll();
    }

    public List<Borrower> findAllBorrowers() {
        return borrowerService.findAll();
    }

    public Borrower findByIdBorrower(int id) {
        return borrowerService.findById(id);
    }

    public List<Difficulty> findAllDifficulties() {
        return difficultyService.findAll();
    }

    public Difficulty findByIdDifficulty(int id) {
        return difficultyService.findById(id);
    }

    public List<Borrow> findAllBorrows() {
        return borrowService.findAll();
    }

    public Borrow findByIdBorrow(int id) {
        return borrowService.findById(id);
    }

    public int addDifficulty(Difficulty d) {
        return difficultyService.add(d);
    }
}
