package scooterthecat.restaurantvote.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import scooterthecat.restaurantvote.to.RestaurantTo;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseNamedEntity {
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("date ASC")
    private List<Menu> menu;
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("dateTime ASC")
    private List<Vote> votes;

    public Restaurant(){}

    public Restaurant(Integer id, String name, List<Menu> menu)
    {
        super(id, name);
        this.menu = menu;
    }
    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
