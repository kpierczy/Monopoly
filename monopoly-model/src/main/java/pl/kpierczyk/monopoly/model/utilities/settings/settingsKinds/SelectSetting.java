package pl.kpierczyk.monopoly.model.utilities.settings.settingsKinds;

import pl.kpierczyk.monopoly.model.utilities.settings.Setting;

//*******************************************//
//
// Setting that can be selected from the
// group of setts. Value of the setting is
// a String.
//
//
//
//*******************************************//

public class SelectSetting implements Setting{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    int value;
    final String possibleValues[];



    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public SelectSetting(Integer value, String possibleValues[]){
        this.possibleValues = possibleValues;
        if(value >= 0  && value < this.possibleValues.length)
            this.value = value;
    }

    public SelectSetting(SelectSetting selectSetting){
        this.value = selectSetting.value;
        this.possibleValues = selectSetting.possibleValues.clone();
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    @Override
    public String getValue() {
        return this.possibleValues[this.value];
    }
    @Override
    public boolean setValue(Object value) {
        if(value instanceof Integer){
            if((Integer) value >= 0 && (Integer) value < this.possibleValues.length){
                this.value = (Integer) value;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    @Override
    public String[] getPossibleValues() {
        return possibleValues;
    }


    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public boolean nextValue(){
        if(this.value < this.possibleValues.length - 1){
            value++;
            return true;
        }
        else
            return false;
    }

    public boolean previousValue(){
        if(this.value > 0){
            value--;
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return this.possibleValues[this.value];
    }
}