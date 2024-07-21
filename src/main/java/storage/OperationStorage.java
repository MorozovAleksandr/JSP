package storage;

import core.model.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationStorage {
    void save(Operation operation);

    Optional<List<Operation>> findAllOperationsByUsername(String username);
}
