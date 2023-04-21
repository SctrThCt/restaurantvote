package scooterthecat.restaurantvote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.repository.meal.MealRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal get(int id) {
        return repository.get(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    @Transactional
    public Meal create(Meal meal) {
        Assert.notNull(meal, "meal must not be null");
        return repository.save(meal);
    }

    @Transactional
    public void update(Meal meal, int id) {
        Assert.notNull(meal, "meal must not be null");
        repository.save(meal);
    }

    public List<Meal> getAll() {
        return repository.getAll();
    }
}
