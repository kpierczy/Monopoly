package pl.kpierczyk.monopoly.model.submodels.gameModel.elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Card.CardType;

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

    private final CardType cardsType;

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
    public CardsStack(int size, CardType type){
        this.size = size;
        //<--- WARNING -->
        //It can assign object that will be disappear in a while.
        //Not sure how java works.
        this.stack = new ArrayList<Card>(size);
        this.greyvardStack = new ArrayList<Card>(size);
        this.cardsType = type;
    }

    /**
     * Returns size of the stack.
     * 
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns type of cards stored in the stack.
     * 
     * @return type of cards stored in the stack.
     */
    public CardType getCardsType() {
        return cardsType;
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




    /**
     * Loads stack of cards from specified file.
     * If loading fail, nothig changes in the stack
     * and false is returned. Otherwise, stack is set
     * and greyvard is cleaned.
     * 
     * @param file
     * @return false if loading fail.
     */
    public boolean loadFromFile(String file){
        if(file != null){ 
            
            //potential new stack
            ArrayList<Card> potentialStack = 
                new ArrayList<Card>();
            
            try{
                //getting connection with file
                BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(file)));

                //here lines from file are read
                String line;

                //number of cards loaded
                int i = 0;

                /** <-- IMPORTANT -->*/
                /** First line of the file should be empty.*/
                for(i = 0; (i < size) && ((line = bufferedReader.readLine()) != null); i++){
                    Card.CardType type;
                    String text;
                    int effect;

                    //card type should be established
                    type = this.cardsType;

                    if((line = bufferedReader.readLine()) != null)
                        text = new String(line.getBytes(), "UTF-8");
                    else{
                        bufferedReader.close();
                        return false;
                    }

                    //effect establishing
                    if((line = bufferedReader.readLine()) != null)
                        effect = Integer.parseInt(line);
                    else{
                        bufferedReader.close();
                        return false;
                    }

                    //creating new stack
                    potentialStack.add(i, new Card(type, text, effect) ) ;
                }

                //checks if all 'size' cards has been loaded
                if(i < size)
                    return false;                    
            }
            catch(Exception ex){
                return false;
            }

            stack = potentialStack;
            greyvardStack.clear();
            return true;
        }
        else return false;     
    }
}