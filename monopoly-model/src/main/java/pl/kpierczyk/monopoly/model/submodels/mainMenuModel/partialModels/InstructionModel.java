package pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels;

import java.io.*;

import pl.kpierczyk.monopoly.model.Model;










//*******************************************//
//
//
//
//
//
//
//
//*******************************************//


public class InstructionModel {


    /*****************************************/
    /* Class Fields */
    /*****************************************/

    /*Invisible*/

    Model model;

    private final int pagesNumber; // number of pages
    private int actualPage; // actual displayed page
    
    private final String instructionHome; // path to the folder with pages

    /*Visible*/
    private final String backButtonText;

    


    /*****************************************/
    /* Constructor */
    /*****************************************/

    public InstructionModel(Model model,
                            String instructionHome,
                            String backButtonText) {
        
        /*Initializing invisible elements*/

        this.model = model;
        
        this.pagesNumber = new File(instructionHome).listFiles().length;
        this.actualPage = 1;
        
        this.instructionHome = instructionHome;
        

        /*Initializing visible elements*/
        this.backButtonText = backButtonText;
    }




    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public String getActualPagePath() {
        return instructionHome +
               Integer.toString(actualPage);
    }

    public String getBackButtonText() {
        return backButtonText;
    }

    
    /*****************************************/
    /*               Utilities               */
    /*****************************************/

    public boolean nextPage() {
        if (actualPage < pagesNumber){
            actualPage++;
            return true;
        }
        else
            return false;
    }

    public boolean previousPage() {
        if (actualPage > 1){
            actualPage--;
            return true;
        }
        else
            return false;
    }

    public void backToMainMenu(){
        this.model.getMainMenuModel().closeChild();
    }
}
