package scooterthecat.restaurantvote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "meal")
public class Meal extends BaseNamedEntity {

    @Column(name = "price")
    @Positive
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
