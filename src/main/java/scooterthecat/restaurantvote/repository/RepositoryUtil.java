package scooterthecat.restaurantvote.repository;

import java.util.NoSuchElementException;

public class RepositoryUtil {
    public static <T> T checkNotFound(BaseRepository<T> repository, int id, Class clazz) {
        return repository.findById(id).orElseThrow(
                () -> new NoSuchElementException(clazz.getSimpleName() + " with id " + id + " not found"));
    }
}
