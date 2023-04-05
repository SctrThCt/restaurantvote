package scooterthecat.restaurantvote.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.repository.VoteRepository;

import java.util.List;

import static scooterthecat.restaurantvote.util.ValidationUtil.*;
import static scooterthecat.restaurantvote.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote get(int id)
    {
        return checkNotFoundWithId(repository.get(id),id);
    }

    public void delete(int id, int userId)
    {
        checkNotFoundWithId(repository.delete(id, userId),id);
    }

    public Vote create (Vote vote)
    {
        Assert.notNull(vote,"vote must not be null");
        checkNew(vote);
        return repository.save(vote);
    }

    public void update (Vote vote)
    {
        Assert.notNull(vote,"vote must not be null");
        assureIdConsistent(vote, vote.id());
        checkNotFoundWithId(repository.save(vote), vote.id());
    }

    public List<Vote> getAll()
    {
        return repository.getAll();
    }
}
