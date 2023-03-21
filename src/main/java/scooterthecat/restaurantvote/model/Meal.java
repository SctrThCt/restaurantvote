package scooterthecat.restaurantvote.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "meal", uniqueConstraints = {@UniqueConstraint( columnNames = {"name", "price"},name = "uniq_name_price")})

public class Meal extends BaseNamedEntity {

    @Column(name = "price")
    private Integer price;

    public Meal()
    {}
    public void setPrice(int price)
    {
        this.price=price;
    }
    public Integer getPrice()
    {
        return price;
    }
}
