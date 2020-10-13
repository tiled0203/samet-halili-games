package games.restservices;

import games.domain.Category;
import games.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryREST {
    @Autowired
    CategoryService service;

    @GetMapping
    public List<Category> getCategories() {
        return service.findAll();
    }
}
