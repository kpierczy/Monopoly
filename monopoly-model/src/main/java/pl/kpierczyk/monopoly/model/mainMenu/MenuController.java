package pl.kpierczyk.monopoly.model.mainMenu;
import java.io.*;

public class MenuController {


    /*****************************************/
    /*            Class Fields               */
    /*****************************************/
    
    private final MenuField menuFields[];
    

    /*****************************************/
    /*              Constructor              */
    /*****************************************/

    public MenuController(String textPath_t, int fieldsNumber) {
        
        menuFields = new MenuField[fieldsNumber];
        try {
            FileReader fileReader = 
                new FileReader(textPath_t);
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            String line = null;
            for (int i = 0; i < menuFields.length; i++) {
                if((line = bufferedReader.readLine()) != null){
                    menuFields[i] = new MenuField(line);
                }
            }

            bufferedReader.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + textPath_t + "'");
            for (int i = 0; i < menuFields.length; i++) {
                menuFields[i] = new MenuField("???");
            }
        } 
        catch (IOException ex) {
            System.out.println("Error reading file '" + textPath_t + "'");
            for (int i = 0; i < menuFields.length; i++) {
                menuFields[i] = new MenuField("???");
            }
        }
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
}


class MenuField {

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

    public String getFieldText() { return fieldText; }

    public boolean isActive() { return active;}
    public void setActive(boolean active_t) { active = active_t;}
}