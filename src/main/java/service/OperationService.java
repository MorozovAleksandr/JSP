package service;

import model.Operation;
import storage.InMemoryOperationStorage;

import java.util.List;
import java.util.Optional;

public class OperationService {
    private final InMemoryOperationStorage inMemoryOperationStorage = new InMemoryOperationStorage();

    public Operation execute(Operation operation) {
        double result = switch (operation.getType()) {
            case "sum" -> operation.getNum1() + operation.getNum2();
            case "sub" -> operation.getNum1() - operation.getNum2();
            case "mul" -> operation.getNum1() * operation.getNum2();
            case "div" -> operation.getNum1() / operation.getNum2();
            default -> throw new IllegalArgumentException("Operation type not supported");
        };

        operation.setResult(result);
        inMemoryOperationStorage.save(operation);
        return operation;
    }

    public Optional<List<Operation>> getAllOperations(String username) {
        return inMemoryOperationStorage.findAllOperationsByUsername(username);
    }
}
