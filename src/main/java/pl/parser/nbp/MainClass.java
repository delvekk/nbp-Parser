package pl.parser.nbp;

import pl.parser.nbp.mappers.CurrencyExchangeTableXMLToObject;
import pl.parser.nbp.services.CurrencyExchangeTableService;
import pl.parser.nbp.services.CurrencyExchangeTableServiceImpl;
import pl.parser.nbp.services.DirFileServiceImpl;
import pl.parser.nbp.services.DirFileService;
import pl.parser.nbp.utilities.DatesHandler;

import java.io.IOException;
import java.time.LocalDate;

public class MainClass {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.parse(args[2]);
        LocalDate endDate = LocalDate.parse(args[3]);
        CurrencyExchangeTableXMLToObject xmlToObject = new CurrencyExchangeTableXMLToObject();
        DatesHandler datesHandler = new DatesHandler();
        DirFileService dirFileService = new DirFileServiceImpl();
        CurrencyExchangeTableService exchangeTableService = new CurrencyExchangeTableServiceImpl(xmlToObject, datesHandler, dirFileService);
        try{
            exchangeTableService.getAllInRange(startDate, endDate);
        } catch (IOException e) {
            System.out.println("Error while getting data, try again");
        }

    }
}
