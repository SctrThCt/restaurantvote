package scooterthecat.restaurantvote.repository.restaurant;

import org.springframework.stereotype.Repository;
import scooterthecat.restaurantvote.model.Restaurant;

import java.util.List;

@Repository
public class RestaurantRepository {
   private final CrudRestaurantRepository crudRestaurantRepository;

    public RestaurantRepository(CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    public Restaurant save(Restaurant restaurant)
    {
        return crudRestaurantRepository.save(restaurant);
    }

    public boolean delete(int id)
    {
        return crudRestaurantRepository.delete(id)!=0;
    }

    public Restaurant get(int id)
    {
        return crudRestaurantRepository.findById(id).orElse(null);
    }

    public List<Restaurant> getAll()
    {
        return crudRestaurantRepository.findAll();
    }

    public List<Restaurant> getAllWithMenus()
    {
        return crudRestaurantRepository.getAllWithMenus();
    }
}
