package scooterthecat.restaurantvote.repository.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scooterthecat.restaurantvote.model.Vote;
@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote,Integer> {


    @Query("delete from Vote v where v.user.id=:user_id and v.id=:id")
    public int delete(@Param("user_id")int userId, @Param("id")int id);

}
