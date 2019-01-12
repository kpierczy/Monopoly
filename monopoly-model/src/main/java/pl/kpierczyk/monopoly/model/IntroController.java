package pl.kpierczyk.monopoly.model;



//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class IntroController{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    final String begginingMoviePath;
    final String ommitButtonText;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public IntroController(String begginingMoviePath, String ommitButtonPath){
        this.begginingMoviePath = begginingMoviePath;
        this.ommitButtonText = ommitButtonPath;
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public String getBegginingMoviePath() {
        return begginingMoviePath;
    }
    public String getOmmitButtonText() {
        return ommitButtonText;
    }

    /*****************************************/
    /*              Utilities                */
    /*****************************************/
}