package pl.kpierczyk.monopoly.model.utilities.settings;

//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public interface Setting {

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public Object getValue();
    public boolean setValue(Object value);
    public Object[] getPossibleValues();


    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public boolean nextValue();
    public boolean previousValue();
}