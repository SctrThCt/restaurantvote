package scooterthecat.restaurantvote.web;

import org.springframework.web.bind.annotation.RestController;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.service.VoteService;

import java.util.List;

@RestController
public class VoteController extends RootController {

    private final VoteService service;

    public VoteController(VoteService service) {
        this.service = service;
    }

    public Vote get(int id) {
        return service.get(id);
    }

    public void delete(int id, int userId) {
        service.delete(id, userId);
    }

    public Vote create(Vote vote) {
        return service.create(vote);
    }

    public void update(Vote vote) {
        service.update(vote);
    }

    public List<Vote> getAll() {
        return service.getAll();
    }
}
