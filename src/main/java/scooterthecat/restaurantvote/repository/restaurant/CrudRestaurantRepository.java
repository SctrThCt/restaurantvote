package scooterthecat.restaurantvote.repository.restaurant;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Restaurant;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant,Integer> {

    @Modifying
    @Query("delete from Restaurant r where r.id=:id")
    int delete (@Param("id") int id);

    @Query("select r from Restaurant r order by r.id")
    @EntityGraph(attributePaths = {"menu"})
    public List<Restaurant> getAllWithMenus();
}
