package scooterthecat.restaurantvote.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "meal", uniqueConstraints = {@UniqueConstraint( columnNames = {"name", "price"},name = "uniq_name_price")})
@NoArgsConstructor
@Getter
@Setter

public class Meal extends NamedEntity {

    @Column(name = "price")
    private Integer price;
    public void setPrice(int price)
    {
        this.price=price;
    }
    public Integer getPrice()
    {
        return price;
    }
}
