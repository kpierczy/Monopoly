package pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels;

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

public class TitlesModel{


    /*****************************************/
    /* Class Fields */
    /*****************************************/

    Model model;

    private final String titlesPath; 
    private final String backButtonText;




    /*****************************************/
    /* Constructor */
    /*****************************************/

    public TitlesModel(Model model,
                       String titlesPath,
                       String backButtonText) {
        
        this.model = model;
        this.titlesPath= titlesPath;
        this.backButtonText = backButtonText;
        
    }



    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public String getTitlesPath() {
        return titlesPath;
    }
    public String getBackButtonText() {
        return backButtonText;
    }

    
    
    /*****************************************/
    /* Utilities */
    /*****************************************/

    public void backToMainMenu(){
        this.model.getMainMenuModel().closeChild();
    }
}