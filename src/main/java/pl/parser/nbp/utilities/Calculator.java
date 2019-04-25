package pl.parser.nbp.utilities;
import pl.parser.nbp.domain.Position;

import java.util.List;

public class Calculator {

    public static Double calculatePurchaseAverage(List<Position> positionsList) {
        return positionsList.stream().mapToDouble(Position::getPurchasePrice).average().getAsDouble();
    }

    public static Double calculateStandardDeviation(List<Position> positionList) {
        double meanAvg =  positionList.stream().mapToDouble(Position::getSellingRate).average().getAsDouble();;
        double temp = positionList.stream().mapToDouble(position -> (position.getSellingRate()-meanAvg)*(position.getSellingRate()-meanAvg)).sum();
        double variance = temp/positionList.size();
        return Math.sqrt(variance);
    }


}
