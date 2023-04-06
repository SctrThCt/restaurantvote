package scooterthecat.restaurantvote.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Meal;

import java.util.List;

@Repository

public class MealRepository{

    private final CrudMealRepository crudMealRepository;

    public MealRepository(CrudMealRepository crudMealRepository) {
        this.crudMealRepository = crudMealRepository;
    }

    public Meal save(Meal meal)
    {
        return crudMealRepository.save(meal);
    }

    public boolean delete(int id)
    {
        return crudMealRepository.delete(id)!=0;
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
