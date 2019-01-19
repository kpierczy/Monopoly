package pl.kpierczyk.monopoly.model.submodels.gameModel.elements;

import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.Field;

/**
 * Class representing Monopoly's boards. Storages references to Field's
 * objects and stacks of drawable cards.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Field
 */
public class Board{

    /** Default size of card's stacks.*/
    public final int STACKS_SIZE = 16;

    /** Path to the directory of cards images.*/
    private final String FIELDS_PATH;

    /** List of fields representing board*/
    private ArrayList<Field> board = new ArrayList<Field>(40);

    /** Stacks of chance and deal drawable cards.*/
    private CardsStack chanceCards;
    private CardsStack dealCards;
    
    /** Directory of fields' graphics.*/
    String fieldsGraphicsFolder;


    public Board(){
        
    }
}