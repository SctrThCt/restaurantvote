package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Restaurant;
import scooterthecat.restaurantvote.repository.BaseRepository;

import java.util.List;

@Transactional(readOnly = true)
public interface RestaurantRepository extends BaseRepository<Restaurant> {

    @Query("select r from Restaurant r order by r.id")
    @EntityGraph(attributePaths = {"menu"}, type = EntityGraph.EntityGraphType.LOAD)
    public List<Restaurant> getAllWithMenus();
}
