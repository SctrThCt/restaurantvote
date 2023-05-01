package scooterthecat.restaurantvote.error;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.HttpStatus;

public class IllegalActionException extends AppException {

    public IllegalActionException(String message) {
        super(HttpStatus.FORBIDDEN, message, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE));
    }
}
