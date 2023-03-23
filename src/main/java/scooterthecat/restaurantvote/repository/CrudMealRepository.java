package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scooterthecat.restaurantvote.model.Meal;

@Repository
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
}
