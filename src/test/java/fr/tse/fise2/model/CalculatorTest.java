package fr.tse.fise2.model;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testEvaluateExpression() throws CalculatorException {
        CalculationResult result = calculator.evaluateExpression("3+5x2");
        assertEquals(13, result.getResult());
    }

    @Test
    public void testMultiplyNegative() throws CalculatorException {
        CalculationResult result = calculator.evaluateExpression("3x(-5)");
        assertEquals(-15, result.getResult());
    }

    @Test
    public void testDivisionByZero() throws CalculatorException {
        assertThrows(CalculatorException.class, () -> {
            calculator.evaluateExpression("10÷0");
        });
    }
    @Test
    public void testSimplePercentage() throws CalculatorException {
        // Test d'un pourcentage simple
        CalculationResult result = calculator.evaluateExpression("4%");
        assertEquals(0.04, result.getResult());
    }

    @Test
    public void testModuloOperation() throws CalculatorException {
        // Test du modulo
        CalculationResult result = calculator.evaluateExpression("8mod3");
        assertEquals(2, result.getResult());
    }

    @Test
    public void testPercentageInExpression() throws CalculatorException {
        // Test d'un pourcentage dans une expression
        CalculationResult result = calculator.evaluateExpression("100+10%");
        assertEquals(100.1, result.getResult());
    }

    @Test
    public void testComplexExpression() throws CalculatorException {
        // Test d'une expression complexe
        CalculationResult result = calculator.evaluateExpression("2+3x4%");
        assertEquals(2.12, result.getResult());
    }

    @Test
    public void testParenthesesWithOperators() throws CalculatorException {
        // Test des expressions avec parenthèses
        CalculationResult result = calculator.evaluateExpression("(2-3)x4");
        assertEquals(-4, result.getResult());
    }
}
