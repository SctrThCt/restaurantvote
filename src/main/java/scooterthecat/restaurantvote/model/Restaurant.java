package scooterthecat.restaurantvote.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@Getter
@Setter
public class Restaurant extends NamedEntity {
    @JsonBackReference(value = "restaurant_menu")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("date DESC")
    private List<Menu> menu;
    @JsonBackReference(value = "restaurant_votes")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("dateTime DESC")
    private List<Vote> votes;

    public Restaurant(Integer id, String name, List<Menu> menu) {
        super(id, name);
        this.menu = menu;
    }
}
