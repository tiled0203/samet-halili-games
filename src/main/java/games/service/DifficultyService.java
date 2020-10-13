package games.service;

import games.domain.Difficulty;
import games.repositories.DifficultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DifficultyService {
    @Autowired
    DifficultyRepository difficultyRepository;

    public Difficulty findById(int id) {
        return difficultyRepository.findById(id).get();
    }

    public List<Difficulty> findAll() {
        return difficultyRepository.findAll();
    }

    public int add(Difficulty d) {
        return difficultyRepository.save(d).getId();
    }
}
