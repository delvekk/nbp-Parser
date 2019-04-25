package pl.parser.nbp.services;

import pl.parser.nbp.domain.CurrencyExchangeTable;
import pl.parser.nbp.domain.Position;

import java.util.List;

public interface PositionService {

    List<Position> getPositionFromTableForCurrencyCode(List<CurrencyExchangeTable> currencyExchangeTableList,  String currencyCode);
}
