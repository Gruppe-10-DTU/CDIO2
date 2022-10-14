package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;


public class Languish {

    private HashMap<String, String> languageValues;

    public Languish() {
        Path path = Paths.get("/Users/sandie/Documents/DTU/CDIO2/src/game/english.txt");
        languageValues = new HashMap<String, String>();

        try {
            List<String> lines = Files.readAllLines(path);
            for(String line : lines) {
                if (!line.trim().isEmpty()) {
                    String[] keyValuePair = line.split("=");
                    languageValues.put(keyValuePair[0], keyValuePair[1]);
                }
            }
        } catch (IOException e) {

        }
    }

    public String getLanguageValue(String key) {
        return languageValues.get(key);
    }

    public static void main(String Args[]) {
        System.out.println("Program starts here");

        Languish currentLanguish = new Languish();
        System.out.println(currentLanguish.getLanguageValue("field2"));



    }

}
