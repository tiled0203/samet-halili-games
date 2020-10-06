package service;

import domain.Difficulty;
import repositories.JPARepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class DifficultyService implements Service<Difficulty> {
    @Inject
    JPARepository<Difficulty> difficultyRepository;

    public Difficulty findById(int id) {
        return difficultyRepository.findById(id);
    }

    public List<Difficulty> findAll() {
        return difficultyRepository.findAll();
    }
}
