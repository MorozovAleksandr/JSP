package storage;

import lombok.Data;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class InMemoryUserStorage {
    private static final List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public Optional<User> findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
