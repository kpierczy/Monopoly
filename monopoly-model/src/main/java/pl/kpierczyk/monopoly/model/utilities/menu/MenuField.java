package pl.kpierczyk.monopoly.model.utilities.menu;




/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class MenuField {

    private final String fieldText;
    private boolean active;

    MenuField(String fieldText) {
        this.fieldText = fieldText;
        this.active = true;
    }

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