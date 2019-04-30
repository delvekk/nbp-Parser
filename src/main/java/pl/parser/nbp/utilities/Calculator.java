package pl.parser.nbp.utilities;
import java.util.List;
import java.util.stream.DoubleStream;

public class Calculator {

    public static Double calculatePurchaseAverage(List<Double> purchaseList) {
        return DoubleStream.of(purchaseList.stream().mapToDouble(price -> price).toArray()).average().getAsDouble();
    }

    public static Double calculateStandardDeviation(List<Double> sellingList) {
        double meanAvg =  sellingList.stream().mapToDouble(price -> price ).average().getAsDouble();
        double temp = sellingList.stream().mapToDouble(sellingRate -> ((sellingRate-meanAvg)*(sellingRate-meanAvg))).sum();
        double variance = temp/sellingList.size();
        return Math.sqrt(variance);
    }


}
