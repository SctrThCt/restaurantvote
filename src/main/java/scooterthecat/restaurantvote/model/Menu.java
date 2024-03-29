package scooterthecat.restaurantvote.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"date", "restaurant_id"}, name = "one_menu_for_restaurant_per_day")})
@NoArgsConstructor
@Getter
@Setter
public class Menu extends BaseEntity {

    @Column(name = "restaurant_id", insertable = false, updatable = false)
    private Long restaurantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference(value = "menu_restaurant")
    private Restaurant restaurant;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_meal",
            joinColumns = {@JoinColumn(name = "menu_id")},
            inverseJoinColumns = {@JoinColumn(name = "meal_id")}/*,
            uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "meal_id"}, name = "uniq_meal_for_menu")}*/)
    private Set<Meal> meals;
}
