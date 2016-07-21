package calculator.model.output;

import calculator.model.output.ExpressionResult;
import calculator.model.output.ExpressionResults;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by MStepachev on 21.07.2016.
 */
@XmlRootElement(name = "simpleCalculator")
public class SimpleCalculatorOutput {
    private ExpressionResults expressionResults;

    public SimpleCalculatorOutput() {
        expressionResults = new ExpressionResults();
    }

    public ExpressionResults getExpressionResults() {
        return expressionResults;
    }

    @XmlElement
    public void setExpressionResults(ExpressionResults expressionResults) {
        this.expressionResults = expressionResults;
    }

    public void addResult(double value) {
        expressionResults.addElement(new ExpressionResult(value));
    }
}
