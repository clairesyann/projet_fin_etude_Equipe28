import java.util.Map;
import java.util.List;

public class MeanValue {
    public static Double findMeanValues(Map<String, List<Double>> map) {
        int count = 0;
        double sum = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            List<Double> list = entry.getValue();
            if(list != null && !list.isEmpty()){
                for(double value : list) {
                    sum += value;
                    count++;
                }
            }
        }
        if(count==0) return null;
        return sum / count;
    }
}
