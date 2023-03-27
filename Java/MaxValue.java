import java.util.Map;
import java.util.List;

public class MaxValue {
    public static Double findMaxValues(Map<String, List<Double>> map) {
        double max = Double.MIN_VALUE;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            List<Double> list = entry.getValue();
            if(list != null && !list.isEmpty()){
                for(double value : list) {
                    if(value > max)
                        max = value;
                }
            }
        }
        return max;
    }
}