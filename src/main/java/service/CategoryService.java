package service;

import domain.Category;
import repositories.CategoryJDBCRepository;

import java.util.List;

public class CategoryService {
    CategoryJDBCRepository categoryRepository = CategoryJDBCRepository.getInstance();

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(int id) {
        return categoryRepository.findById(id);
    }
}
