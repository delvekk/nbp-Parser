package pl.parser.nbp.services;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.domain.CurrencyExchangeTable;
import pl.parser.nbp.mappers.CurrencyExchangeTableXMLToObject;
import pl.parser.nbp.utilities.DatesHandler;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class CurrencyExchangeTableServiceImplTest {

    DirFileService dirFileService;
    CurrencyExchangeTableService currencyExchangeTableService;
    CurrencyExchangeTableXMLToObject xmlToObject;
    DatesHandler datesHandler;

    @Before
    public void setUp() {
        xmlToObject = new CurrencyExchangeTableXMLToObject();
        datesHandler = new DatesHandler();
        dirFileService = new DirFileServiceImpl();
        currencyExchangeTableService = new CurrencyExchangeTableServiceImpl(xmlToObject, datesHandler, dirFileService);
    }

    @Test
    public void testgettingCurrencyExcahngeTableListInDateRange() throws Exception{
        // given
        LocalDate startDate = LocalDate.parse("2019-01-02");
        LocalDate endDate = LocalDate.parse("2019-01-03");

        // when
        List<CurrencyExchangeTable> results = currencyExchangeTableService.getAllInRange(startDate, endDate);

        // then
        assertEquals(2, results.size());
    }
}