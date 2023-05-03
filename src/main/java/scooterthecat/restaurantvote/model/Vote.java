package scooterthecat.restaurantvote.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "vote", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "date_time"}, name = "uniq_vote_for_user_per_day")})
@NoArgsConstructor
@Getter
@Setter
public class Vote extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    @Column(name = "date_time", nullable = false, columnDefinition = "timestamp default now()", updatable = true)
    private LocalDate date = LocalDate.from(LocalDateTime.now());

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(name = "restaurant_id", insertable = false, updatable = false)
    private Long restaurantId;
}
