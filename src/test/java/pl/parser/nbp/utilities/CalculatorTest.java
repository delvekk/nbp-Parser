package pl.parser.nbp.utilities;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.domain.Position;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Test
    public void calculatePurchaseAverage() {
    }

    @Test
    public void calculateStandardDeviation() {
        Position position1 = new Position();
        position1.setSellingRate(7d);

        Position position2 = new Position();
        position2.setSellingRate(4d);

        Position position3 = new Position();
        position3.setSellingRate(-2d);

        var positions = List.of(position1, position2, position3);

        double value = Calculator.calculateStandardDeviation(positions);
        assertEquals(Math.sqrt(14), value, 4);

    }
}