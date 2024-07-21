package core.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Operation {
    private final double num1;
    private final double num2;
    private final String type;
    private double result;
    private String author;

    public Operation(double num1, double num2, String type, String author) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.author = author;
    }
}
