package pl.kpierczyk.monopoly.model.submodels.gameModel.elements;

/**
 * Class representing Monopoly's player. It cointains all vital information
 * for the game to be performed like amount of cash, number of owned
 * "Get out from jail" cards etc.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class Player{


    public enum Counter{
        counter_1, counter_2, counter_3
    }

    /** Player's name.*/
    private final String name;

    /** Player's counter on the board.*/
    private Counter counter;

    /** Amount of cash player posseses.*/
    private int cash;

    /** Amount of cards "get out of jail possesed by player."*/
    private int outOfJailNumber;

    /** Number of turn player has spent in the Jail.*/
    private int turnsInJail;


    /**
     * Default constructor initializing player's state.
     */
    public Player(String name,int cash, int outOfJailNumber, Counter counter){
        this.name = name;
        this.cash = cash;
        this.outOfJailNumber = outOfJailNumber;
        this.counter = counter;
    }

    /**
     * Returns player's name.
     * 
     * @return player's name.
     */
    public String getName() {
        return name;
    }


    /**
     * Returns player's counter.
     * 
     * @return player counter.
     */
    public Counter getCounter() {
        return counter;
    }

    /**
     * Returns amount of player's cash.
     * 
     * @return amount of player's cash.
     */
    public int getCash() {
        return cash;
    }

    /**
     * Returns number of cards "Get out of jail"
     * that player posseses.
     * 
     * @return number of cards "Get out of jail" that player posseses.
     */
    public int getOutOfJailNumber() {
        return outOfJailNumber;
    }


    /**
     * Returns number of turns player has spent in the Jail.
     * 
     * @return number of turns player has spent in the Jail.
     */
    public int getTurnsInJail() {
        return turnsInJail;
    }



    



    /********************************/
    /*           Utilities          */
    /********************************/

    /**
     * Gives specified amount of cash to the player.
     * 
     * @param cash
     * @return true
     */
    public boolean give(int cash){
        this.cash += cash;
        return true;
    }

    /**
     * Take away specified amount of cash from player.
     * Returns false if player has to few cash.
     * 
     * @param cash
     * @return false if player has to few cash.
     */
    public boolean takeAway(int cash){
        if(this.cash >= cash){
            this.cash -= cash;
            return true;
        }
        else return false;
    }


}