package scooterthecat.restaurantvote.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.repository.MealRepository;

import java.util.List;

import static scooterthecat.restaurantvote.repository.RepositoryUtil.checkNotFound;

@Service
@AllArgsConstructor
public class MealService {

    private final MealRepository mealRepository;

    public Meal get(int id) {
        return checkNotFound(mealRepository, id, Meal.class);
    }
    public void delete(int id) {
        mealRepository.deleteExisted(id);
    }

    @Transactional
    public Meal create(Meal meal) {
        Assert.notNull(meal, "meal must not be null");
        return mealRepository.save(meal);
    }

    @Transactional
    public void update(Meal meal, int id) {
        Assert.notNull(meal, "meal must not be null");
        mealRepository.save(meal);
    }

    public List<Meal> getAll() {
        return mealRepository.findAll();
    }
}
