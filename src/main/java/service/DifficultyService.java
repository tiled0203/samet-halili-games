package service;

import domain.Difficulty;
import repositories.DifficultyJPARepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class DifficultyService implements Service<Difficulty> {
    @Inject
    DifficultyJPARepository difficultyRepository;

    public Difficulty findById(int id) {
        return difficultyRepository.findById(id);
    }

    public List<Difficulty> findAll() {
        return difficultyRepository.findAll();
    }

    public int add(Difficulty d) {
        return difficultyRepository.add(d);
    }
}
