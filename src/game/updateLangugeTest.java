package game;

import static org.junit.jupiter.api.Assertions.*;

class updateLangugeTest {

    @org.junit.jupiter.api.Test
    void updateLanguage() {
        Language language = new Language();

        assertEquals("options", language.getLanguageValue("options"));
    }
}