package scooterthecat.restaurantvote.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.repository.RestaurantRepository;

import java.util.List;

import static scooterthecat.restaurantvote.util.ValidationUtil.*;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }


    public Restaurant get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNew(restaurant);
        return repository.save(restaurant);
    }

    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        assureIdConsistent(restaurant, restaurant.id());
        checkNotFoundWithId(repository.save(restaurant), restaurant.id());
    }

    public List<Restaurant> getAll() {
        return repository.getAll();
    }
}
