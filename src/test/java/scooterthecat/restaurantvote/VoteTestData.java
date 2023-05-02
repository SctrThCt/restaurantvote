package scooterthecat.restaurantvote;

import scooterthecat.restaurantvote.model.User;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.user.UserTestData;

import java.time.LocalDate;

public class VoteTestData {
    public static Integer USER_VOTE_ID = 1;
    public static Integer ADMIN_VOTE_ID = 2;
    public static Vote user_vote = new Vote();
    public static Vote admin_vote = new Vote();
    static {
        user_vote.setId(USER_VOTE_ID);
        user_vote.setUser(UserTestData.user);
        user_vote.setRestaurant(RestaurantTestData.akop);
        user_vote.setDate(LocalDate.of(2020,1,29));
        admin_vote.setId(ADMIN_VOTE_ID);
        admin_vote.setUser(UserTestData.admin);
        admin_vote.setRestaurant(RestaurantTestData.hrych);
        admin_vote.setDate(LocalDate.of(2020,1,29));
    }
}
