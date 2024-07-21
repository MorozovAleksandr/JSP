package storage;

import core.model.User;

import java.util.Optional;

public interface UserStorage {
    void save(User user);

    Optional<User> findByUsername(String username);
}
