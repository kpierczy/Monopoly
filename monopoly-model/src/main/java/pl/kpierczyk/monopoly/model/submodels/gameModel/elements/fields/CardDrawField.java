package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields;




/**
 * Class representing card-draw Monopoly board's field.
 * There are two kinds of cards in Monopoly: chance cards
 * and deal cards, so there are also two kinds of card-draw
 * fields.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Field
 */
public class CardDrawField extends Field{

    public enum CardKind{
        chance, deal
    }

    /** Kind of the card to draw when field visited.*/
    private final CardKind kind;


    /**
     * Initializes the Monopoly board's card-draw field, basing
     * on field's basic params and choosen kind.
     * 
     * @param   ID
     * @param   name
     * @param   kind
     * @see     CardDrawField
     */
    public CardDrawField(String ID, String name , CardKind kind){
        super(ID, name);
        this.kind = kind;
    }


    /**
     * Returns kind of the CardKind representing kind of card
     * that is drawn when field is visited.
     * 
     * @return  the kind of the card drawn
     */
    public final CardKind getKind() {
        return kind;
    }
}