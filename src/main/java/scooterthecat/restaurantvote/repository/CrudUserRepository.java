package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scooterthecat.restaurantvote.model.User;

public interface CrudUserRepository extends JpaRepository<User, Integer> {
}
