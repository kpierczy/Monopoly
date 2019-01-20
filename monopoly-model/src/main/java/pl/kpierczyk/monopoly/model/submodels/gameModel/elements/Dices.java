package pl.kpierczyk.monopoly.model.submodels.gameModel.elements;

import java.util.Random;

/**
 * Class representing couple od dices used in the Monopoly.
 * Dices object covers information about last rolled numbers
 * and number of rolled "doubles".
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class Dices{

    /** Number of doubles rolled to make roll() return true.*/
    private final int doublesToJail = 3;

    /** Number rolled on the first dice.*/
    private int first;

    /** Number rolled on the second dice.*/
    private int second;

    /** Number of rolled doubles since last reset.*/
    private int doubles;


    /**
     * Initializes dices couple with 0 values.
     */
    public Dices(){
        first = 0;
        second = 0;
        doubles = 0;
    }

    /**
     * Returns first rolled number.
     * 
     * @return first rolled number.
     */
    public int getFirst() {
        return first;
    }


    /**
     * Returns second rolled number.
     * 
     * @return second rolled number.
     */
    public int getSecond() {
        return second;
    }


    /**
     * Returns number of doubles rolled since the
     * last reset.
     * 
     * @return number of doubles rolled since the last reset.
     */
    public int getDoubles() {
        return doubles;
    }

    public boolean isDouble(){
        if(first == second)
            return true;
        else
            return false;
    }




    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    /**
     * Symulates random dice rolling.
     * Checks if double rolled.
     */
    public boolean roll(){
        Random roller = new Random();
        first =  roller.nextInt(6) + 1;
        second =  roller.nextInt(6) + 1;
        if(first == second)
            doubles++;

        if(doubles >= doublesToJail)
            return true;
        else
            return false;
    }


    /**
     * Reset numbers of rolled "doubles".
     */
    public void reset(){
        doubles = 0;
    }

}