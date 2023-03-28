// fichier Main_map.java
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Main_map {
    public static void main(String[] args) {
        //System.out.println("Main_map execute debut");

        Map<String, List<Double>> randomMap = RandomMap.generateRandomMap(10001, 20);

        //System.out.println(randomMap);

        MapToFile.saveMapToFile(randomMap);
    }
}