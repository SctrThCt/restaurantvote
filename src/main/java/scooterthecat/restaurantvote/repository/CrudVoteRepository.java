package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scooterthecat.restaurantvote.model.Vote;

public interface CrudVoteRepository extends JpaRepository<Vote,Integer> {
}
