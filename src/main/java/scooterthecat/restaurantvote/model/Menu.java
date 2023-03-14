package scooterthecat.restaurantvote.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Menu extends BaseEntity{

    private Date date;
    List<Meal> meals;
    Restaurant restaurant;

}
