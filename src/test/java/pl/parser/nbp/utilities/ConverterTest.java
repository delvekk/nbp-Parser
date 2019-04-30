package pl.parser.nbp.utilities;

import org.junit.Test;
import pl.parser.nbp.domain.Position;

import java.util.List;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void testConvertPurchaseStringToDouble() {
        // given
        Position position = new Position();
        position.setPurchasePrice("1,2");

        Position position1 = new Position();
        position1.setPurchasePrice("5,7");

        List<Position> list = List.of(position, position1);

        // when
        List<Double> result = Converter.convertPurchaseStringToDouble(list);

        // then
        assertEquals(result.size(), 2);
    }

    @Test
    public void testConvertSellingStringToDouble() {
        // given
        Position position = new Position();
        position.setSellingRate("1,2");

        Position position1 = new Position();
        position1.setSellingRate("5,7");

        List<Position> list = List.of(position, position1);

        // when
        List<Double> result = Converter.convertSellingStringToDouble(list);

        // then
        assertEquals(result.size(), 2);
    }
}