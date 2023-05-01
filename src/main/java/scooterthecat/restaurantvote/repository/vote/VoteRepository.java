package scooterthecat.restaurantvote.repository.vote;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.repository.UserRepository;

import java.util.List;

@Repository
public class VoteRepository {
    private final CrudVoteRepository crudVoteRepository;
    private final UserRepository userRepository;

    public VoteRepository(CrudVoteRepository crudVoteRepository, UserRepository userRepository) {
        this.crudVoteRepository = crudVoteRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Vote save(Vote vote, int userId) {
        if (!vote.isNew() && get(vote.id(), userId) == null) {
            return null;
        }
        vote.setUser(userRepository.getById(userId));
        return crudVoteRepository.save(vote);
    }

    @Transactional
    public boolean delete(int id, int userId) {
        return crudVoteRepository.delete(userId, id) != 0;
    }

    public Vote get(int id, int userId) {
        return crudVoteRepository.findById(id)
                .filter(vote -> vote.getUser().getId() == userId)
                .orElse(null);
    }

    public List<Vote> getAll(int userId) {
        return crudVoteRepository.findAllByUserId(userId);
    }
}
