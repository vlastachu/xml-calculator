package calculator.model.output;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MStepachev on 21.07.2016.
 */
@XmlRootElement
public class ExpressionResults {
    
    private List<ExpressionResult> expressionResults;

    public ExpressionResults() {
        expressionResults = new ArrayList<ExpressionResult>();
    }

    public List<ExpressionResult> getExpressionResult() {
        return expressionResults;
    }

    @XmlElement
    public void setExpressionResult(List<ExpressionResult> expressionResults) {
        this.expressionResults = expressionResults;
    }

    public void addElement(ExpressionResult element) {
        expressionResults.add(element);
    }
}
