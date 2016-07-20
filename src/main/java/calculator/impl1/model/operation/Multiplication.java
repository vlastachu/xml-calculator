package calculator.impl1.model.operation;

import calculator.impl1.model.AbstractOperation;
import calculator.impl1.model.Statement;

/**
 * Created by ingvard on 20.07.16.
 */
public class Multiplication extends AbstractOperation {

    public Multiplication(Statement leftOperand, Statement rightOperand) {
        super(leftOperand, rightOperand);
    }

    public double compute(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
