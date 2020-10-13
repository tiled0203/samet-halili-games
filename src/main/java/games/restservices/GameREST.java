package games.restservices;

import games.domain.Game;
import games.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameREST {
    @Autowired
    GameService service;

    @GetMapping
    public List<Game> findGames() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Game findGameById(@PathVariable int id) {
        return service.findById(id);
    }
}
