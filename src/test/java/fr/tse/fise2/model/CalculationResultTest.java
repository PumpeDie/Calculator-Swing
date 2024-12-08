package fr.tse.fise2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculationResultTest {

    @Test
    public void testFormattedResult() {
        CalculationResult result = new CalculationResult(3.0, "3 + 0");
        assertEquals("3", result.getFormattedResult());
    }

    @Test
    public void testNonIntegerFormattedResult() {
        CalculationResult result = new CalculationResult(3.5, "7 / 2");
        assertEquals("3.5", result.getFormattedResult());
    }
}
