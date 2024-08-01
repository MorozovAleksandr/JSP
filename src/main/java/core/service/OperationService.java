package core.service;

import core.model.Operation;
import core.repository.OperationRepository;
import storage.OperationStorage;

import java.util.List;
import java.util.Optional;

public record OperationService(OperationStorage storage) implements OperationRepository {
    public Operation execute(Operation operation) {
        double result = switch (operation.getType()) {
            case "sum" -> operation.getNum1() + operation.getNum2();
            case "sub" -> operation.getNum1() - operation.getNum2();
            case "mul" -> operation.getNum1() * operation.getNum2();
            case "div" -> operation.getNum1() / operation.getNum2();
            default -> throw new IllegalArgumentException("Operation type not supported");
        };

        operation.setResult(result);
        storage.save(operation);
        return operation;
    }

    public Optional<List<Operation>> getAllOperations(String username) {
        return storage.findAllOperationsByUsername(username);
    }
}
