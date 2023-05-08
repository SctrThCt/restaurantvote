package scooterthecat.restaurantvote.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.repository.RestaurantRepository;
import scooterthecat.restaurantvote.to.RestaurantTo;
import scooterthecat.restaurantvote.util.RestaurantUtil;

import java.util.List;

import static scooterthecat.restaurantvote.repository.RepositoryUtil.checkNotFound;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant get(int id) {
        return checkNotFound(restaurantRepository, id, Restaurant.class);
    }

    @Transactional
    public void delete(int id) {
        restaurantRepository.deleteExisted(id);
    }

    @Transactional
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public List<RestaurantTo> getAllRestaurantsForVote() {
        return RestaurantUtil.getTos(restaurantRepository.getAllWithMenus());
    }
}
