package calculator.impl1recursion.model;

/**
 * Created by ingvard on 20.07.16.
 */
public class Operand implements Statement {
    private final double value;

    public Operand(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
