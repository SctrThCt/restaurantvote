package scooterthecat.restaurantvote.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Meal;
import scooterthecat.restaurantvote.model.User;

import java.util.List;

@Repository
public class UserRepositoryImpl {
    private final CrudUserRepository crudUserRepository;

    public UserRepositoryImpl(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    @Transactional
    public User save(User user)
    {
        return crudUserRepository.save(user);
    }

    @Transactional
    public void delete(int id)
    {
        crudUserRepository.deleteById(id);
    }

    public User get(int id)
    {
        return crudUserRepository.findById(id).orElse(null);
    }

    public List<User> getAll()
    {
        return crudUserRepository.findAll();
    }
}
