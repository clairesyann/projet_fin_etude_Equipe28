import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class RandomMap {
    public static Map<String, List<Double>> generateRandomMap(int n, int m) {
        if(n <= 0 || m <= 0) return null;
        Random rand = new Random();
        Map<String, List<Double>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String key = "liste_"+ Integer.toString(rand.nextInt(n));
            List<Double> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(rand.nextDouble());
            }
            map.put(key, list);
        }
        return map;
    }
}