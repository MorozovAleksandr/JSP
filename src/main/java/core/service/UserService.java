package core.service;

import core.model.User;
import core.repository.UserRepository;
import storage.UserStorage;

import java.util.Optional;

public record UserService(UserStorage storage) implements UserRepository {

    public void registerUser(User user) {
        storage.save(user);
    }

    public Optional<User> login(String username, String password) {
        Optional<User> byUsername = storage.findByUsername(username);

        if (byUsername.isPresent()) {
            User user = byUsername.get();
            if (user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
