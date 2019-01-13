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

    Object getValue();
    boolean setValue(Object value);
    Object[] getPossibleValues();


    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    boolean nextValue();
    boolean previousValue();
}