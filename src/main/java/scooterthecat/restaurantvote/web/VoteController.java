package scooterthecat.restaurantvote.web;

import org.springframework.util.Assert;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.repository.VoteRepository;

import static scooterthecat.restaurantvote.util.ValidationUtil.*;
import static scooterthecat.restaurantvote.util.ValidationUtil.checkNotFoundWithId;

public class VoteController extends RootController{

    private final VoteRepository repository;

    public VoteController(VoteRepository repository) {
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

    public void update (Vote menu)
    {
        Assert.notNull(menu,"vote must not be null");
        assureIdConsistent(menu, menu.id());
        checkNotFoundWithId(repository.save(menu), menu.id());
    }

    public void getAll()
    {
        repository.getAll();
    }
}
