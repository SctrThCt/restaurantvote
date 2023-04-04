package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.User;
@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer>{
    @Modifying
    @Query("delete from Restaurant r where r.id=:id")
    int delete (@Param("id") int id);
}
