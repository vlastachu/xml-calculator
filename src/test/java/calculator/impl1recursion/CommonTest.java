package calculator.impl1recursion;

import calculator.impl1recursion.model.Statement;
import calculator.impl1recursion.model.operation.Addition;
import calculator.impl1recursion.model.operation.Division;
import calculator.impl1recursion.model.operation.Multiplication;
import calculator.impl1recursion.model.operation.Subtraction;
import org.junit.Assert;
import org.junit.Test;

import static calculator.impl1recursion.OperationFactory.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;


/**
 * Created by ingvard on 21.07.16.
 */
public class CommonTest {

    @Test
    public void operation_twoNumericArgument_calculateBaseOperation() {
        Assert.assertThat(new Addition(value(-1), value(-2)).getValue(), is(equalTo(-3.0)));
        Assert.assertThat(new Division(value(-1), value(-2)).getValue(), is(equalTo(0.5)));
        Assert.assertThat(new Multiplication(value(-1), value(2)).getValue(), is(equalTo(-2.0)));
        Assert.assertThat(new Subtraction(value(-1), value(-2)).getValue(), is(equalTo(1.0)));
    }

    @Test
    public void composition_twoChildrenOperation() {
        Statement composition = sub(
                mul(
                        value(3),
                        value(2)
                ),
                sum(
                        value(1),
                        value(-1)
                )
        );

        double result = composition.getValue();

        Assert.assertThat(result, is(equalTo(6.0)));
    }

    @Test
    public void composition_childrenOperationAndLeftValue() {
        Statement composition = mul(
                value(3),
                sum(
                        value(4),
                        value(-1)
                )
        );

        double result = composition.getValue();

        Assert.assertThat(result, is(equalTo(9.0)));
    }

    @Test
    public void composition_childrenOperationAndRightValue() {
        Statement composition = mul(
                sum(
                        value(4),
                        value(-1)
                ),
                value(3)
        );

        double result = composition.getValue();

        Assert.assertThat(result, is(equalTo(9.0)));
    }

    @Test
    public void simpleTest1() {
        Statement expression = mul(
                sub(
                        sum(
                                value(2),
                                value(4)
                        ),
                        div(
                                value(1),
                                value(4)
                        )
                ),
                sub(
                        sum(
                                value(12),
                                value(55)
                        ),
                        mul(
                                value(123),
                                value(4)
                        )
                )
        );

        double result = expression.getValue();

        Assert.assertThat(result, is(equalTo(-2443.75)));
    }

    @Test
    public void simpleTest2() {
        Statement expression = sub(
                mul(
                        div(
                                value(211),
                                value(114)
                        ),
                        div(
                                value(13),
                                value(41)
                        )
                ),
                sub(
                        sum(
                                value(123),
                                value(1235)
                        ),
                        mul(
                                value(55),
                                value(1111)
                        )
                )
        );

        double result = expression.getValue();

        Assert.assertThat(result, is(equalTo(59747.58686350021)));
    }
}
