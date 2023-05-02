package scooterthecat.restaurantvote;

import scooterthecat.restaurantvote.model.Meal;

public class MealTestData {
    public static final int AKOP_MEAL_1_ID = 2;
    public static final Integer AKOP_MEAL_2_ID = 17;
    public static final Integer HRYCH_MEAL_1_ID = 12;
    public static final Meal akop_meal_1 = new Meal();
    public static final Meal akop_meal_2 = new Meal();
    public static final Meal hrych_meal_1 = new Meal();

    static {
        akop_meal_1.setId(AKOP_MEAL_1_ID);
        akop_meal_1.setName("Фри");
        akop_meal_1.setPrice(200);
        akop_meal_2.setId(AKOP_MEAL_2_ID);
        akop_meal_2.setName("Борщ");
        akop_meal_2.setPrice(150);
        hrych_meal_1.setId(HRYCH_MEAL_1_ID);
        hrych_meal_1.setName("Кофе");
        hrych_meal_1.setPrice(150);
    }
}

