package service;

import model.Operation;

public class OperationService {
    public Operation execute(Operation operation) {
        return switch (operation.getType()) {
            case "sum" -> {
                operation.setResult(operation.getNum1() + operation.getNum2());
                yield operation;
            }
            case "sub" -> {
                operation.setResult(operation.getNum1() - operation.getNum2());
                yield operation;
            }
            case "mul" -> {
                operation.setResult(operation.getNum1() * operation.getNum2());
                yield operation;
            }
            case "div" -> {
                operation.setResult(operation.getNum1() / operation.getNum2());
                yield operation;
            }
            default -> throw new IllegalArgumentException("Operation type not supported");
        };
    }
}
