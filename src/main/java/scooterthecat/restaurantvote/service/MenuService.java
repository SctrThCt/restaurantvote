package scooterthecat.restaurantvote.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.model.Menu;
import scooterthecat.restaurantvote.repository.MealRepository;
import scooterthecat.restaurantvote.repository.MenuRepository;

import java.util.List;

import static scooterthecat.restaurantvote.util.ValidationUtil.*;

@Service
public class MenuService {
    private final MealRepository mealRepository;
    private final MenuRepository menuRepository;

    public MenuService(MealRepository mealRepository, MenuRepository menuRepository) {
        this.mealRepository = mealRepository;
        this.menuRepository = menuRepository;
    }

    public Menu get(int id) {
        return checkNotFoundWithId(menuRepository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(menuRepository.delete(id), id);
    }

    public Menu create(Menu menu) {
        Assert.notNull(menu, "menu must not be null");
        checkNew(menu);
        return menuRepository.save(menu);
    }

    public void update(Menu menu) {
        Assert.notNull(menu, "menu must not be null");
        assureIdConsistent(menu, menu.id());
        checkNotFoundWithId(menuRepository.save(menu), menu.id());
    }

    public List<Menu> getAll() {
        return menuRepository.getAll();
    }

    public void addMealToMenu(int id, int mealId) {
        Menu menu = checkNotFoundWithId(menuRepository.get(id), id);
        Meal meal = checkNotFoundWithId(mealRepository.get(mealId), mealId);
        menu.getMeals().add(meal);
        menuRepository.save(menu);
    }
}
