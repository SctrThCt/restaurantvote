package scooterthecat.restaurantvote.util;

import scooterthecat.restaurantvote.error.IllegalActionException;

import java.time.LocalDateTime;

public class TimeUtil {

    public static void checkTime() {
        if (LocalDateTime.now().getHour() >= 11)
            throw new IllegalActionException("You can't change vote after 11 am");
    }
}
