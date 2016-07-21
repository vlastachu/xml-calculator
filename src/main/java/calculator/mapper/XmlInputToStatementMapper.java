package calculator.mapper;

import calculator.impl1recursion.model.Operand;
import calculator.impl1recursion.model.Statement;
import calculator.impl1recursion.model.operation.Addition;
import calculator.impl1recursion.model.operation.Division;
import calculator.impl1recursion.model.operation.Multiplication;
import calculator.impl1recursion.model.operation.Subtraction;
import calculator.model.input.SimpleCalculator;
import calculator.model.input.Term;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by MStepachev on 21.07.2016.
 */
public class XmlInputToStatementMapper {

    private static Map<String, Class<?>> STATEMENT_TYPES = new HashMap<String, Class<?>>() {{
        put("SUM", Addition.class);
        put("DIV", Division.class);
        put("SUB", Subtraction.class);
        put("MUL", Multiplication.class);
    }};

    private int LEFT_OPERAND = 0;
    private int RIGHT_OPERAND = 1;

    public List<Statement> map(SimpleCalculator simpleCalculator) {
        List<Statement> statements = new ArrayList<Statement>();
        List<SimpleCalculator.Expressions.Expression> expressions = simpleCalculator.getExpressions().getExpression();

        for (SimpleCalculator.Expressions.Expression expression : expressions) {
            statements.add(rootElement(expression.getOperation()));
        }

        return statements;
    }

    private Statement rootElement(Term operation) {
        Statement left = leftOperandResolver(operation);
        Statement right = rightOperandResolver(operation);

        return TypeFactory.instance(
                operation.getOperationType(),
                left,
                right
        );
    }

    //TODO need to fix duplicate code
    private Statement leftOperandResolver(Term operation) {
        if (operation.getArg().size() == 2) {
            return new Operand(operation.getArg().get(LEFT_OPERAND).doubleValue());
        }

        if (operation.getArg1() != null) {
            return new Operand(operation.getArg1().doubleValue());
        }

        if (operation.getOperation1() != null) {
            return rootElement(operation.getOperation1());
        }

        if (operation.getOperation().size() == 2) {
            return rootElement(operation.getOperation().get(LEFT_OPERAND));
        }

        throw new RuntimeException("Cannot find left branch.");
    }

    private Statement rightOperandResolver(Term operation) {
        if (operation.getArg().size() == 2) {
            return new Operand(operation.getArg().get(RIGHT_OPERAND).doubleValue());
        }

        if (operation.getArg2() != null) {
            return new Operand(operation.getArg2().doubleValue());
        }

        if (operation.getOperation2() != null) {
            return rootElement(operation.getOperation2());
        }

        if (operation.getOperation().size() == 2) {
            return rootElement(operation.getOperation().get(RIGHT_OPERAND));
        }

        throw new RuntimeException("Cannot find right branch.");
    }

    private static class TypeFactory {
        public static Statement instance(String operationType, Statement stmLeft, Statement stmRight) {
            Statement instance = null;

            try {
                instance = (Statement) STATEMENT_TYPES
                        .get(operationType)
                        .getConstructor(Statement.class, Statement.class)
                        .newInstance(stmLeft, stmRight);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            return instance;
        }
    }
}
