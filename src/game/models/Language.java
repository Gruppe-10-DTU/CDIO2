package game.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Language {

    private HashMap<String, String> languageValues;

    public Language() {
        updateLanguage("src/game/english.txt");
    }
    public Language(String language){
        String target;
        switch (language){
            case "English":
                target = "src/game/english.txt";
                break;
            case "Danish":
                target = "src/game/danish.txt";
                break;
            default:
                target = "src/game/english.txt";
                break;
        }
        updateLanguage(target);
    }

    //Returns the value to the requestes key, kan add extra string if the value includes {0}
    public String getLanguageValue(String key, String...txt) {
        String value = languageValues.get(key);
        value = value.replace("{0}", txt[0]);
        return value;
    }
    public String getLanguageValue(String key) {
        return languageValues.get(key);
    }

    //Updates the language
    public void updateLanguage(String language) {
        String target;
        switch (language){
            case "English":
                target = "src/game/english.txt";
                break;
            case "Danish":
                target = "src/game/danish.txt";
                break;
            default:
                target = "src/game/english.txt";
                break;
        }
        Path path = Paths.get(target);
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
}
