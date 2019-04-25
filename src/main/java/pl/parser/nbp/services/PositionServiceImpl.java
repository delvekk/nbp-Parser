package pl.parser.nbp.services;

import pl.parser.nbp.domain.CurrencyExchangeTable;
import pl.parser.nbp.domain.Position;

import java.util.*;
import java.util.stream.Collectors;

public class PositionServiceImpl implements PositionService {

    @Override
    public List<Position> getPositionFromTableForCurrencyCode(List<CurrencyExchangeTable> currencyExchangeTableList, String currencyCode) {
//        List<Position> positions = new ArrayList<>();
//        currencyExchangeTableList.forEach(exchangeTable -> {
//            List<Position> tablePositions = exchangeTable.getPositions();
//            Optional<Position> optionalPosition = tablePositions.stream().filter(position -> position.getCurrencyCode().equals(currencyCode)).findFirst();
//            optionalPosition.ifPresent(positions::add);
//        });

        List<Position> positions = currencyExchangeTableList.stream().map(exchangeTable -> {
            List<Position> tablePositions = exchangeTable.getPositions();
            Optional<Position> optionalPosition = tablePositions.stream().filter(position -> position.getCurrencyCode().equals(currencyCode)).findFirst();
            return optionalPosition.orElseThrow();
        }).collect(Collectors.toList());
        return positions;
    }
}
