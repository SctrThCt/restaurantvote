package scooterthecat.restaurantvote.web;

import org.springframework.web.bind.annotation.*;
import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.service.RestaurantService;
import scooterthecat.restaurantvote.to.RestaurantTo;

import java.util.List;

import static scooterthecat.restaurantvote.util.validation.ValidationUtil.assureIdConsistent;
import static scooterthecat.restaurantvote.util.validation.ValidationUtil.checkNew;

@RestController
public class RestaurantController extends RootController {

    private final String ADMIN_URL = "/api/admin/restaurants";
    private final String REST_URL = "/api/restaurants";

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }
    @GetMapping(ADMIN_URL+"/{id}")
    public Restaurant get(@PathVariable int id) {
        return service.get(id);
    }
    @DeleteMapping(ADMIN_URL+"/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PostMapping(ADMIN_URL)
    public Restaurant create(Restaurant restaurant) {
        checkNew(restaurant);
        return service.create(restaurant);
    }

    @PatchMapping(ADMIN_URL+"/{id}")
    public void update(@RequestParam Restaurant restaurant, @PathVariable int id) {
        assureIdConsistent(restaurant, id);
        service.update(restaurant);
    }
    @GetMapping(ADMIN_URL)
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @PostMapping(ADMIN_URL+"/{id}/menu")
    public void addMenuToRestaurant(@PathVariable int id, @RequestParam int menuId)
    {
        service.addMenuToRestaurant(id,menuId);
    }

    @GetMapping(REST_URL)
    public List<RestaurantTo> getRestaurantsForVote()
    {
        return service.getAllRestaurantsForVote();
    }
}
