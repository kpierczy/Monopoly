package pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import pl.kpierczyk.monopoly.model.Model;


/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class TitlesModel{

    Model model;

    private final String titlesPath; 
    private final String backButtonText;

    public TitlesModel(Model model,
                       String titlesPath,
                       String backButtonTextPath) {
        
        this.model = model;
        this.titlesPath= titlesPath;
        

        /*Reading back button's text*/
        String backButtonText;

        try {
            FileReader fileReader =
                new FileReader(backButtonTextPath);
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            backButtonText = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Couldn't read buttons text from" + backButtonTextPath);
            backButtonText = "???";
        }

        this.backButtonText = backButtonText;
    }

    public String getTitlesPath() {
        return titlesPath;
    }
    public String getBackButtonText() {
        return backButtonText;
    }



    
    
    
    /*****************************************/
    /* Utilities */
    /*****************************************/

    public boolean backToMainMenu(){
        return this.model.getMainMenuModel().closeChild();
    }
}