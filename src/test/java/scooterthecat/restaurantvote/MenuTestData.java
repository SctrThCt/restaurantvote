package scooterthecat.restaurantvote;


import scooterthecat.restaurantvote.model.Menu;

import java.time.LocalDate;
import java.util.Set;

import static scooterthecat.restaurantvote.MealTestData.*;

public class MenuTestData {
    public static final Integer AKOP_MENU_ID = 5;
    public static final Integer HRYCH_MENU_ID = 6;
    public static final Menu akop_menu = new Menu();
    public static final Menu hrych_menu = new Menu();

    static {
        akop_menu.setId(AKOP_MENU_ID);
        akop_menu.setMeals(Set.of(akop_meal_1, akop_meal_2));
        akop_menu.setDate(LocalDate.of(2020, 1, 30));
        akop_menu.setRestaurant(RestaurantTestData.akop);
        hrych_menu.setId(HRYCH_MENU_ID);
        hrych_menu.setMeals(Set.of(hrych_meal_1));
        hrych_menu.setDate(LocalDate.of(2020, 1, 30));
        hrych_menu.setRestaurant(RestaurantTestData.hrych);
    }

}