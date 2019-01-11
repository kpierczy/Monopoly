package pl.kpierczyk.monopoly.model.utilities.settings;


//*******************************************//
//
//
//
//
//
//
//*******************************************//

public class BooleanSetting implements Setting{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    Boolean value;
    final Boolean possibleValues[];



    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public BooleanSetting(Boolean value){
        this.value = value;
        this.possibleValues = new Boolean[] {true, false};
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    @Override
    public Boolean getValue() {
        return value;
    }
    @Override
    public boolean setValue(Object value) {
        if(value instanceof Boolean){
            this.value = (Boolean) value;
            return true;
        }
        else
            return false;
    }

    @Override
    public Boolean[] getPossibleValues() {
        return possibleValues;
    }


    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public boolean nextValue(){
        if(this.value == false)
            this.value = true;
        else
            this.value = false;
        return true;
    }

    public boolean previousValue(){
        if(this.value == false)
            this.value = true;
        else
            this.value = false;
        return true;
    }
}