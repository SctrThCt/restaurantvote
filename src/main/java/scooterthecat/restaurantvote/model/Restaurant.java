package scooterthecat.restaurantvote.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseNamedEntity {
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("date ASC")
    List<Menu> menu;
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("dateTime ASC")
    List<Vote> votes;
}
