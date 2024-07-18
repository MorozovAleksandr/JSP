package storage;

import model.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryOperationStorage {
    private final static List<Operation> operations = new ArrayList<>();

    public void save(Operation operation) {
        operations.add(operation);
    }

    public Optional<List<Operation>> findAllOperationsByUsername(String username) {
        List<Operation> operationsByUsername = new ArrayList<>();

        for (Operation operation : operations) {
            if (operation.getAuthor().equals(username)) {
                operationsByUsername.add(operation);
            }
        }

        if(operationsByUsername.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(operationsByUsername);
    }
}
