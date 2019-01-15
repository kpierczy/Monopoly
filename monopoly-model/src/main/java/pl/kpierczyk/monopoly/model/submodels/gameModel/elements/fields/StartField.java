package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields;


/**
 * Class representing "Start" field on the board. When player
 * goes over this field, they get certain amount of money.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Field
 */
public class StartField extends Field{

    /** Amount of cash get by the player who goes over this field. */
    private final int startBenefit;

    /**
     * Initializes Start
     * 
     * @param   ID
     * @param   name
     * @param   startBenefit
     * @see     StartField
     */
    public StartField(String ID, String name, int startBenefit){
        super(ID, name);
        this.startBenefit = startBenefit;
    }

    /**
     * Returns amount of cash that players get going over thet
     * "Start" field.
     * 
     * @return the startBenefit
     */
    public final int getStartBenefit() {
        return startBenefit;
    }

}