package scooterthecat.restaurantvote.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "vote")
public class Vote extends BaseEntity{

    @OneToOne
    private Restaurant restaurant;
    private LocalDate date;
    @ManyToOne
    private User user;
}
