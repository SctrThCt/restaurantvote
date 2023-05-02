package scooterthecat.restaurantvote;

import scooterthecat.restaurantvote.model.Restaurant;

public class RestaurantTestData {
    public static Integer AKOP_ID = 1;
    public static Integer HRYCH_ID = 2;
    public static Restaurant akop = new Restaurant();
    public static Restaurant hrych = new Restaurant();

    static {
        akop.setId(AKOP_ID);
        akop.setName("Шаурма у Акопа");
        hrych.setId(HRYCH_ID);
        hrych.setName("Лё Хрючевальня");
    }
}
