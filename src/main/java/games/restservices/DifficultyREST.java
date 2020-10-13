package games.restservices;

import games.domain.Difficulty;
import games.dto.DifficultyDto;
import games.service.DifficultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/difficulties")
public class DifficultyREST {
    @Autowired
    DifficultyService service;

    @GetMapping
    public List<Difficulty> getDifficulties() {
        return service.findAll();
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public int createDifficulty(DifficultyDto d) {
        ModelMapper modelMapper = new ModelMapper();
        Difficulty difficulty = modelMapper.map(d, Difficulty.class);
        return service.add(difficulty);
    }
}
