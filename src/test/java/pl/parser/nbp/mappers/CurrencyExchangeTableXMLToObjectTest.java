package pl.parser.nbp.mappers;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.domain.CurrencyExchangeTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;

import static org.junit.Assert.*;

public class CurrencyExchangeTableXMLToObjectTest {

    InputStream inputStream;
    CurrencyExchangeTableXMLToObject xmlToObject;

    @Before
    public void setUp() {
        xmlToObject = new CurrencyExchangeTableXMLToObject();

    }

    @Test
    public void testXmlToObject() throws Exception {
            // given
            inputStream = new FileInputStream(new File("src/test/resources/currencyTable.xml"));

            // when
            CurrencyExchangeTable exchangeTable = xmlToObject.XmlToObject(inputStream);

            // then
            assertNotNull(exchangeTable);
            assertEquals(Date.valueOf("2007-04-13"), exchangeTable.getPublicationDate());
            assertEquals(14, exchangeTable.getPositions().size());
    }
}