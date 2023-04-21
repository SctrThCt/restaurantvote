package scooterthecat.restaurantvote.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.repository.vote.VoteRepository;

import java.util.List;

import static scooterthecat.restaurantvote.util.validation.ValidationUtil.assureIdConsistent;
import static scooterthecat.restaurantvote.util.validation.ValidationUtil.checkNew;

@Service
public class VoteService {

    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote get(int id) {
        return repository.get(id);
    }

    public void delete(int id, int userId) {
        repository.delete(id, userId);
    }

    public Vote create(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        checkNew(vote);
        return repository.save(vote);
    }

    public void update(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        assureIdConsistent(vote, vote.id());
        repository.save(vote);
    }

    public List<Vote> getAll() {
        return repository.getAll();
    }
}
