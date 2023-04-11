package scooterthecat.restaurantvote.repository.vote;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Vote;

import java.util.List;

@Repository
public class VoteRepository {
    private final CrudVoteRepository crudVoteRepository;

    public VoteRepository(CrudVoteRepository crudVoteRepository) {
        this.crudVoteRepository = crudVoteRepository;
    }

    @Transactional
    public Vote save(Vote vote)
    {
        return crudVoteRepository.save(vote);
    }

    @Transactional
    public boolean delete(int id, int userId)
    {
        return crudVoteRepository.delete(userId,id)!=0;
    }

    public Vote get(int id)
    {
        return crudVoteRepository.findById(id).orElse(null);
    }

    public List<Vote> getAll()
    {
        return crudVoteRepository.findAll();
    }
}
