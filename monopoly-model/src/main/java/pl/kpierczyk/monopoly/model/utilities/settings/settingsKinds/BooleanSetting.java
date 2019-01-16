package pl.kpierczyk.monopoly.model.utilities.settings.settingsKinds;

import pl.kpierczyk.monopoly.model.utilities.settings.Setting;

/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class BooleanSetting implements Setting{

    boolean value;
    final boolean possibleValues[];

    public BooleanSetting(Boolean value){
        this.value = value;
        this.possibleValues = new boolean[] {true, false};
    }

    public BooleanSetting(BooleanSetting booleanSetting){
        this.value = booleanSetting.value;
        this.possibleValues = booleanSetting.possibleValues.clone();
    }

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
        Boolean possibleValues[] = new Boolean[this.possibleValues.length];
        for(int i = 0; i < possibleValues.length; i++){
            possibleValues[i] = Boolean.valueOf(this.possibleValues[i]);
       }
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

    public void switchValue(){
        if(this.value == false)
            this.value = true;
        else
            this.value = false;
    }

    @Override
    public String toString() {
        if(this.value == true)
            return "on";
        else
            return "off";
    }
}