package calculator.impl1.model;

/**
 * Created by ingvard on 20.07.16.
 */
public abstract class AbstractOperation implements Statement {

    private final Statement leftOperand;
    private final Statement rightOperand;

    public AbstractOperation(Statement leftOperand, Statement rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public double getValue() {
        return compute(leftOperand.getValue(), rightOperand.getValue());
    }

    public abstract double compute(double leftOperand, double rightOperand);

}
