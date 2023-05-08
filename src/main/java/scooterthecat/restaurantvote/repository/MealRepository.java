package scooterthecat.restaurantvote.repository;

import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.repository.BaseRepository;

@Transactional(readOnly = true)
public interface MealRepository extends BaseRepository<Meal> {
}
