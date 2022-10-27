package test;

import game.models.Player;
import static org.junit.jupiter.api.Assertions.*;


public class TestBalance {
    Player[] players = new Player[1];

    @org.junit.jupiter.api.Test
    public void addToBalance(){
        players[0] = new Player("test");
        players[0].setBalance(1000);
        assertEquals(2000, players[0].getBalance());
    }

    @org.junit.jupiter.api.Test
    public void removeFromBalance(){
        players[0] = new Player("test");
        players[0].setBalance(-1000);
        assertEquals(0, players[0].getBalance());
    }

    @org.junit.jupiter.api.Test
    public void negativeBalance(){
        players[0] = new Player("test");
        players[0].setBalance(-1001);
        assertEquals(0, players[0].getBalance());
    }

}
