package scooterthecat.restaurantvote.web;

import org.springframework.web.bind.annotation.*;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.service.MealService;

import java.util.List;

import static scooterthecat.restaurantvote.util.ValidationUtil.assureIdConsistent;

@RestController
@RequestMapping("/admin/meals")
public class MealController extends RootController {

    private final MealService service;

    public MealController(MealService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Meal get(@PathVariable int id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PostMapping
    public Meal create(Meal meal) {
        return service.create(meal);
    }

    @PutMapping("/{id}")
    public void update(@RequestParam Meal meal, @PathVariable int id) {
        assureIdConsistent(meal, id);
        service.update(meal, id);
    }

    @GetMapping
    public List<Meal> getAll() {
        return service.getAll();
    }
}
