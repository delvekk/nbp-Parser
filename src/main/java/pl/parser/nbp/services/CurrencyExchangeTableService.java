package pl.parser.nbp.services;

import pl.parser.nbp.domain.CurrencyExchangeTable;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface CurrencyExchangeTableService {

    List<CurrencyExchangeTable> getAllInRange(LocalDate start, LocalDate end) throws IOException;

}
