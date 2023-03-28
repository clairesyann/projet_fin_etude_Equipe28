import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class MaxValue {
    public static Double findMaxValues(Map<String, List<Double>> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
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