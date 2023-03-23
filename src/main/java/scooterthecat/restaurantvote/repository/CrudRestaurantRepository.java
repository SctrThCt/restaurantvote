package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scooterthecat.restaurantvote.model.Restaurant;

@Repository
public interface CrudRestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
