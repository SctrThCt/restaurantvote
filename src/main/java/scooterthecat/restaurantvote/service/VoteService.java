package scooterthecat.restaurantvote.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.SecurityUtil;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.repository.UserRepository;
import scooterthecat.restaurantvote.repository.restaurant.RestaurantRepository;
import scooterthecat.restaurantvote.repository.vote.VoteRepository;

import java.util.List;

import static scooterthecat.restaurantvote.util.validation.ValidationUtil.assureIdConsistent;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private Logger log = LoggerFactory.getLogger(getClass());

    public VoteService(VoteRepository voteRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    public Vote get(int id) {
        return voteRepository.get(id);
    }

    public void delete(int id, int userId) {
        voteRepository.delete(id, userId);
    }
    @Transactional
    public Vote create(int restaurantId) {

        log.info("creating new vote");
        Vote newVote = new Vote();
        log.info("setting restaurant {} to vote",restaurantId);
        newVote.setRestaurant(restaurantRepository.get(restaurantId));
        log.info("setting user {} to vote");
        newVote.setUser(SecurityUtil.authUser());
        log.info("saving vote from user {} for restaurant {}",newVote.getUser().getId(),restaurantId);
        voteRepository.save(newVote);
        return newVote;
    }

    public void update(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        assureIdConsistent(vote, vote.id());
        voteRepository.save(vote);
    }

    public List<Vote> getAll() {
        return voteRepository.getAll(SecurityUtil.authId());
    }

    public void createOrUpdate(int restaurantId, int userId)
    {

    }
}
