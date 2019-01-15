package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields;

/**
 * Class representing Monopoly board's neutral field like
 * "Parking" or "Jail". WHen player visits this field,
 * nothing happens.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Field
 */
public class NeutralField extends Field{

    /**
     * Initializes new neutral Monopoly board's field.
     * In fact this is a creatable version of abstract Field.
     * 
     * @param   ID
     * @param   name
     * @see     NeutralField
     */
    public NeutralField(String ID, String name){
        super(ID, name);
    }
}