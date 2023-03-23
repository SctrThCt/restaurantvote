package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import scooterthecat.restaurantvote.model.Menu;

import javax.persistence.Entity;

@Repository
public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {

    @EntityGraph(attributePaths = {"meals"})
    @Query("select m from Menu m where m.id=:id")
    Menu getWithMeals(@Param("id")int id);
}
