package calculator.impl1;

import calculator.impl1.model.Operand;
import calculator.impl1.model.Statement;
import calculator.impl1.model.operation.Addition;
import calculator.impl1.model.operation.Division;
import calculator.impl1.model.operation.Multiplication;
import calculator.impl1.model.operation.Subtraction;

/**
 * Created by ingvard on 21.07.16.
 */
public class OperationFactory {
    public static Statement sum(Statement left, Statement right) {
        return new Addition(left, right);
    }

    public static Statement div(Statement left, Statement right) {
        return new Division(left, right);
    }

    public static Statement mul(Statement left, Statement right) {
        return new Multiplication(left, right);
    }

    public static Statement sub(Statement left, Statement right) {
        return new Subtraction(left, right);
    }

    public static Statement value(double op) {
        return new Operand(op);
    }
}
