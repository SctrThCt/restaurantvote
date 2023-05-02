package scooterthecat.restaurantvote.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.SecurityUtil;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.repository.restaurant.RestaurantRepository;
import scooterthecat.restaurantvote.repository.vote.VoteRepository;
import scooterthecat.restaurantvote.util.TimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final RestaurantRepository restaurantRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public VoteService(VoteRepository voteRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Vote get(int id) {
        return voteRepository.get(id, SecurityUtil.authId());
    }

    public void delete(int id, int userId) {
        voteRepository.delete(id, userId);
    }

    @Transactional
    public Vote create(int restaurantId) {
        Vote newVote = new Vote();
        newVote.setRestaurant(restaurantRepository.get(restaurantId));
        int userId = SecurityUtil.authId();
        voteRepository.save(newVote, userId);
        return newVote;
    }

    public void update(int voteId, int restaurantId) {
        TimeUtil.checkTime();
        int userId = SecurityUtil.authId();
        Vote oldVote = get(voteId);
        Assert.notNull(oldVote, "vote must not be null");
        oldVote.setRestaurant(restaurantRepository.get(restaurantId));
        oldVote.setDate(LocalDate.from(LocalDateTime.now()));
        voteRepository.save(oldVote, userId);
    }

    public List<Vote> getAll() {
        return voteRepository.getAll(SecurityUtil.authId());
    }
}
