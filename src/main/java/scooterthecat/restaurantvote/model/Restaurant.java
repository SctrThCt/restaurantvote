package scooterthecat.restaurantvote.model;

import java.util.List;
import java.util.Set;

public class Restaurant extends BaseNamedEntity {
    Menu menu;
    List<Vote> votes;
}
