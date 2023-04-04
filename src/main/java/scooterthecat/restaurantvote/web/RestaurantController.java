package scooterthecat.restaurantvote.web;

import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.repository.RestaurantRepository;

import static scooterthecat.restaurantvote.util.ValidationUtil.*;
import static scooterthecat.restaurantvote.util.ValidationUtil.checkNotFoundWithId;

public class RestaurantController extends RootController{

    private final RestaurantRepository repository;

    public RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant get(int id)
    {
        return checkNotFoundWithId(repository.get(id),id);
    }

    public void delete(int id)
    {
        checkNotFoundWithId(repository.delete(id),id);
    }

    public Restaurant create (Restaurant restaurant)
    {
        Assert.notNull(restaurant,"restaurant must not be null");
        checkNew(restaurant);
        return repository.save(restaurant);
    }

    public void update (Restaurant menu)
    {
        Assert.notNull(menu,"restaurant must not be null");
        assureIdConsistent(menu, menu.id());
        checkNotFoundWithId(repository.save(menu), menu.id());
    }

    public void getAll()
    {
        repository.getAll();
    }
}
