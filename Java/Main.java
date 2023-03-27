import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Map<String, List<Double>> randomMap = RandomMap.generateRandomMap(10001, 20);
        System.out.println(randomMap);

        assert randomMap != null;
        Double max = MaxValue.findMaxValues(randomMap);
        System.out.println(max);

        Double min = MinValue.findMinValues(randomMap);
        System.out.println(min);

        Double mean = MeanValue.findMeanValues(randomMap);
        System.out.println(mean);

        Double standardDeviation = StandardDeviation.findStandardDeviationValues(randomMap);
        System.out.println(standardDeviation);
    }
}