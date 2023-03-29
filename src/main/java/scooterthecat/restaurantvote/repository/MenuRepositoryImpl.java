package scooterthecat.restaurantvote.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.model.Menu;

import java.util.List;

@Repository
public class MenuRepositoryImpl {
    private final CrudMenuRepository crudMenuRepository;

    public MenuRepositoryImpl(CrudMenuRepository crudMenuRepository) {
        this.crudMenuRepository = crudMenuRepository;
    }

    @Transactional
    public Menu save(Menu menu)
    {
        return crudMenuRepository.save(menu);
    }

    @Transactional
    public void delete(int id)
    {
        crudMenuRepository.deleteById(id);
    }

    public Menu get(int id)
    {
        return crudMenuRepository.findById(id).orElse(null);
    }

    public Menu getWithMeals(int id)
    {
        return crudMenuRepository.getWithMeals(id);
    }
    public List<Menu> getByRestaurantId(int id)
    {
        return crudMenuRepository.getByRestaurantId(id);
    }

    public List<Menu> getAll()
    {
        return crudMenuRepository.findAll();
    }
}
