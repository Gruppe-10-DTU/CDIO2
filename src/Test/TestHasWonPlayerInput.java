package Test;

import game.controllers.GameController;
import game.models.Player;
import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;

class TestHasWonPlayerInput {
    @org.junit.jupiter.api.Test
    void hasWon() {
        try {
            //Instanciate the relevant classes
            GameController gc = new GameController();
            Player[] players = new Player[2];
            players[0] = new Player("Test");
            //Get the class
            Class c = gc.getClass();

            //Get the private field players
            Field fieldPlayers = c.getDeclaredField("players");
            fieldPlayers.setAccessible(true);
            //Insert our own player array instead of the one in the game.
            fieldPlayers.set(gc, players);
            assertFalse(gc.hasWon());

            players[0].setBalance(1999);
            assertFalse(gc.hasWon());

            players[0].setBalance(1);
            assertTrue(gc.hasWon());
        }catch (Exception e){
            System.out.println("ERROR!");
        }
    }
}