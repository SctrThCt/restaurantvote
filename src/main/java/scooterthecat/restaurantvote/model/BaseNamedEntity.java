package scooterthecat.restaurantvote.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class BaseNamedEntity extends BaseEntity{

    @NotBlank
    @Size(min = 2, max = 128)
    @Column(name = "name", nullable = false)
    protected String name;

    public BaseNamedEntity(){}

    public BaseNamedEntity(Integer id,String name)
    {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    @Override
    public String toString() {
        return super.toString() + '(' + name + ')';
    }
}
