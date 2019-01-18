package pl.kpierczyk.monopoly.model.submodels.gameModel.elements;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class representing stack of cards on the Monopoly's board.
 * During the game cards are drawn by players who visit special
 * "Chance" and "Deal" fields. 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class CardsStack{

    /** Number of cards on the stack.*/
    private final int size;

    /** Stack containing remaining cards on the stack.*/
    private ArrayList<Card> stack;

    /** Stack of drawn cards.*/
    private ArrayList<Card> greyvardStack;


    /**
     * Constructor initializing an empty stack of a specified
     * size.
     * 
     * @param   stackSize
     * @see     Card
     */
    public CardsStack(ArrayList<Card> stack){
        this.size = stack.size();
        //<--- WARNING -->
        //It can assign object that will be disappear in a while.
        //Not sure how java works.
        this.stack = stack;
        this.greyvardStack = new ArrayList<Card>(size);
    }

    /**
     * Returns size of the stack.
     * 
     * @return the size
     */
    public int getSize() {
        return size;
    }





    /********************************/
    /* Utilities */
    /********************************/

    /**
     * Returns true if the stack is empty.
     * 
     * @return  true if the stack is empty
     */
    public boolean empty(){
        if(stack.size() == 0)
            return true;
        else
            return false;
    }


    /**
     * Returns true if the stack is full.
     * 
     * @return true if the stack is full
     */
    public boolean full(){
        if(stack.size() == size)
            return true;
        else
            return false;    
    }


    /**
     * Returns next card from the stack. If stack is empty,
     * returns null.
     * 
     * @return returns next card from the stack
     */
    public Card draw(){
        Card drawn = null;
        if(!empty()){
            drawn = stack.get(0);
            greyvardStack.add(new Card(drawn));
            stack.remove(0);
            return drawn;
        }
        else return null;
    }


    /**
     * Shuffles stack of remaining cards. If stack is not empty,
     * returns true and false if empty.
     * 
     * @return true if stack is not empty
     */
    public boolean shuffle(){
        if(!empty()){
            Collections.shuffle(stack);
            return true;
        }
        else return false;
    }


    /**
     * Put cards from greyvards back to the stack and shuffle them.
     * If greyvard is empty returns false.
     * 
     * @return false if greyvard is empty.
     */
    public boolean refill(){
        if(!full()){
            stack.addAll(greyvardStack);
            shuffle();
            greyvardStack.clear();
            return true;
        }
        else return false;
    }
}