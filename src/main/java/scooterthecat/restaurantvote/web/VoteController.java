package scooterthecat.restaurantvote.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.service.VoteService;

import java.util.List;

@RestController
public class VoteController extends RootController {

    private final VoteService service;

    public VoteController(VoteService service) {
        this.service = service;
    }

    @GetMapping("api/profile/votes/{id}")
    public Vote get(@PathVariable int id) {
        return service.get(id);
    }

    @DeleteMapping("api/profile/votes/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PatchMapping(value = "api/profile/votes/{voteId}")
    public void update(@PathVariable int voteId, @RequestParam int restaurantId) {
        service.update(voteId, restaurantId);
    }

    @PostMapping("/api/restaurant/{restaurantId}/vote")
    public Vote voteForRestaurant(@PathVariable int restaurantId) {
        return service.create(restaurantId);
    }

    @GetMapping("/api/profile/votes")
    public List<Vote> getAll() {
        return service.getAll();
    }
}
