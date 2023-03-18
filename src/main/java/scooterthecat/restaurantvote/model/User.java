package scooterthecat.restaurantvote.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseNamedEntity {

    private String email;
    private String password;
    private Role role;
    private Date registered;
    private Set<Role> roles;
    private List<Vote> votes;
}
