package core.repository;
import core.model.Operation;
import java.util.List;
import java.util.Optional;

public interface OperationRepository {
    Operation execute(Operation operation);

    Optional<List<Operation>> getAllOperations(String username);
}
