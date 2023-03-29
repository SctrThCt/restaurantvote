package scooterthecat.restaurantvote.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Meal;

import java.util.List;

@Repository
public class MealRepositoryImpl {

    private final CrudMealRepository crudMealRepository;

    public MealRepositoryImpl(CrudMealRepository crudMealRepository) {
        this.crudMealRepository = crudMealRepository;
    }
    @Transactional
    public Meal save(Meal meal)
    {
        return crudMealRepository.save(meal);
    }

    @Transactional
    public void delete(int id)
    {
        crudMealRepository.deleteById(id);
    }

    public Meal get(int id)
    {
        return crudMealRepository.findById(id).orElse(null);
    }

    public List<Meal> getAll()
    {
        return crudMealRepository.findAll();
    }
}
