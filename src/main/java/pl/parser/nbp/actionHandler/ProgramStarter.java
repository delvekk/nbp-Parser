package pl.parser.nbp.actionHandler;

import pl.parser.nbp.domain.CurrencyExchangeTable;
import pl.parser.nbp.domain.Position;
import pl.parser.nbp.mappers.CurrencyExchangeTableXMLToObject;
import pl.parser.nbp.services.*;
import pl.parser.nbp.utilities.Calculator;
import pl.parser.nbp.utilities.Converter;
import pl.parser.nbp.utilities.DatesHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class ProgramStarter {

    private LocalDate startDate;
    private LocalDate endDate;
    private String currencyCode;
    private CurrencyExchangeTableXMLToObject xmlToObject;
    private DatesHandler datesHandler = new DatesHandler();
    private DirFileService dirFileService;
    private CurrencyExchangeTableService exchangeTableService;
    private PositionService positionService;

    public ProgramStarter(LocalDate startDate, LocalDate endDate, String currencyCode) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.currencyCode = currencyCode;
    }

    public void startProgram() {
        loadObjects();
        try{
            List<CurrencyExchangeTable> currencyExchangeTableList = exchangeTableService.getAllInRange(startDate, endDate);
            List<Position> positionList = positionService.getPositionFromTableForCurrencyCode(currencyExchangeTableList, currencyCode);
            double purchaseAverage = Calculator.calculatePurchaseAverage(Converter.convertPurchaseStringToDouble(positionList));
            double sellingStandardDeviation = Calculator.calculateStandardDeviation(Converter.convertSellingStringToDouble(positionList));
            System.out.printf("%.4f\n", purchaseAverage);
            System.out.printf("%.4f", sellingStandardDeviation);
        } catch (IOException e) {
            System.out.println("Error while getting data, try again");
        } catch (NoSuchElementException e) {
            System.out.println("Elements not found");
        }
    }

    private void loadObjects(){
        xmlToObject = new CurrencyExchangeTableXMLToObject();
        datesHandler = new DatesHandler();
        dirFileService = new DirFileServiceImpl();
        exchangeTableService = new CurrencyExchangeTableServiceImpl(xmlToObject, datesHandler, dirFileService);
        positionService = new PositionServiceImpl();
    }
}
