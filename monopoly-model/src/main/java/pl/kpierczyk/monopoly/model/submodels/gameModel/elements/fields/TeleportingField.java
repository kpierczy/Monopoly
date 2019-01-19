package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.abstracts.Field;

/**
 * Class representing Monopoly board's field which, if visited,
 * teleports player to the field with the pointed ID. Example
 * of this kind of field is "Go To Jail".
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Field
 */
public class TeleportingField extends Field{

    /** ID of the field that player is teleported to. */
    final String destinationID;

    /**
     * Initializes Monopoly board's field that teleports
     * player to different field when visited.
     * 
     * @param   ID
     * @param   name
     * @param   destinationID
     * @see     TeleportingField
     */
    public TeleportingField(String ID, String name, String destinationID){
        super(ID, name);
        this.destinationID = destinationID;
    }

    /**
     * Returns ID of the field that player is teleported to.
     * 
     * @return the destinationID
     */
    public final String getDestinationID() {
        return destinationID;
    }

}