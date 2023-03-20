package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scooterthecat.restaurantvote.model.Meal;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
}
