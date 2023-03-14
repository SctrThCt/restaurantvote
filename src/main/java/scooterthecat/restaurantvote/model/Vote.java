package scooterthecat.restaurantvote.model;

import java.time.LocalDate;

public class Vote extends BaseEntity{

    private Restaurant restaurant;
    private LocalDate date;
    private User user;
}
