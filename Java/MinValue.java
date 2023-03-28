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

public class MinValue {
    public static Double findMinValues(Map<String, List<Double>> map) {
        double min = Double.MAX_VALUE;
        for (var entry : map.entrySet()) {
            List<Double> list = entry.getValue();
            if(list != null && !list.isEmpty()){
                for(double value : list) {
                    if(value < min)
                        min = value;
                }
            }
        }
        return min;
    }
}