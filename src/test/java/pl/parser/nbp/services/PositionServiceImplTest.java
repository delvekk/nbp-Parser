package pl.parser.nbp.services;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.domain.CurrencyExchangeTable;
import pl.parser.nbp.domain.Position;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PositionServiceImplTest {

    private PositionServiceImpl positionServiceImpl;

    @Before
    public void setUp() {
        positionServiceImpl = new PositionServiceImpl();
    }

    @Test
    public void testGettingPositionFromTableForCurrencyCode() {
        Position position = new Position();
        position.setCurrencyName("EURO");
        position.setCurrencyCode("EUR");

        List<Position> positionList = List.of(position);

        CurrencyExchangeTable currencyExchangeTable = new CurrencyExchangeTable();
        currencyExchangeTable.setPositions(positionList);
        currencyExchangeTable.setPublicationDate(Date.valueOf("2019-01-02"));

        List<CurrencyExchangeTable> currencyExchangeTables = List.of(currencyExchangeTable);

        List<Position> results = positionServiceImpl.getPositionFromTableForCurrencyCode(currencyExchangeTables, "EUR");

        assertEquals(results.size(), 1);

    }
}