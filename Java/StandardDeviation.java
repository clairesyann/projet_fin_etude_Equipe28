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


public class StandardDeviation {
    public static Double findStandardDeviationValues(Map<String, List<Double>> map) {
        if(map == null || map.isEmpty()) return null;
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
        double mean = sum / count;
        double temp = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            List<Double> list = entry.getValue();
            if(list != null && !list.isEmpty()){
                for(double value : list) {
                    temp += (mean-value)*(mean-value);
                }
            }
        }
        return Math.sqrt(temp/(count-1));
    }
}