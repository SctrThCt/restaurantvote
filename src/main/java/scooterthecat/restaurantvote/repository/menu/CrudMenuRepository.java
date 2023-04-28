package scooterthecat.restaurantvote.repository.menu;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Menu;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {

    @EntityGraph(attributePaths = {"meals"})
    @Query("select m from Menu m where m.id=:id")
    Menu getWithMeals(@Param("id") int id);

    @Query("select m from Menu m where m.restaurant.id=:id")
    List<Menu> getByRestaurantId(@Param("id") int id);

    @Modifying
    @Query("delete from Menu m where m.id=:id")
    int delete(@Param("id") int id);


}
