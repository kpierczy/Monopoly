package pl.kpierczyk.monopoly.model.utilities.settings;


//*******************************************//
//
// Setting that can be change in the range
// of <x, y>. Value of the setting is
// an Integer.
//
//
//
//*******************************************//

public class InRangeSetting implements Setting{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    Integer value;
    final Integer possibleValues[];



    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public InRangeSetting(Integer value, Integer possibleValues[]){
        this.value = value;
        this.possibleValues = possibleValues;
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    @Override
    public Integer getValue() {
        return value;
    }
    @Override
    public boolean setValue(Object value) {
        if(value instanceof Integer){
            if((Integer) value >= possibleValues[0] &&
               (Integer) value <= possibleValues[1]){
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
    public Integer[] getPossibleValues() {
        return possibleValues;
    }


    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public boolean nextValue(){
        if(this.value < this.possibleValues[1]){
            this.value = this.value + 1;
            return true;
        }
        else
            return false;
    }

    public boolean previousValue(){
        if(this.value > this.possibleValues[0]){
            this.value = this.value - 1;
            return true;
        }
        else
            return false;
    }
}