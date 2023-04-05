package scooterthecat.restaurantvote.web;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RestController;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.model.Menu;
import scooterthecat.restaurantvote.repository.MenuRepository;

import static scooterthecat.restaurantvote.util.ValidationUtil.*;
import static scooterthecat.restaurantvote.util.ValidationUtil.checkNotFoundWithId;
@RestController
public class MenuController extends RootController{

    private final MenuRepository repository;

    public MenuController(MenuRepository repository) {
        this.repository = repository;
    }

    public Menu get(int id)
    {
        return checkNotFoundWithId(repository.get(id),id);
    }

    public void delete(int id)
    {
        checkNotFoundWithId(repository.delete(id),id);
    }

    public Menu create (Menu menu)
    {
        Assert.notNull(menu,"menu must not be null");
        checkNew(menu);
        return repository.save(menu);
    }

    public void update (Menu menu)
    {
        Assert.notNull(menu,"menu must not be null");
        assureIdConsistent(menu, menu.id());
        checkNotFoundWithId(repository.save(menu), menu.id());
    }

    public void getAll()
    {
        repository.getAll();
    }
}
