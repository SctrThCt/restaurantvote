package scooterthecat.restaurantvote.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseNamedEntity {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    List<Menu> menu;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    List<Vote> votes;
}
