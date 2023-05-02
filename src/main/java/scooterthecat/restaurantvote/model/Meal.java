package scooterthecat.restaurantvote.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "meal", uniqueConstraints = {@UniqueConstraint( columnNames = {"name", "price"},name = "uniq_name_price")})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Meal extends NamedEntity {

    @Column(name = "price")
    private Integer price;

}
