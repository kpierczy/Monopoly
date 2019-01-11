package pl.kpierczyk.monopoly.model.utilities;
import java.io.*;




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
    


    /*****************************************/
    /*              Constructor              */
    /*****************************************/

    public Menu(String textPath_t, int fieldsNumber) {
        
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

