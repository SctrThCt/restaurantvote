package scooterthecat.restaurantvote.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.model.Restaurant;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl {
   private final CrudRestaurantRepository crudRestaurantRepository;

    public RestaurantRepositoryImpl(CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Transactional
    public Restaurant save(Restaurant restaurant)
    {
        return crudRestaurantRepository.save(restaurant);
    }

    @Transactional
    public void delete(int id)
    {
        crudRestaurantRepository.deleteById(id);
    }

    public Restaurant get(int id)
    {
        return crudRestaurantRepository.findById(id).orElse(null);
    }

    public List<Restaurant> getAll()
    {
        return crudRestaurantRepository.findAll();
    }
}
