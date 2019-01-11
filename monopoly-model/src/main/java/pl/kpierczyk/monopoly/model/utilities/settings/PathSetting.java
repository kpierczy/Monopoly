package pl.kpierczyk.monopoly.model.utilities.settings;


//*******************************************//
//
//
//
//
//
//
//*******************************************//

public class PathSetting implements Setting{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    String value;


    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public PathSetting(String value){
        this.value = value;
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    @Override
    public String getValue() {
        return value;
    }
    @Override
    public boolean setValue(Object value) {
        if(value instanceof String){
            this.value = (String) value;
            return true;
        }
        else
            return false;
    }

    @Override
    public Object[] getPossibleValues() {
        return null;
    }


    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public boolean nextValue(){
        return true;
    }

    public boolean previousValue(){
        return true;
    }
}