package calculator.model.output;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by MStepachev on 21.07.2016.
 */
@XmlRootElement
public class ExpressionResult {
    private double result;

    public ExpressionResult() {
    }

    public ExpressionResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    @XmlElement
    public void setResult(double result) {
        this.result = result;
    }
}
