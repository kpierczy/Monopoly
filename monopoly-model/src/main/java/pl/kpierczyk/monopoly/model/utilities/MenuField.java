package pl.kpierczyk.monopoly.model.utilities;




//*******************************************//
//
//
//
//
//
//
//
//*******************************************//


public class MenuField {

    /*****************************************/
    /*             Class Fields              */
    /*****************************************/

    private final String fieldText;
    private boolean active;

    /*****************************************/
    /*              Constructor              */
    /*****************************************/

    MenuField(String fieldText_t) {
        fieldText = fieldText_t;
        active = true;
    }

    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public String getFieldText() {
        return fieldText;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}