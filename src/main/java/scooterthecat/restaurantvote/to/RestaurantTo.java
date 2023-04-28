package scooterthecat.restaurantvote.to;

import lombok.Getter;
import lombok.Setter;
import scooterthecat.restaurantvote.model.Menu;

@Getter
@Setter
public class RestaurantTo extends NamedTo{
    private Menu menu;

    public RestaurantTo(Integer id, String name,Menu menu)
    {
        super(id,name);
        this.menu = menu;
    }
}
