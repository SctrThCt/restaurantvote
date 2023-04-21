package scooterthecat.restaurantvote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Menu;
import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.repository.menu.MenuRepository;
import scooterthecat.restaurantvote.repository.restaurant.RestaurantRepository;
import scooterthecat.restaurantvote.to.RestaurantTo;
import scooterthecat.restaurantvote.util.RestaurantUtil;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }


    public Restaurant get(int id) {
        return restaurantRepository.get(id);
    }

    @Transactional
    public void delete(int id) {
        restaurantRepository.delete(id);
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
        return restaurantRepository.getAll();
    }

    @Transactional
    public void addMenuToRestaurant(int id, int menuId) {
        Restaurant restaurant = restaurantRepository.get(id);
        Menu menu = menuRepository.get(menuId);
        restaurant.getMenu().add(menu);
    }

    @Transactional
    public void removeMenuFromRestaurant(int id, int menuId) {
        Restaurant restaurant = restaurantRepository.get(id);
        Menu menu = menuRepository.get(menuId);
        restaurant.getMenu().remove(menu);
    }

    public List<RestaurantTo> getAllRestaurantsForVote() {
        return RestaurantUtil.getTos(restaurantRepository.getAllWithMenus());
    }
}
