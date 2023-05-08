package scooterthecat.restaurantvote.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import scooterthecat.restaurantvote.SecurityUtil;
import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.model.User;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.repository.UserRepository;
import scooterthecat.restaurantvote.repository.RestaurantRepository;
import scooterthecat.restaurantvote.repository.VoteRepository;
import scooterthecat.restaurantvote.util.TimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static scooterthecat.restaurantvote.repository.RepositoryUtil.checkNotFound;

@Service
@AllArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public Vote get(int id) {
        int userId = SecurityUtil.authId();
        return voteRepository.findByIdAndUserId(id,userId).orElseThrow(
                ()->new NoSuchElementException("Vote for userId "+userId+" with id "+id+" not found"));
    }

    public void delete(int id) {
        voteRepository.deleteExisted(id,SecurityUtil.authId());
    }

    @Transactional
    public Vote create(int restaurantId) {
        Vote vote = new Vote();
        Restaurant restaurant = checkNotFound(restaurantRepository, restaurantId, Restaurant.class);
        vote.setRestaurant(restaurant);
        int userId = SecurityUtil.authId();
        vote.setUser(checkNotFound(userRepository,userId, User.class));
        return voteRepository.save(vote);
    }

    @Transactional
    public void update(int voteId, int restaurantId) {
        TimeUtil.checkTime();
        Vote vote = get(voteId);
        Assert.notNull(vote, "vote must not be null");
        vote.setRestaurant(checkNotFound(restaurantRepository, restaurantId, Restaurant.class));
        vote.setDate(LocalDate.from(LocalDateTime.now()));
        voteRepository.save(vote);
    }

    public List<Vote> getAll() {
        return voteRepository.findAllByUserId(SecurityUtil.authId());
    }
}
