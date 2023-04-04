package scooterthecat.restaurantvote.web;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RestController;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.repository.MealRepository;

import static scooterthecat.restaurantvote.util.ValidationUtil.*;

@RestController
public class MealController extends RootController{

    private final MealRepository repository;

    public MealController(MealRepository repository) {
        this.repository = repository;
    }

    public Meal get(int id)
    {
        return checkNotFoundWithId(repository.get(id),id);
    }

    public void delete(int id)
    {
        checkNotFoundWithId(repository.delete(id),id);
    }

    public Meal create (Meal meal)
    {
        Assert.notNull(meal,"meal must not be null");
        checkNew(meal);
        return repository.save(meal);
    }

    public void update (Meal meal)
    {
        Assert.notNull(meal,"meal must not be null");
        assureIdConsistent(meal, meal.id());
        checkNotFoundWithId(repository.save(meal), meal.id());
    }

    public void getAll()
    {
        repository.getAll();
    }
}
