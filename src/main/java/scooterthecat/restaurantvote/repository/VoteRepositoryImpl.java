package scooterthecat.restaurantvote.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.model.Vote;

import java.util.List;

@Repository
public class VoteRepositoryImpl {
    private final CrudVoteRepository crudVoteRepository;

    public VoteRepositoryImpl(CrudVoteRepository crudVoteRepository) {
        this.crudVoteRepository = crudVoteRepository;
    }

    @Transactional
    public Vote save(Vote vote)
    {
        return crudVoteRepository.save(vote);
    }

    @Transactional
    public void delete(int id, int userId)
    {
        crudVoteRepository.delete(userId,id);
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
