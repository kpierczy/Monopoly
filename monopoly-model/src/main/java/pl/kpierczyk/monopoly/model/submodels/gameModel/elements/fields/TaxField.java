package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields;


/**
 * Class representing Tax field on the Monopoly's board.
 * Visiting Tax field player is obliged to pay certain
 * amount of money to the bank.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Field
 */
public class TaxField extends Field{
    
    /** Amount of cash payed by the player visiting this field */
    private final int taxValue;

    /**
     * Initializes new TaxField that represents Monopoly board's
     * tax field.
     * 
     * @param   ID
     * @param   name
     * @param   taxValue
     * @see     TaxField
     */
    public TaxField(String ID, String name,
                    int taxValue){
        super(ID, name);
        this. taxValue = taxValue;
    } 

    /**
     * Returns amount of cash paid by the player
     * visiting this field.
     * 
     * @return the taxValue
     */
    public final int getTaxValue() {
        return taxValue;
    }

}