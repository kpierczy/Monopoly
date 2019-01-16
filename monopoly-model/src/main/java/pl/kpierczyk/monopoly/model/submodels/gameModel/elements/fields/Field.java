package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields;

/**
 * Abstract basic class representing general Monopoly board's
 * field. Each field has its own, unique ID to distinguish it
 * from another of this same kind
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public abstract class Field{

    /** Uniquie ID distinguishing one Field from another */
    private final String ID;

    /** Field's name on the board */
    private final String name;

    /**
     * Initializes new abstract Field baseing on ID number
     * 
     * @param ID
     * @param name
     */
    public Field(String ID,String name){
        this.ID = ID;
        this.name = name;
    }

    /**
     * Returns ID of the field.
     * <p>
     * ID is a unique value that enables to distinguish one field
     * from another of this same kind.
     * 
     * @return the iD
     */
    public final String getID(){
        return ID;
    }
    
    /**
     * Returns name of the field that is displayed on the board.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * 
     * @return statement if objects have the same ID
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Field)
            return (this.ID == ((Field) obj).ID);
        else
            return false;
    }
}