package pl.parser.nbp.utilities;

import pl.parser.nbp.domain.Position;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<Double> convertPurchaseStringToDouble(List<Position> positionList) {
        return positionList.stream().map(position -> {
            String purchasePrice = position.getPurchasePrice().replaceAll(",", ".");
            return Double.parseDouble(purchasePrice);
        }).collect(Collectors.toList());
    }

    public static List<Double> convertSellingStringToDouble(List<Position> positionList) {
        return positionList.stream().map(position -> {
            String sellingPrice = position.getSellingRate().replaceAll(",", ".");
            return Double.parseDouble(sellingPrice);
        }).collect(Collectors.toList());
    }
}
