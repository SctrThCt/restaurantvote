package scooterthecat.restaurantvote.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseNamedEntity {
    @OneToMany
    List<Menu> menu;
    @OneToMany
    List<Vote> votes;
}
