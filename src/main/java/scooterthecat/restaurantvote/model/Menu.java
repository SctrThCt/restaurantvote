package scooterthecat.restaurantvote.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menu",uniqueConstraints = {@UniqueConstraint(columnNames = {"date", "restaurant_id"}, name = "one_menu_for_restaurant_per_day")})
public class Menu extends BaseEntity{

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_meal",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "meal_id"}, name = "unique_meal_for_menu")})
    private Set<Meal> meals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate localDate) {
        this.date = date;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
