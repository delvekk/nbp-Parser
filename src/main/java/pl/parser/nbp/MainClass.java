package pl.parser.nbp;

import pl.parser.nbp.actionHandler.ProgramStarter;
import pl.parser.nbp.domain.CurrencyExchangeTable;
import pl.parser.nbp.domain.Position;
import pl.parser.nbp.mappers.CurrencyExchangeTableXMLToObject;
import pl.parser.nbp.services.*;
import pl.parser.nbp.utilities.Calculator;
import pl.parser.nbp.utilities.Converter;
import pl.parser.nbp.utilities.DatesHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        try{
            LocalDate startDate = LocalDate.parse(args[1]);
            LocalDate endDate = LocalDate.parse(args[2]);
            String currencyCode = args[0];
            ProgramStarter programStarter = new ProgramStarter(startDate, endDate, currencyCode);
            programStarter.startProgram();
        } catch (DateTimeParseException e) {
            System.out.println("Wrong 1 or more arguments. Try again");
        }
    }
}
