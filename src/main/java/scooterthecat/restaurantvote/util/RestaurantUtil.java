package scooterthecat.restaurantvote.util;

import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.to.RestaurantTo;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantUtil {

    public static RestaurantTo getTo(Restaurant restaurant)
    {
        return new RestaurantTo(restaurant.getId(),
                restaurant.getName(),
                restaurant.getMenu().get(0));
    }

    public static List<RestaurantTo> getTos(List<Restaurant> restaurants)
    {
        return restaurants.stream().map(e->getTo(e)).collect(Collectors.toList());
    }
}
