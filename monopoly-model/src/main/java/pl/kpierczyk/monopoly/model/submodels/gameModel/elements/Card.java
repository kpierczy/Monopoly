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
    public final int CH_GET_2000 = 1;
    public final int CH_GET_1500 = 2;
    public final int CH_GET_1000 = 3;
    public final int CH_GET_500 = 4;

    public final int CH_PAY_1500 = 5;
    public final int CH_PAY_200 = 6;
    public final int CH_PAY_150 = 7;
    public final int CH_PAY_400A_1150H = 8;
    public final int CH_PAY_250A_1000H = 9;

    public final int CH_GO_TO_THIRD_RED = 10;
    public final int CH_GO_TO_FIRST_PINK = 11;
    public final int CH_GO_TO_SECOND_NAVY = 12;
    public final int CH_GO_TO_START = 13;
    public final int CH_GO_BACK_3 = 14;
    public final int CH_GO_TO_JAIL = 15;

    public final int CH_GET_OUT_OF_JAIL = 16;


    /** Constants for recognising chance cards*/
    public final int D_GET_2000 = 17;
    public final int D_GET_1000_1 = 18;
    public final int D_GET_1000_2 = 19;
    public final int D_GET_500 = 20;
    public final int D_GET_250 = 21;
    public final int D_GET_200 = 22;
    public final int D_GET_100 = 23;
    public final int D_GET_100_PER_PLAYER = 24;
    
    public final int D_PAY_1000 = 25;
    public final int D_PAY_500_1 = 26;
    public final int D_PAY_500_2 = 27;
    public final int D_PAY_100_OR_CHANCE = 28;

    public final int D_BACK_TO_START = 29;
    public final int D_GO_TO_SECOND_BROWN = 30;
    public final int D_GO_TO_JAIL = 31;

    public final int D_GET_OUT_OF_JAIL = 32;



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