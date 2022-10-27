package Test;

import game.controllers.GameController;
import game.models.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

class turnTest {

    @Test
    @DisplayName("Turn test")
    void turn() {
        try {
            GameController gc = new GameController();
            Player[] players = new Player[2];
            players[0] = new Player("player 1");
            players[1] = new Player("player 2");
            testDiceHolder diceHolder = new testDiceHolder();
            Class c = gc.getClass();
            Field fieldPlayers = c.getDeclaredField("players");
            fieldPlayers.setAccessible(true);
            fieldPlayers.set(gc, players);

            Field fieldDice = c.getDeclaredField("diceHolder");
            fieldDice.setAccessible(true);
            fieldDice.set(gc,diceHolder);


            //Player 1
            assertEquals(0, gc.getTurnCounter());
            players[gc.getTurnCounter() % 2].setBalance(1999);
            diceHolder.setSum(12);
            gc.turn();
            //Player 2
            diceHolder.setSum(10);
            players[gc.getTurnCounter() % 2].setBalance(1);
            assertEquals(1,gc.getTurnCounter());
            gc.turn();
            //Player 2
            diceHolder.setSum(10);
            players[gc.getTurnCounter() % 2].setBalance(1);
            assertEquals(1,gc.getTurnCounter());
            gc.turn();
            //Player 2 cause he rolled 10
            diceHolder.setSum(3);
            players[gc.getTurnCounter() % 2].setBalance(1);
            assertEquals(1,gc.getTurnCounter());
            gc.turn();
            //Player 1
            diceHolder.setSum(3);
            players[gc.getTurnCounter() % 2].setBalance(1);
            assertEquals(2,gc.getTurnCounter());
            //Player 1 because he won
            gc.turn();
            assertEquals(2,gc.getTurnCounter());

        }catch (Exception e){
            System.out.println("Oops: " + e);
        }

    }
}