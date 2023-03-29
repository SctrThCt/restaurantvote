package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Menu;

import javax.persistence.Entity;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {

    @EntityGraph(attributePaths = {"meals"})
    @Query("select m from Menu m where m.id=:id")
    Menu getWithMeals(@Param("id")int id);

    @Query("select m from Menu m where m.restaurant.id=:id")
    List<Menu> getByRestaurantId(@Param("id") int id);
}
