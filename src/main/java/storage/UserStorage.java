package storage;

import core.model.User;

import java.util.Optional;

public interface UserStorage extends Storage<User> {
    Optional<User> findByUsername(String username);
}
