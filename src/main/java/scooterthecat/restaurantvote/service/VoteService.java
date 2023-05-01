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
import scooterthecat.restaurantvote.util.TimeUtil;

import java.time.LocalDateTime;
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
        return voteRepository.get(id, SecurityUtil.authId());
    }

    public void delete(int id, int userId) {
        voteRepository.delete(id, userId);
    }

    @Transactional
    public Vote create(int restaurantId) {

        log.info("creating new vote");
        Vote newVote = new Vote();
        log.info("setting restaurant {} to vote", restaurantId);
        newVote.setRestaurant(restaurantRepository.get(restaurantId));
        log.info("setting user {} to vote");
        int userId = SecurityUtil.authId();
        log.info("saving vote from user {} for restaurant {}", userId, restaurantId);
        voteRepository.save(newVote, userId);
        return newVote;
    }

    public void update(int voteId, int restaurantId) {
        TimeUtil.checkTime();
        int userId = SecurityUtil.authId();
        Vote oldVote = get(voteId);
        Assert.notNull(oldVote, "vote must not be null");
        oldVote.setRestaurant(restaurantRepository.get(restaurantId));
        oldVote.setDateTime(LocalDateTime.now());
        voteRepository.save(oldVote, userId);
    }

    public List<Vote> getAll() {
        return voteRepository.getAll(SecurityUtil.authId());
    }

    public void createOrUpdate(int restaurantId, int userId) {

    }
}
