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


public class Main_calcul {
     private static void saveResultsToFile(String filename, double max, double min, double mean, double stdDev) {
        try {
            File file = new File(filename);
            file.createNewFile();
            java.io.FileWriter writer = new java.io.FileWriter(file);
            writer.write("Maximum value: " + max + "\n");
            writer.write("Minimum value: " + min + "\n");
            writer.write("Mean value: " + mean + "\n");
            writer.write("Standard deviation: " + stdDev + "\n");
            writer.close();
            //System.out.println("Results saved to file " + filename);
        } catch (IOException e) {
            System.out.println("Error saving results to file " + filename + ": " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        // read map from file
        Map<String, List<Double>> map = readMapFromFile("map.txt");

        //System.out.println("Map: " + map);

        // compute and print statistics
        double max = MaxValue.findMaxValues(map);
        double min = MinValue.findMinValues(map);
        double mean = MeanValue.findMeanValues(map);
        double stdDev = StandardDeviation.findStandardDeviationValues(map);

        //System.out.println("Maximum value: " + max);
        //System.out.println("Minimum value: " + min);
        //System.out.println("Mean value: " + mean);
        //System.out.println("Standard deviation: " + stdDev);
        saveResultsToFile("result_java.txt", max, min, mean, stdDev);
    }

    private static Map<String, List<Double>> readMapFromFile(String filename) {
        Map<String, List<Double>> map =  new HashMap<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String key = parts[0];
                List<Double> values = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    values.add(Double.parseDouble(parts[i]));
                }
                map.put(key, values);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return map;
    }
}
