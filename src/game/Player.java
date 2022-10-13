package game;

public class Player {

    private final Balance balance = new Balance();
    private String identifier;

    //Constructor
    public Player(String name){
        identifier = name;
    }

    // getter
    public int getBalance() {
        return balance.getBalance();
    }
    // setter
    public void setBalance(int newBalance) {balance.setBalance(balance.getBalance() + newBalance);
    }

    // getter
    public String getIdentifier() {
        return identifier;
    }
    // setter
    public void setIdentifier(String newIdentifier) {
        this.identifier = newIdentifier;
    }
}
