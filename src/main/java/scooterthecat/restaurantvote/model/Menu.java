package scooterthecat.restaurantvote.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "menu")
public class Menu extends BaseEntity{

    @Column(name = "date", nullable = false)
    private Date date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "meal")
    private List<Meal> meals;

    @ManyToOne
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
