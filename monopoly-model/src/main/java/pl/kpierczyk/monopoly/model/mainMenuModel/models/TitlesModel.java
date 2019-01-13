package pl.kpierczyk.monopoly.model.mainMenuModel.models;







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

    /*Visible*/
    private final String titlesPath; // path to the folder with pages
    private final String backButtonText;




    /*****************************************/
    /* Constructor */
    /*****************************************/

    public TitlesModel(String titlesPath, String backButtonText) {
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
}