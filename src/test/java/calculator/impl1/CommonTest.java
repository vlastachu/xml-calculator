package calculator.impl1;

import calculator.impl1.model.Statement;
import org.junit.Assert;
import org.junit.Test;

import static calculator.impl1.OperationFactory.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;


/**
 * Created by ingvard on 21.07.16.
 */
public class CommonTest {

    @Test
    public void happyTest() {
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
}
