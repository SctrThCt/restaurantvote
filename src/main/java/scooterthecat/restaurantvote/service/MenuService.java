package scooterthecat.restaurantvote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.model.Menu;
import scooterthecat.restaurantvote.repository.meal.MealRepository;
import scooterthecat.restaurantvote.repository.menu.MenuRepository;

import java.util.List;

@Service
public class MenuService {
    private final MealRepository mealRepository;
    private final MenuRepository menuRepository;

    public MenuService(MealRepository mealRepository, MenuRepository menuRepository) {
        this.mealRepository = mealRepository;
        this.menuRepository = menuRepository;
    }

    public Menu get(int id) {
        return menuRepository.get(id);
    }

    public void delete(int id) {
        menuRepository.delete(id);
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
        return menuRepository.getAll();
    }

    @Transactional
    public void addMealToMenu(int id, int mealId) {
        Menu menu = menuRepository.get(id);
        Meal meal = mealRepository.get(mealId);
        menu.getMeals().add(meal);
        //menuRepository.save(menu);
    }

    @Transactional
    public void removeMealFromMenu(int id, int mealId) {
        Menu menu = menuRepository.get(id);
        Meal meal = mealRepository.get(mealId);
        menu.getMeals().remove(meal);
        //menuRepository.save(menu);
    }
}
