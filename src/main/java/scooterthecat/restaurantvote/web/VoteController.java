package scooterthecat.restaurantvote.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

//    public Vote create(Vote vote) {
//        return service.create(vote);
//    }

    public void update(Vote vote) {
        service.update(vote);
    }
    @PostMapping("/api/restaurant/{restaurantId}/vote")
    public Vote voteForRestaurant(@PathVariable int restaurantId)
    {
        return service.create(restaurantId);
    }

    @GetMapping("/api/profile/votes")
    public List<Vote> getAll() {
        return service.getAll();
    }
}
