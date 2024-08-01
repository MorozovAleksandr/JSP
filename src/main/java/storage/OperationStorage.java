package storage;

import core.model.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationStorage extends Storage<Operation> {
    Optional<List<Operation>> findAllOperationsByUsername(String username);
}
