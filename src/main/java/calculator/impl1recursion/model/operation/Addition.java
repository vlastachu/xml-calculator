package calculator.impl1recursion.model.operation;

import calculator.impl1recursion.model.AbstractOperation;
import calculator.impl1recursion.model.Statement;

/**
 * Created by ingvard on 20.07.16.
 */
public class Addition extends AbstractOperation {

    public Addition(Statement leftOperand, Statement rightOperand) {
        super(leftOperand, rightOperand);
    }

    public double compute(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
