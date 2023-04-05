package scooterthecat.restaurantvote.web;

import org.springframework.web.bind.annotation.RestController;
import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.service.RestaurantService;

import java.util.List;

@RestController
public class RestaurantController extends RootController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }


    public Restaurant get(int id) {
        return service.get(id);
    }

    public void delete(int id) {
        service.delete(id);
    }

    public Restaurant create(Restaurant restaurant) {
        return service.create(restaurant);
    }

    public void update(Restaurant restaurant) {
        service.update(restaurant);
    }

    public List<Restaurant> getAll() {
        return service.getAll();
    }
}
