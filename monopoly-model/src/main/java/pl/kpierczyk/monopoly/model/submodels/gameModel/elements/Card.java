package pl.kpierczyk.monopoly.model.submodels.gameModel.elements;



/**
 * Class representing Monopoly's cards that laying on the board
 * are drawn by players when they visit specific "Chance" and 
 * "Deal" fields. Cards indicate either positive or negative
 * bonuses including extra payments and gifts as well as
 * cards enabling to free from the jail.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     CardsStack
 */
public class Card{

    /**Enum describing affiliation of a cart to the particular Stack */
    enum CardType{
        chance, deal
    }
    

    /** Constants for recognising deal cards*/
    public static final int CH_GET_1500 = 1;
    public static final int CH_GET_1000 = 2;
    public static final int CH_GET_500 = 3;

    public static final int CH_PAY_1500 = 4;
    public static final int CH_PAY_200 = 5;
    public static final int CH_PAY_150 = 6;
    public static final int CH_PAY_400A_1150H = 7;
    public static final int CH_PAY_250A_1000H = 8;

    public static final int CH_GO_TO_THIRD_RED = 9;
    public static final int CH_GO_TO_FIRST_PINK = 10;
    public static final int CH_GO_TO_SECOND_NAVY = 11;
    public static final int CH_GO_TO_FIRST_STATION = 12;
    public static final int CH_GO_TO_START = 13;
    public static final int CH_GO_BACK_3 = 14;
    public static final int CH_GO_TO_JAIL = 15;

    public static final int CH_GET_OUT_OF_JAIL = 16;


    /** Constants for recognising chance cards*/
    public static final int D_GET_2000 = 17;
    public static final int D_GET_1000_1 = 18;
    public static final int D_GET_1000_2 = 19;
    public static final int D_GET_500 = 20;
    public static final int D_GET_250 = 21;
    public static final int D_GET_200 = 22;
    public static final int D_GET_100 = 23;
    public static final int D_GET_100_PER_PLAYER = 24;
    
    public static final int D_PAY_1000 = 25;
    public static final int D_PAY_500_1 = 26;
    public static final int D_PAY_500_2 = 27;
    public static final int D_PAY_100_OR_CHANCE = 28;

    public static final int D_BACK_TO_START = 29;
    public static final int D_GO_TO_FIRST_BROWN = 30;
    public static final int D_GO_TO_JAIL = 31;

    public static final int D_GET_OUT_OF_JAIL = 32;



    /** Type of the stack the card belongs to.*/
    private final CardType type;

    /** Description on the card.*/
    private final String text;

    /** Number of the effect recognised by the game.*/
    private final int effect;


    /**
     * Constructor initializing all informations about a card
     * regarding type, description and effect.
     * 
     * @param   type
     * @param   text
     * @param   effect
     * @see     CardType
     */
    public Card(CardType type, String text, int effect){
        this.type = type;
        this.text = text;
        this.effect = effect;
    }


    /**
     * Copying constructor enabling creation of card's copies.
     * 
     * @param card
     */
    public Card(Card card){
        this.type = card.type;
        this.text = new String(card.text);
        this.effect = card.effect;
    }


    /**
     * Returns type of the stack the card belongs to.
     * 
     * @return the type
     */
    public CardType getType() {
        return type;
    }

    /**
     * Returns description on the card.
     * 
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Returns number of the effect recognised by the game.
     * 
     * @return the effect
     */
    public int getEffect() {
        return effect;
    }
}