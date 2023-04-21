package scooterthecat.restaurantvote.model;

import javax.persistence.*;

@Entity
@Table(name = "meal", uniqueConstraints = {@UniqueConstraint( columnNames = {"name", "price"},name = "uniq_name_price")})

public class Meal extends NamedEntity {

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
