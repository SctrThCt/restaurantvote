package scooterthecat.restaurantvote.repository.menu;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Menu;

import java.util.List;

@Repository
public class MenuRepository {
    private final CrudMenuRepository crudMenuRepository;

    public MenuRepository(CrudMenuRepository crudMenuRepository) {
        this.crudMenuRepository = crudMenuRepository;
    }

    @Transactional
    public Menu save(Menu menu)
    {
        return crudMenuRepository.save(menu);
    }

    @Transactional
    public boolean delete(int id)
    {
        return crudMenuRepository.delete(id)!=0;
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
