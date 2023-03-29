package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.User;
@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {
}