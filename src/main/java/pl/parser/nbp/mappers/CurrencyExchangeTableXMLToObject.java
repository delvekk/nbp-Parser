package pl.parser.nbp.mappers;

import pl.parser.nbp.domain.CurrencyExchangeTable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class CurrencyExchangeTableXMLToObject {

    public CurrencyExchangeTable XmlToOjbect(InputStream xmlStream) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CurrencyExchangeTable.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (CurrencyExchangeTable) jaxbUnmarshaller.unmarshal(xmlStream);

    }
}
