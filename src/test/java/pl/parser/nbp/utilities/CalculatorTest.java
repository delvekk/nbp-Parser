package pl.parser.nbp.utilities;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calculatePurchaseAverage() {
    }

    @Test
    public void testCalculateStandardDeviation() {
        // given
        var positions = List.of(7.0, 4.0, -2.0);

        // when
        double value = Calculator.calculateStandardDeviation(positions);

        // then
        assertEquals(Math.sqrt(14), value, 4);
    }
}