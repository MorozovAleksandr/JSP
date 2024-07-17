package service;

import lombok.Data;
import model.User;
import storage.InMemoryUserStorage;

import java.util.List;
import java.util.Optional;

@Data
public class UserService {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    public void registerUser(User user) {
        inMemoryUserStorage.save(user);
    }

    public Optional<User> login(String username, String password) {
        Optional<User> byUsername = inMemoryUserStorage.findByUsername(username);

        if(byUsername.isPresent()) {
            User user = byUsername.get();
            if(user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
