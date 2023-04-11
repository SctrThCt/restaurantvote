package scooterthecat.restaurantvote.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import scooterthecat.restaurantvote.model.Menu;
import scooterthecat.restaurantvote.service.MenuService;

import java.util.List;

@RestController
@RequestMapping(value = MenuController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController extends RootController {

    static final String REST_URL = "/admin/menu";

    private final MenuService service;

    public MenuController(MenuService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public Menu get(@PathVariable int id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PostMapping
    public Menu create(@RequestParam Menu menu) {
        return service.create(menu);
    }

    @PatchMapping("/{id}")
    public void update(@RequestParam Menu menu, @PathVariable int id) {
        service.update(menu);
    }

    @GetMapping
    public List<Menu> getAll() {
        return service.getAll();
    }

    @PostMapping("/{id}/meal")
    public void addMealToMenu(@PathVariable int id, @RequestParam int mealId) {
        service.addMealToMenu(id, mealId);
    }

    @DeleteMapping("/{id}/meal")
    public void removeMealFromMenu(@PathVariable int id,@RequestParam int mealId)
    {
        service.removeMealFromMenu(id, mealId);
    }
}
