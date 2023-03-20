package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scooterthecat.restaurantvote.model.Menu;

public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {
}
