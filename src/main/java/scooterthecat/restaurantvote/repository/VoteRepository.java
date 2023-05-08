package scooterthecat.restaurantvote.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Vote;
import scooterthecat.restaurantvote.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

import static scooterthecat.restaurantvote.util.validation.ValidationUtil.checkModification;

@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote> {

    @Transactional
    @Modifying
    @Query("delete from Vote v where v.user.id=:user_id and v.id=:id")
    public int delete(@Param("user_id")int userId, @Param("id")int id);

    @EntityGraph(attributePaths = {"restaurant"}, type = EntityGraph.EntityGraphType.LOAD)
    public List<Vote> findAllByUserId(int userId);

    public Optional<Vote> findByIdAndUserId(int id, int userId);
    default void deleteExisted(int id, int userId) {
        checkModification(delete(id,userId),id);
    }
}
