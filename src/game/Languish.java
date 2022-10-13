package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


public class Languish {

    Path path = Paths.get("english.txt");
    HashMap<String, String> languageValues = new HashMap<String, String>();

    try {
        String[] lines = Files.readAllLines(path);
        for(String line : lines) {
            String[] keyValuePair = line.split("=");
            languageValues.put(keyValuePair[0], keyValuePair[1]);
        }
    } catch (IOException e) {

    }

    public static void main(String Args[]) {

    }

}
