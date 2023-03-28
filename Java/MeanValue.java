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