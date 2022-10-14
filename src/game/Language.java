package game;

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

    //Returns the value to the requestes key, kan add extra string if the value includes {0}
    public String getLanguageValue(String key, String...txt) {
        if(txt.length>0) {
            String value = languageValues.get(key);
            value = value.replace("{0}", txt[0]);
            return value;
        } else {
            return languageValues.get(key);
        }
    }

    //Updates the language
    public void updateLanguage(String language) {
        Path path = Paths.get(language);
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

    public static void main(String Args[]) {
        System.out.println("Program starts here");

        Language currentLanguage = new Language();
        System.out.println(currentLanguage.getLanguageValue("field2", "500"));
        //currentLanguage.updateLanguage("src/game/danish.txt");
        //System.out.println(currentLanguage.getLanguageValue("field2"));

    }

}
