package scooterthecat.restaurantvote.to;

import scooterthecat.restaurantvote.model.Menu;

public class RestaurantTo {

    private Integer id;
    private String name;
    private Menu menu;

    public RestaurantTo()
    {}

    public RestaurantTo(Integer id, String name,Menu menu)
    {
        this.id=id;
        this.name=name;
        this.menu = menu;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
