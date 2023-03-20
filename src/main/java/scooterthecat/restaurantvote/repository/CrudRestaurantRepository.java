package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scooterthecat.restaurantvote.model.Restaurant;

public interface CrudRestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
