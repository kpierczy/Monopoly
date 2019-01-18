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

    /** Amount of cash player posseses.*/
    private int cash;

    /** Amount of cards "get out of jail possesed by player."*/
    private int outOfJailNumber;

    /**
     * Default constructor initializing player's state.
     */
    public Player(int cash, int outOfJailNumber){
        this.cash = cash;
        this.outOfJailNumber = outOfJailNumber;
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




    



    /********************************/
    /*           Utilities          */
    /********************************/


}