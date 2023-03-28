// fichier MapToFile.java
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

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