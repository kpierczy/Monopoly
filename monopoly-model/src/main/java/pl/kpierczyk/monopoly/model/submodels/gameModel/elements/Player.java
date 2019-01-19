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


    public final int HAT = 1;
    public final int SHIP = 2;
    public final int CAR = 3;
    public final int DOG = 4;
    public final int SHOE = 5;
    public final int WHEELBARROW = 6;

    /** Player's name.*/
    private final String name;

    /** ID of the field that player stands on.*/
    private String positionID;

    /** Player's counter on the board.*/
    private int counter;

    /** Amount of cash player posseses.*/
    private int cash;

    /** Amount of cards "get out of jail possesed by player."*/
    private int outOfJailNumber;

    /** Number of turn player has spent in the Jail.*/
    private int turnsInJail;

    /** States if player is in jail.*/
    private boolean inJail;


    /**
     * Default constructor initializing player's state.
     */
    public Player(String name, String positionID, int cash,
                  int outOfJailNumber, int counter, boolean inJail){
        this.name = name;
        this.positionID = positionID;
        this.cash = cash;
        this.outOfJailNumber = outOfJailNumber;
        this.counter = counter;
        this.inJail = inJail;
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
     * Returns position ID.
     * 
     * @return the positionID
     */
    public String getPositionID() {
        return positionID;
    }

    /**
     * Returns player's counter.
     * 
     * @return player counter.
     */
    public int getCounter() {
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


    /**
     * @return the inJail
     */
    public boolean isInJail() {
        return inJail;
    }

    /**
     * @param positionID the positionID to set
     */
    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }


    /**
     * @param inJail the inJail to set
     */
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
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