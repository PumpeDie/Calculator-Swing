package fr.tse.fise2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorEngineTest {

    private CalculatorEngine engine;
    private static final double DELTA = 0.0001; // Pour les comparaisons de nombres décimaux

    @BeforeEach
    public void setUp() {
        engine = new CalculatorEngine();
    }

    @Test
    void testAdd() {
        assertEquals(8, engine.add(3, 5));    
    }

    @Test
    void testSubtract() {
        assertEquals(2, engine.subtract(7, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(15, engine.multiply(3, 5));
    }

    @Test
    void testDivide() throws CalculatorException {
        assertEquals(3, engine.divide(15, 5));
    }

    @Test
    public void testDivisionByZero() throws CalculatorException {
        assertThrows(CalculatorException.class, () -> engine.divide(5, 0));
    }

    @Test
    void testModulo() throws CalculatorException {
        assertEquals(1, engine.modulo(5, 2));
        assertThrows(CalculatorException.class, () -> engine.modulo(5, 0));
    }

    @Test
    void testGetLastResult() {
        engine.add(3, 5);
        assertEquals(8, engine.getLastResult());
    }

    @Test
    void testTrigonometricFunctions() throws CalculatorException {
        // Test sin
        assertEquals(0, engine.sin(0), DELTA);
        assertEquals(1, engine.sin(90), DELTA);
        
        // Test cos
        assertEquals(1, engine.cos(0), DELTA);
        assertEquals(0, engine.cos(90), DELTA);
        
        // Test tan
        assertEquals(0, engine.tan(0), DELTA);
        assertEquals(1, engine.tan(45), DELTA);
    }

    @Test
    void testLogarithms() throws CalculatorException {
        // Test ln
        assertEquals(0, engine.ln(1), DELTA);
        assertEquals(1, engine.ln(Math.E), DELTA);
        
        // Test log erreurs
        assertThrows(CalculatorException.class, () -> engine.ln(0));
        assertThrows(CalculatorException.class, () -> engine.ln(-1));
    }

    @Test
    void testPowersAndRoot() throws CalculatorException {
        // Test pow
        assertEquals(4, engine.pow(2, 2), DELTA);
        assertEquals(8, engine.pow(2, 3), DELTA);
        assertEquals(1, engine.pow(2, 0), DELTA);
        
        // Test sqrt
        assertEquals(2, engine.sqrt(4), DELTA);
        assertEquals(3, engine.sqrt(9), DELTA);
        
        // Test sqrt erreur
        assertThrows(CalculatorException.class, () -> engine.sqrt(-1));
    }

    @Test
    void testFactorial() throws CalculatorException {
        assertEquals(1, engine.factorial(0), DELTA);
        assertEquals(1, engine.factorial(1), DELTA);
        assertEquals(6, engine.factorial(3), DELTA);
        assertEquals(24, engine.factorial(4), DELTA);
        
        // Test erreur
        assertThrows(CalculatorException.class, () -> engine.factorial(-1));
    }

    @Test
    void testLastResult() throws CalculatorException {
        engine.sin(90);
        assertEquals(1, engine.getLastResult(), DELTA);
        
        engine.pow(2, 3);
        assertEquals(8, engine.getLastResult(), DELTA);
    }
}
