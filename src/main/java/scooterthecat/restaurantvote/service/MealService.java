package scooterthecat.restaurantvote.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.repository.MealRepository;

import java.util.List;

import static scooterthecat.restaurantvote.util.ValidationUtil.*;
import static scooterthecat.restaurantvote.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
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

    public List<Meal> getAll()
    {
        return repository.getAll();
    }
}
