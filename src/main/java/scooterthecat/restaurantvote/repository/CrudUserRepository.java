package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scooterthecat.restaurantvote.model.User;
@Repository
public interface CrudUserRepository extends JpaRepository<User, Integer> {
}
