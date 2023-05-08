package scooterthecat.restaurantvote.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.model.Menu;
import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.repository.MealRepository;
import scooterthecat.restaurantvote.repository.MenuRepository;
import scooterthecat.restaurantvote.repository.RestaurantRepository;

import java.util.List;

import static scooterthecat.restaurantvote.repository.RepositoryUtil.checkNotFound;

@Service
@AllArgsConstructor
public class MenuService {
    private final MealRepository mealRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public Menu get(int id) {
        return checkNotFound(menuRepository,id,Menu.class);
    }

    public void delete(int id) {
        menuRepository.deleteExisted(id);
    }

    public Menu create(Menu menu) {
        Assert.notNull(menu, "menu must not be null");
        return menuRepository.save(menu);
    }

    public void update(Menu menu) {
        Assert.notNull(menu, "menu must not be null");
        menuRepository.save(menu);
    }

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @Transactional
    public void addMealToMenu(int id, int mealId) {
        Menu menu = checkNotFound(menuRepository,id,Menu.class);
        Meal meal = checkNotFound(mealRepository, id, Meal.class);
        if (menu.getMeals().contains(meal)) {
            throw new DataIntegrityViolationException("Meal " + mealId + " is already assigned to menu " + id);
        }
        menu.getMeals().add(meal);
        menuRepository.save(menu);
    }

    @Transactional
    public void removeMealFromMenu(int id, int mealId) {
        Menu menu = checkNotFound(menuRepository,id,Menu.class);
        Meal meal = checkNotFound(mealRepository, id, Meal.class);
        if (menu.getMeals().remove(meal)) {
            menuRepository.save(menu);
        } else {
            throw new DataIntegrityViolationException("Meal " + mealId + " was never assigned to menu " + id);
        }
    }

    @Transactional
    public void addMenuToRestaurant(int id, int restaurantId) {
        Menu menu = checkNotFound(menuRepository,id,Menu.class);
        Restaurant restaurant = checkNotFound(restaurantRepository,restaurantId,Restaurant.class);
        menu.setRestaurantId(Long.valueOf(restaurantId));
        menu.setRestaurant(restaurant);
    }

    @Transactional
    public void removeMenuFromRestaurant(int id, int menuId) {
        Restaurant restaurant = checkNotFound(restaurantRepository,id,Restaurant.class);
        Menu menu = checkNotFound(menuRepository,id,Menu.class);
        restaurant.getMenu().remove(menu);
    }
}
