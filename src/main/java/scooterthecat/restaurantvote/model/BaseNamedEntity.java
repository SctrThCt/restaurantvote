package scooterthecat.restaurantvote.model;

public abstract class BaseNamedEntity extends BaseEntity{
    protected String name;

    public String getName() {
        return name;
    }
}
