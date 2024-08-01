package core.repository;
import core.model.User;
import java.util.Optional;

public interface UserRepository {
    void registerUser(User user);

    Optional<User> login(String username, String password);
}
