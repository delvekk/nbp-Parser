package pl.parser.nbp.services;

import pl.parser.nbp.domain.CurrencyExchangeTable;
import pl.parser.nbp.mappers.CurrencyExchangeTableXMLToObject;
import pl.parser.nbp.utilities.DatesHandler;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CurrencyExchangeTableServiceImpl implements CurrencyExchangeTableService {

    private CurrencyExchangeTableXMLToObject xmlToObject;
    private DatesHandler datesHandler;
    private DirFileService dirFileService;

    public CurrencyExchangeTableServiceImpl(CurrencyExchangeTableXMLToObject xmlToObject, DatesHandler datesHandler, DirFileService dirFileService) {
        this.xmlToObject = xmlToObject;
        this.datesHandler = datesHandler;
        this.dirFileService = dirFileService;
    }

    @Override
    public List<CurrencyExchangeTable> getAllInRange(LocalDate start, LocalDate end) throws IOException {
        List<CurrencyExchangeTable> currencyExchangeTableList = new ArrayList<>();
        List<LocalDate> datesInRage = datesHandler.getAllDatesInRange(start, end);
        List<String> dateStrings = datesHandler.createDateStrings(datesInRage);
        Set<String> stringUrls = dirFileService.createUrlStringsFromExistingTablesInFile(dateStrings);
        for(String urlString : stringUrls) {
            URL url = new URL(urlString);
            try {
                CurrencyExchangeTable currencyExchangeTable = xmlToObject.XmlToObject(url.openStream());
                currencyExchangeTableList.add(currencyExchangeTable);
            } catch (JAXBException e) {
                System.out.println("Error while unmarshalling");
            }
        }
        return currencyExchangeTableList;
    }
}
