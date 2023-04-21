package scooterthecat.restaurantvote.repository;

import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.User;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends BaseRepository<User> {
    Optional<User> getByEmail(String email);
}