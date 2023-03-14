package scooterthecat.restaurantvote.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class User extends BaseNamedEntity {

    private String email;
    private String password;
    private Role role;
    private Date registered;
    private Set<Role> roles;
    private List<Vote> votes;
}
