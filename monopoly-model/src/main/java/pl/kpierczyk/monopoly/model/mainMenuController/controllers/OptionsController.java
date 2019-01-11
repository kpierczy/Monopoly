package pl.kpierczyk.monopoly.model.mainMenuController.controllers;
import pl.kpierczyk.monopoly.model.utilities.*;
import pl.kpierczyk.monopoly.model.utilities.settings.*;
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

public class OptionsController{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    final Settings settings;
    final String submitButtonText;

    
    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public OptionsController(Settings settings, String textPath){
        this.settings = settings;

        String submitButtonText;
        try {
            FileReader fileReader = 
                new FileReader(textPath);
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            submitButtonText = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException ex) {
            System.out.println("Couldn't read buttons text from" + textPath);
            submitButtonText = "???";
        }

        this.submitButtonText = submitButtonText;
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public Settings getSettings() {
        return settings;
    }
    public String getSubmitButtonText() {
        return submitButtonText;
    }
}