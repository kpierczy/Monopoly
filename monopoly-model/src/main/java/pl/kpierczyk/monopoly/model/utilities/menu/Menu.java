package pl.kpierczyk.monopoly.model.utilities.menu;





//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class Menu {




    /*****************************************/
    /*            Class Fields               */
    /*****************************************/
    
    private final MenuField menuFields[];
    private final int positionNumbers;
    


    /*****************************************/
    /*              Constructor              */
    /*****************************************/

    public Menu(String fieldsText[], int positionNumbers) {
        
        this.menuFields = new MenuField[fieldsText.length];
        for(int i = 0; i < positionNumbers; i++){
            this.menuFields[i] = new MenuField(fieldsText[i]);
        }
        this.positionNumbers = positionNumbers;
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public MenuField[] getMenuFields() { return menuFields; }

    public MenuField getMenuField(int fieldNumber) {
        if(fieldNumber >= menuFields.length || fieldNumber < 0)
            return null;
        else
            return menuFields[fieldNumber];  
    }

    public int getPositionNumbers() {
        return positionNumbers;
    }

    public String[] getMenuText(){
        String menuText[] = new String[this.menuFields.length];

        for(int i = 0; i < menuText.length; i++){
            menuText[i] = getMenuField(i).getFieldText();
        }

        return menuText;
    }
}

