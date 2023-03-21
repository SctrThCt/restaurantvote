package scooterthecat.restaurantvote.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "menu",uniqueConstraints = {@UniqueConstraint(columnNames = {"date", "restaurant_id"}, name = "one_menu_for_restaurant_per_day")})
public class Menu extends BaseEntity{

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_meal",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "meal_id"}, name = "unique_meal_for_menu")})
    private List<Meal> meals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
