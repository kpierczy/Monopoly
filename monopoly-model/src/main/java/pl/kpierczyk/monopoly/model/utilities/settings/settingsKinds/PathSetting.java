package pl.kpierczyk.monopoly.model.utilities.settings.settingsKinds;

import pl.kpierczyk.monopoly.model.utilities.settings.Setting;

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

    public PathSetting(PathSetting pathSetting){
        this.value = new String(pathSetting.value);
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

    @Override
    public String toString() {
        return this. value;
    }
}