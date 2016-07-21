package calculator;

import calculator.impl1recursion.model.Statement;
import calculator.mapper.XmlInputToStatementMapper;
import calculator.model.input.SimpleCalculator;
import calculator.model.output.SimpleCalculatorOutput;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by MStepachev on 21.07.2016.
 */
public class App {
    private final static String INPUT_FILE = "src/main/resources/sampleTest.xml";
    private final static String OUTPUT_FILE = "src/main/resources/ResultsampleTest.xml";

    public static void main(String[] args) {
        try {
            SimpleCalculatorOutput output = new SimpleCalculatorOutput();
            SimpleCalculator inputExpression = getSimpleCalculatorFromFile(INPUT_FILE);
            List<Statement> statementExpressions = new XmlInputToStatementMapper().map(inputExpression);

            for (Statement expression : statementExpressions) {
                output.addResult(expression.getValue());
            }

            saveResultToFile(output);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static SimpleCalculator getSimpleCalculatorFromFile(String fileName) throws JAXBException {
        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(SimpleCalculator.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (SimpleCalculator) jaxbUnmarshaller.unmarshal(file);
    }

    private static void saveResultToFile(SimpleCalculatorOutput result) throws JAXBException {
        File file = new File(OUTPUT_FILE);
        JAXBContext jaxbContext = JAXBContext.newInstance(SimpleCalculatorOutput.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(result, file);
    }
}
