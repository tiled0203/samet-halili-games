package service;

import domain.Category;
import repositories.CategoryJPARepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class CategoryService implements Service<Category> {
    @Inject
    CategoryJPARepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(int id) {
        return categoryRepository.findById(id);
    }
}
