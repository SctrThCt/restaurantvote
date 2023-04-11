package scooterthecat.restaurantvote.repository.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.User;

import java.util.List;

@Repository
public class UserRepository {
    private final CrudUserRepository crudUserRepository;

    public UserRepository(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    @Transactional
    public User save(User user)
    {
        return crudUserRepository.save(user);
    }

    @Transactional
    public boolean delete(int id)
    {
        return crudUserRepository.delete(id)!=0;
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
