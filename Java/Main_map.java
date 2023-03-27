import java.util.List;
import java.util.Map;


import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;


import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Map<String, List<Double>> randomMap = RandomMap.generateRandomMap(10001, 20);
        System.out.println(randomMap);

        MapToFile.saveMapToFile(randomMap);

        //assert randomMap != null;
        //Double max = MaxValue.findMaxValues(randomMap);
        ///System.out.println(max);

        //Double min = MinValue.findMinValues(randomMap);
        //System.out.println(min);

        //Double mean = MeanValue.findMeanValues(randomMap);
        //System.out.println(mean);

        //Double standardDeviation = StandardDeviation.findStandardDeviationValues(randomMap);
        //System.out.println(standardDeviation);
    }
}


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

public class MapToFile {
    public static void saveMapToFile(Map<String, List<Double>> map) {
        try {
            FileWriter writer = new FileWriter("map.txt");
            for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
                writer.write(entry.getKey() + ": ");
                for (Double value : entry.getValue()) {
                    writer.write(value + " ");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}